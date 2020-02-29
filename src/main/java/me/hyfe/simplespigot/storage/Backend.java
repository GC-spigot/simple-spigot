package me.hyfe.simplespigot.storage;

import com.google.gson.JsonObject;

import java.util.Set;

public interface Backend {

    JsonObject load(String id);

    void save(String id, JsonObject json);

    Set<JsonObject> loadAll();

    void close();
}
