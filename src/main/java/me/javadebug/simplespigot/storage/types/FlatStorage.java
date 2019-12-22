package me.javadebug.simplespigot.storage.types;

import com.google.gson.JsonObject;
import me.javadebug.simplespigot.storage.Backend;
import me.javadebug.simplespigot.storage.storage.load.Deserializer;
import me.javadebug.simplespigot.storage.storage.load.Serializer;

import java.nio.file.Path;

public class FlatStorage<T> extends Backend<T> {

    public FlatStorage(Path path, Deserializer<T> deserializer, Serializer<T> serializer) {
        super(deserializer, serializer);
    }

    @Override
    public JsonObject load(String identifier) {
        return null;
    }

    @Override
    public void save(JsonObject jsonObject) {
    }

    @Override
    public void close() {

    }
}
