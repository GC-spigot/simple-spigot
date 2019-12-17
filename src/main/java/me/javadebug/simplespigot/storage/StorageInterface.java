package me.javadebug.simplespigot.storage;

import com.google.gson.JsonObject;

public interface StorageInterface<T> {

    JsonObject load(String identifier);

    T save(JsonObject jsonObject);
}
