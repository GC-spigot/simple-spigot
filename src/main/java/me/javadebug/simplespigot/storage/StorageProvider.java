package me.javadebug.simplespigot.storage;

import me.javadebug.simplespigot.storage.storage.Storage;
import me.javadebug.simplespigot.storage.storage.StorageType;

import java.util.function.Function;

public class StorageProvider {

    public static <T> Storage<T> provide(String storageType, Function<StorageType, Storage<T>> instance) {
        switch (storageType) {
            case "mysql": {
                return instance.apply(StorageType.MYSQL);
            }
            case "mongodb": {
                return instance.apply(StorageType.MONGODB);
            }
            default: {
                return instance.apply(StorageType.FLAT);
            }
        }
    }
}
