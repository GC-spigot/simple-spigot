package me.javadebug.simplespigot.storage.storage;

import com.google.gson.JsonObject;
import me.javadebug.simplespigot.plugin.SimplePlugin;
import me.javadebug.simplespigot.storage.Backend;
import me.javadebug.simplespigot.storage.storage.load.Deserializer;
import me.javadebug.simplespigot.storage.storage.load.Serializer;
import me.javadebug.simplespigot.storage.types.mysql.sql.QueryType;

import java.nio.file.Path;

public abstract class DynamicStorage<T> {
    private final SimplePlugin plugin;
    private final StorageType storageType;

    private Backend<T> back;

    public DynamicStorage(SimplePlugin plugin, StorageType storageType) {
        this.plugin = plugin;
        this.storageType = storageType;
    }

    public abstract Serializer<T> serializer();

    public abstract Deserializer<T> deserializer();

    public T load(String identifier) {
        JsonObject jsonObject = this.back.load(identifier);
        return this.deserializer().apply(jsonObject);
    }

    public T save(T object) {
        JsonObject jsonObject = this.serializer().apply(object, new JsonObject());
        back.save(jsonObject);
        return object;
    }

    public void closeBack() {
        this.back.close();
    }

    protected void createBackend(Path flatPath, String tableName) {
        this.back = plugin.getStorageFactory().create(this.storageType, this.deserializer(), this.serializer(), flatPath, tableName);
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
