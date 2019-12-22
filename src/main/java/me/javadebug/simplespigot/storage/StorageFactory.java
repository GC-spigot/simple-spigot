package me.javadebug.simplespigot.storage;

import me.javadebug.simplespigot.plugin.SimplePlugin;
import me.javadebug.simplespigot.storage.storage.StorageType;
import me.javadebug.simplespigot.storage.storage.load.Deserializer;
import me.javadebug.simplespigot.storage.storage.load.Serializer;
import me.javadebug.simplespigot.storage.types.FlatStorage;
import me.javadebug.simplespigot.storage.types.MongoStorage;
import me.javadebug.simplespigot.storage.types.mysql.MySqlStorage;

import java.nio.file.Path;

public class StorageFactory {
    private final SimplePlugin plugin;

    public StorageFactory(SimplePlugin plugin) {
        this.plugin = plugin;
    }

    public <T> Backend<T> create(StorageType storageType, Deserializer<T> deserializer, Serializer<T> serializer, Path flatPath, String tableName) {
        switch (storageType) {
            case MYSQL:
                return new MySqlStorage<T>(this.plugin, tableName, deserializer, serializer);
            case MONGODB:
                return new MongoStorage<T>(deserializer, serializer);
            default:
                return new FlatStorage<T>(flatPath, deserializer, serializer);
        }
    }
}
