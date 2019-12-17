package me.javadebug.simplespigot.storage.types;

import com.google.gson.JsonObject;
import me.javadebug.simplespigot.storage.StorageInterface;

public class FlatStorage<T> implements StorageInterface<T> {

    @Override
    public JsonObject load(String identifier) {
        return null;
    }

    @Override
    public T save(JsonObject jsonObject) {
        return null;
    }
}
