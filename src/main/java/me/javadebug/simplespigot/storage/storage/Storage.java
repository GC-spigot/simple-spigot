package me.javadebug.simplespigot.storage.storage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import me.javadebug.simplespigot.plugin.SimplePlugin;
import me.javadebug.simplespigot.storage.Backend;
import me.javadebug.simplespigot.storage.storage.load.Deserializer;
import me.javadebug.simplespigot.storage.storage.load.Serializer;

import java.nio.file.Path;
import java.util.function.UnaryOperator;

public abstract class Storage<T> {
    private final SimplePlugin plugin;

    private Backend backend;

    public Storage(SimplePlugin plugin) {
        this.plugin = plugin;
    }

    public abstract Serializer<T> serializer();

    public abstract Deserializer<T> deserializer();

    public T load(String id) {
        JsonObject json = this.backend.load(id);
        return json == null ? null : this.deserializer().apply(json, new Gson());
    }

    public T save(String id, T object) {
        this.backend.save(id, this.serializer().apply(object, new JsonObject(), new GsonBuilder().setPrettyPrinting().create()));
        return object;
    }

    public void closeBack() {
        this.backend.close();
    }

    protected void createBackend(StorageType storageType, String tableName, UnaryOperator<Path> flatPath) {
        this.backend = this.plugin.getStorageFactory().create(storageType, tableName, flatPath.apply(this.plugin.getDataFolder().toPath().toAbsolutePath()));
    }
}
