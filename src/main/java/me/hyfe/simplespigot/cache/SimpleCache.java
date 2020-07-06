package me.hyfe.simplespigot.cache;

import java.util.Optional;
import java.util.function.Function;

public class SimpleCache<K, V> extends CacheWrapper<K, V> {

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
}
