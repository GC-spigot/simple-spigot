package me.javadebug.simplespigot.storage;

import me.javadebug.simplespigot.plugin.SimplePlugin;
import me.javadebug.simplespigot.storage.storage.Storage;

import java.util.function.Function;

public class StorageProvider {

    public static <T> Storage<T> provide(SimplePlugin plugin, Function<BackendFactory, Backend> backend, Function<Backend, Storage<T>> instance) {
        return instance.apply(backend.apply(new BackendFactory(plugin)));
    }

    public static <T> Storage<T> provide(BackendFactory backendFactory, Function<BackendFactory, Storage<T>> instance) {
        return instance.apply(backendFactory);
    }
}
