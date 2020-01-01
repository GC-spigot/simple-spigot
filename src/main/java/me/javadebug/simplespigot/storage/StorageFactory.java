package me.javadebug.simplespigot.storage;

import me.javadebug.simplespigot.plugin.SimplePlugin;
import me.javadebug.simplespigot.storage.storage.StorageType;
import me.javadebug.simplespigot.storage.types.FlatBackend;
import me.javadebug.simplespigot.storage.types.MongoBackend;
import me.javadebug.simplespigot.storage.types.mysql.MySqlBackend;

import java.nio.file.Path;

public class StorageFactory {
    private final SimplePlugin plugin;

    public StorageFactory(SimplePlugin plugin) {
        this.plugin = plugin;
    }

    public Backend create(StorageType storageType, String tableName, Path flatPath) {
        switch (storageType) {
            case MYSQL:
                return new MySqlBackend(this.plugin, tableName);
            case MONGODB:
                return new MongoBackend();
            default:
                return new FlatBackend(flatPath);
        }
    }
}
