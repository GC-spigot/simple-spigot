package me.javadebug.simplespigot.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.Optional;
import java.util.function.Function;

public class SimpleCache<K, V> {
    private final Cache<K, V> subCache;

    public SimpleCache() {
        this.subCache = CacheBuilder.newBuilder().build();
    }

    public Cache<K, V> getSubCache() {
        return this.subCache;
    }

    public Optional<V> get(K key) {
        return Optional.ofNullable(this.subCache.getIfPresent(key));
    }

    public V get(K key, Function<K, V> entryIfAbsent) {
        V value = this.subCache.getIfPresent(key);
        if (value == null) {
            this.subCache.put(key, entryIfAbsent.apply(key));
        }
        return value;
    }

    public V set(K key, V value) {
        this.subCache.put(key, value);
        return value;
    }

    public void invalidate(K key) {
        this.subCache.invalidate(key);
    }
}
