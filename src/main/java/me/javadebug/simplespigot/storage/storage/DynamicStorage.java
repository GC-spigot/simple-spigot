package me.javadebug.simplespigot.storage.storage;

import me.javadebug.simplespigot.storage.Backend;

public abstract class DynamicStorage<T> extends Storage<T> {

    public DynamicStorage(Backend backend) {
        super(backend);
    }
}
