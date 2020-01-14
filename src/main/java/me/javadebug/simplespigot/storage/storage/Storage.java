package me.javadebug.simplespigot.storage.storage;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import me.javadebug.simplespigot.storage.Backend;
import me.javadebug.simplespigot.storage.storage.load.Deserializer;
import me.javadebug.simplespigot.storage.storage.load.Serializer;

public abstract class Storage<T> {
    private Backend backend;

    public Storage(Backend backend) {
        this.backend = backend;
    }

    public abstract Serializer<T> serializer();

    public abstract Deserializer<T> deserializer();

    public T load(String id) {
        JsonObject json = this.backend.load(id);
        return json == null ? null : this.deserializer().apply(json, new Gson());
    }

    public T save(String id, T object) {
        this.backend.save(id, this.serializer().apply(object, new JsonObject(), new Gson()));
        return object;
    }

    public void closeBack() {
        this.backend.close();
    }
}
