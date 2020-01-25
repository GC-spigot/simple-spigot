package me.javadebug.simplespigot.storage.backends;

import com.google.gson.JsonObject;
import me.javadebug.simplespigot.storage.Backend;

public class MongoBackend implements Backend {

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
