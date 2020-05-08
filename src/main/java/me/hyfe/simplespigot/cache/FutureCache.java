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

    /**
     * @param plugin Your instance of SimplePlugin - should be the main class.
     */
    public FutureCache(SimplePlugin plugin) {
        this.plugin = plugin;
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
     * Gets the value of an associated key from the cache.
     *
     * @param key The key used to match to the value.
     * @return An optional of the cache value that may be empty inside a completable future.
     */
    public CompletableFuture<Optional<V>> get(K key) {
        return this.plugin.asyncCallback(() -> Optional.ofNullable(this.subCache.getIfPresent(key)));
    }

    /**
     * Gets a value from the cache and runs a function if it not present.
     *
     * @param key           The key used to match to the value.
     * @param entryIfAbsent The actions to perform with the values if the requested key is not present.
     * @return A completable future of the value.
     */
    public CompletableFuture<V> get(K key, Function<K, V> entryIfAbsent) {
        return this.plugin.asyncCallback(() -> {
            V value = this.subCache.getIfPresent(key);
            if (value == null) {
                this.subCache.put(key, entryIfAbsent.apply(key));
            }
            return value;
        });
    }

    /**
     * Gets a value non async
     *
     * @param key The key used to match to the value.
     * @return An optional of the cache value that may be empty.
     */
    public Optional<V> getSync(K key) {
        return Optional.ofNullable(this.subCache.getIfPresent(key));
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
     * Invalidates all entries in the cache.
     */
    public void invalidateAll() {
        this.subCache.invalidateAll();
    }
}
