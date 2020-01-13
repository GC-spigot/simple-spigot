package me.javadebug.simplespigot.storage.storage;

import me.javadebug.simplespigot.plugin.SimplePlugin;
import me.javadebug.simplespigot.storage.Backend;

import java.util.function.Function;

public abstract class DynamicStorage<T> extends Storage<T> {

    public DynamicStorage(SimplePlugin plugin, Function<Storage<T>, Backend> backend) {
        super(plugin, backend);
    }
}
