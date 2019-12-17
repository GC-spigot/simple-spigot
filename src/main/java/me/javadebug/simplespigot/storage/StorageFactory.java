package me.javadebug.simplespigot.storage;

import me.javadebug.simplespigot.storage.types.FlatStorage;
import me.javadebug.simplespigot.storage.types.MongoStorage;
import me.javadebug.simplespigot.storage.types.mysql.MySqlStorage;

public class StorageFactory {

    public <T> StorageInterface<T> create(StorageType storageType) {
        switch (storageType) {
            case MYSQL:
                return new MySqlStorage<T>();
            case MONGODB:
                return new MongoStorage<T>();
            default:
                return new FlatStorage<T>();
        }
    }
}
