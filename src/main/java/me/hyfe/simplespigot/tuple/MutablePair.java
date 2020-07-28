package me.hyfe.simplespigot.tuple;

import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class MutablePair<K, V> {
    private K key;
    private V value;

    public MutablePair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public static <S, U> MutablePair<S, U> of(S key, U value) {
        return new MutablePair<>(key, value);
    }

    public K getKey() {
        return this.key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return this.value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
