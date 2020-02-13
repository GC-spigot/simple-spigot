package me.hyfe.simplespigot.storage.storage.load;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

@FunctionalInterface
public interface Deserializer<T> {

    T apply(JsonObject json, Gson gson);
}
