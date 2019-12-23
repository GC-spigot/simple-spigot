package me.javadebug.simplespigot.storage;

import me.javadebug.simplespigot.plugin.SimplePlugin;
import me.javadebug.simplespigot.storage.storage.StorageType;
import me.javadebug.simplespigot.storage.types.FlatStorage;
import me.javadebug.simplespigot.storage.types.MongoStorage;
import me.javadebug.simplespigot.storage.types.mysql.MySqlStorage;

import java.nio.file.Path;

public class StorageFactory {
    private final SimplePlugin plugin;

    public StorageFactory(SimplePlugin plugin) {
        this.plugin = plugin;
    }

    public <T> Backend<T> create(StorageType storageType, String tableName, Path flatPath) {
        switch (storageType) {
            case MYSQL:
                return new MySqlStorage<T>(this.plugin, tableName);
            case MONGODB:
                return new MongoStorage<T>();
            default:
                return new FlatStorage<T>(flatPath);
        }
    }
}
