package me.hyfe.simplespigot.storage.storage;

import me.hyfe.simplespigot.storage.Backend;

public abstract class DynamicStorage<T> extends Storage<T> {

    public DynamicStorage(Backend backend) {
        super(backend);
    }
}
