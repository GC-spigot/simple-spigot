package me.javadebug.simplespigot.storage.storage.load;

import com.google.gson.JsonObject;

@FunctionalInterface
public interface Serializer<T> {

    JsonObject apply(T object, JsonObject json);
}
