package me.javadebug.simplespigot.storage;

import me.javadebug.simplespigot.plugin.SimplePlugin;
import me.javadebug.simplespigot.storage.storage.StorageType;
import me.javadebug.simplespigot.storage.types.FlatStorage;
import me.javadebug.simplespigot.storage.types.MongoStorage;
import me.javadebug.simplespigot.storage.types.mysql.MySqlStorage;

public class StorageFactory {
    private final SimplePlugin plugin;

    public StorageFactory(SimplePlugin plugin) {
        this.plugin = plugin;
    }

    public <T> StorageInterface<T> create(StorageType storageType) {
        switch (storageType) {
            case MYSQL:
                return new MySqlStorage<T>(plugin, null);
            case MONGODB:
                return new MongoStorage<T>();
            default:
                return new FlatStorage<T>();
        }
    }
}
