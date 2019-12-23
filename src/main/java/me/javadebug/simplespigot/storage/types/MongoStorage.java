package me.javadebug.simplespigot.storage.types;

import com.google.gson.JsonObject;
import me.javadebug.simplespigot.storage.Backend;
import me.javadebug.simplespigot.storage.storage.load.Deserializer;
import me.javadebug.simplespigot.storage.storage.load.Serializer;

public class MongoStorage<T> implements Backend<T> {

    @Override
    public JsonObject load(String id) {
        return null;
    }

    @Override
    public void save(String id, JsonObject json) {

    }

    @Override
    public void close() {

    }
}
