package me.hyfe.simplespigot.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import me.hyfe.simplespigot.plugin.SimplePlugin;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class FutureCache<K, V> {
    protected final SimplePlugin plugin;
    private final Cache<K, V> subCache;

    public FutureCache(SimplePlugin plugin) {
        this.plugin = plugin;
        this.subCache = CacheBuilder.newBuilder().build();
    }

    public Cache<K, V> getSubCache() {
        return this.subCache;
    }

    public CompletableFuture<Optional<V>> get(K key) {
        return this.plugin.asyncCallback(() -> Optional.ofNullable(this.subCache.getIfPresent(key)));
    }

    public CompletableFuture<V> get(K key, Function<K, V> entryIfAbsent) {
        return this.plugin.asyncCallback(() -> {
            V value = this.subCache.getIfPresent(key);
            if (value == null) {
                this.subCache.put(key, entryIfAbsent.apply(key));
            }
            return value;
        });
    }

    public Optional<V> getSync(K key) {
        return Optional.ofNullable(this.subCache.getIfPresent(key));
    }

    public V set(K key, V value) {
        this.subCache.put(key, value);
        return value;
    }

    public void invalidate(K key) {
        this.subCache.invalidate(key);
    }
}
