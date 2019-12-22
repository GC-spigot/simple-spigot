package me.javadebug.simplespigot.storage;

import com.google.gson.JsonObject;
import me.javadebug.simplespigot.storage.storage.load.Deserializer;
import me.javadebug.simplespigot.storage.storage.load.Serializer;

public abstract class Backend<T> {
    protected final Deserializer<T> deserializer;
    protected final Serializer<T> serializer;

    public Backend(Deserializer<T> deserializer, Serializer<T> serializer) {
        this.deserializer = deserializer;
        this.serializer = serializer;
    }

    public abstract JsonObject load(String id);

    public abstract void save(JsonObject jsonObject);

    public abstract void close();
}
