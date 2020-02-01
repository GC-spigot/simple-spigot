package me.javadebug.simplespigot.collection.tuple;

public class MutablePair<K, V> {
    private K key;
    private V value;

    public MutablePair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public static <S, U> MutablePair<S, U> of(S key, U value) {
        return new MutablePair<>(key, value);
    }
}
