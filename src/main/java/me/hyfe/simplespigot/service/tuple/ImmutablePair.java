package me.hyfe.simplespigot.service.tuple;

public class ImmutablePair<K, V> {
    private final K key;
    private final V value;

    public ImmutablePair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public static <S, U> ImmutablePair<S, U> of(S key, U value) {
        return new ImmutablePair<>(key, value);
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }
}
