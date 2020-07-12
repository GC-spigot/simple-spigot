package me.hyfe.simplespigot.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.Collection;
import java.util.Set;
import java.util.function.UnaryOperator;

public class CacheWrapper<K, V> {
    protected final Cache<K, V> subCache;

    public CacheWrapper() {
        this.subCache = CacheBuilder.newBuilder().build();
    }

    public CacheWrapper(UnaryOperator<CacheBuilder<Object, Object>> builder) {
        this.subCache = builder.apply(CacheBuilder.newBuilder()).build();
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

    /**
     * Checks if the specified key is present in the cache
     *
     * @param key the key
     * @return if the key is present
     */
    public boolean hasKey(K key) {
        return this.subCache.asMap().containsKey(key);
    }

    /**
     * Checks if the specified value is present in the cache
     *
     * @param value the value
     * @return if the value is present
     */
    public boolean hasValue(V value) {
        return this.subCache.asMap().containsValue(value);
    }
}
