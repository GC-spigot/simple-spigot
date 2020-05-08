package me.hyfe.simplespigot.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

public class SimpleCache<K, V> {
    private final Cache<K, V> subCache;

    public SimpleCache() {
        this.subCache = CacheBuilder.newBuilder().build();
    }

    /**
     * Gets the cache inside the future cache.
     *
     * @return The contained cache
     */
    public Cache<K, V> getSubCache() {
        return this.subCache;
    }

    /**
     * Gets a value non async
     *
     * @param key The key used to match to the value.
     * @return An optional of the cache value that may be empty.
     */
    public Optional<V> get(K key) {
        return Optional.ofNullable(this.subCache.getIfPresent(key));
    }

    /**
     * Gets a value from the cache and runs a function if it not present.
     *
     * @param key           The key used to match to the value.
     * @param entryIfAbsent The actions to perform with the values if the requested key is not present.
     * @return The value inserted if absent or gotten from the cache.
     */
    public V get(K key, Function<K, V> entryIfAbsent) {
        V value = this.subCache.getIfPresent(key);
        if (value == null) {
            this.subCache.put(key, entryIfAbsent.apply(key));
        }
        return value;
    }

    /**
     * Sets a value in the cache.
     *
     * @param key   The key used to identify the value.
     * @param value The value associated with the key.
     * @return The value inserted in the parameters.
     */
    public V set(K key, V value) {
        this.subCache.put(key, value);
        return value;
    }

    /**
     * Removes a key and value from the cache if present.
     *
     * @param key The key to remove from the cache if present.
     */
    public void invalidate(K key) {
        this.subCache.invalidate(key);
    }

    /**
     * Gets all of the keys in the cache.
     *
     * @return A set of all the keys in the cache.
     */
    public Set<K> keySet() {
        return this.subCache.asMap().keySet();
    }

    /**
     * Gets all of the values in the cache.
     *
     * @return A set of all the values in the cache.
     */
    public Collection<V> values() {
        return this.subCache.asMap().values();
    }
}
