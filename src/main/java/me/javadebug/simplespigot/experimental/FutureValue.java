package me.javadebug.simplespigot.experimental;

import com.google.common.collect.Lists;
import me.javadebug.simplespigot.service.Locks;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.locks.Lock;

public class FutureValue<V> {
    public static final AtomicIntegerFieldUpdater<FutureValue> STATE = AtomicIntegerFieldUpdater.newUpdater(FutureValue.class, "state");

    private final CompletableFuture<V> future = new CompletableFuture<>();
    private final Lock lock = Locks.newReentrantLock(true);
    private List<Runnable> deletionCallbacks = Lists.newArrayList();
    private volatile boolean fulfilled;
    private volatile int state = 0;

    public CompletableFuture<V> getFuture() {
        return this.future;
    }

    public Lock getLock() {
        return this.lock;
    }

    public List<Runnable> getDeletionCallbacks() {
        return this.deletionCallbacks;
    }

    public void setDeletionCallbacks(List<Runnable> deletionCallbacks) {
        this.deletionCallbacks = deletionCallbacks;
    }

    public boolean isFulfilled() {
        return this.fulfilled;
    }

    public void setFulfilled(boolean fulfilled) {
        this.fulfilled = fulfilled;
    }

    public int getState() {
        return this.state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
