package me.hyfe.simplespigot.storage;

import com.google.gson.JsonObject;

public interface Backend {

    JsonObject load(String id);

    void save(String id, JsonObject json);

    void close();
}
