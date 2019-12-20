package me.javadebug.simplespigot.storage.storage;

import com.google.gson.JsonObject;
import me.javadebug.simplespigot.plugin.SimplePlugin;
import me.javadebug.simplespigot.storage.StorageInterface;
import me.javadebug.simplespigot.storage.types.mysql.sql.QueryType;

import java.util.function.BiFunction;
import java.util.function.Function;

public abstract class DynamicStorage<T> {
    private final StorageInterface<T> storageInterface;
    private final BiFunction<T, JsonObject, JsonObject> serializer;
    private final Function<JsonObject, T> deserializer;

    public DynamicStorage(SimplePlugin plugin, StorageType storageType) {
        this.storageInterface = plugin.getStorageFactory().create(storageType);
        this.serializer = this.serializer();
        this.deserializer = this.deserializer();
    }

    public abstract BiFunction<T, JsonObject, JsonObject> serializer();

    public abstract Function<JsonObject, T> deserializer();

    public T load(String identifier) {
        JsonObject jsonObject = this.storageInterface.load(identifier);
        return this.deserializer.apply(jsonObject);
    }

    public T save(T object) {
        JsonObject jsonObject = this.serializer.apply(object, new JsonObject());
        return storageInterface.save(jsonObject);
    }

    public void closeInterface() {
        this.storageInterface.close();
    }

    protected void setTableQuery(String restOfQuery) {
        QueryType.CREATE_TABLE.query(restOfQuery);
    }

    protected void setSelectQuery(String restOfQuery) {
        QueryType.SELECT.query(restOfQuery);
    }

    protected void setInsertQuery(String restOfQuery) {
        QueryType.INSERT.query(restOfQuery);
    }

    protected void setDeleteQuery(String restOfQuery) {
        QueryType.DELETE.query(restOfQuery);
    }
}
