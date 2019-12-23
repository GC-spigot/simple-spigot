package me.javadebug.simplespigot.storage;

import com.google.gson.JsonObject;

public interface Backend<T> {

    JsonObject load(String id);

    void save(String id, JsonObject json);

    void close();
}
