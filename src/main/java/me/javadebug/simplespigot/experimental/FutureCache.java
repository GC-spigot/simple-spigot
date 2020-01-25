package me.javadebug.simplespigot.experimental;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.Lists;
import me.javadebug.simplespigot.plugin.SimplePlugin;
import me.javadebug.simplespigot.service.Locks;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.locks.Lock;
import java.util.function.Function;
import java.util.function.Predicate;

public class FutureCache<K, V> {
    private static final int MAX_RECURSION_DEPTH = 64;
    private static final int VALID = 0;
    private static final int INVALID = 1;
    private static final int EVICTED = 2;

    private final SimplePlugin plugin;
    private final Cache<K, FutureValue<V>> subCache;

    public FutureCache(SimplePlugin plugin) {
        this.plugin = plugin;
        this.subCache = CacheBuilder.newBuilder().build();
    }

    public boolean tryRemove(K key, Predicate<V> predicate) {
        FutureValue<V> futureValue = this.subCache.getIfPresent(key);
        if (futureValue == null || !futureValue.isFulfilled() || !FutureValue.STATE.compareAndSet(futureValue, VALID, INVALID)) {
            return false;
        }
        Lock lock = futureValue.getLock();
        return Locks.supplySafety(lock, () -> {
            CompletableFuture<V> future = futureValue.getFuture();
            return future.thenApply(predicate::test)
                    .exceptionally(ex -> {
                        ex.printStackTrace();
                        return false;
                    }).thenApply(result -> {
                        if (!result) {
                            FutureValue.STATE.compareAndSet(futureValue, INVALID, VALID);
                        } else {
                            this.subCache.invalidate(key);
                        }
                        List<Runnable> callbackCopies;
                        synchronized (futureValue) {
                            List<Runnable> callbacks = futureValue.getDeletionCallbacks();
                            if (!callbacks.isEmpty()) {
                                callbackCopies = Lists.newArrayList(callbacks);
                                futureValue.setDeletionCallbacks(Lists.newArrayList());
                            } else {
                                callbackCopies = Collections.emptyList();
                            }
                            if (result) {
                                FutureValue.STATE.compareAndSet(futureValue, INVALID, EVICTED);
                            }
                            this.plugin.runAsync(() -> {
                                for (Runnable callback : callbackCopies) {
                                    callback.run();
                                }
                            });
                            return result;
                        }
                    }).join();
        });
    }

    private <T> CompletableFuture<T> transform(K key, Function<V, T> function, int depth) {
        if (depth == MAX_RECURSION_DEPTH) {
            return null;
        }
        FutureValue<V> future = this.subCache.getIfPresent(key);
        if (future == null) {
            return null;
        }
        Lock lock = future.getLock();
        if (!lock.tryLock()) {
            synchronized (future) {
                List<Runnable> callbacks = future.getDeletionCallbacks();
                int state = FutureValue.STATE.get(future);

                if (state == INVALID) {
                    CompletableFuture<T> result = new CompletableFuture<>();
                    callbacks.add(() -> this.transform(key, newFuture -> result.complete(function.apply(newFuture)), depth + 1));
                    return result;
                } else if (state == EVICTED) {
                    return this.transform(key, function, depth + 1);
                }
            }
            lock.lock();
        }
        try {
            if (FutureValue.STATE.get(future) == EVICTED) {
                return this.transform(key, function, depth + 1);
            }
            CompletableFuture<V> completableFuture = future.getFuture();
            return completableFuture.thenApply(function)
                    .exceptionally(ex -> {
                        ex.printStackTrace();
                        return null;
                    });
        } finally {
            lock.unlock();
        }
    }
}
