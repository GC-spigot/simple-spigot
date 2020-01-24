package me.javadebug.simplespigot.text.json;

import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public interface JsonRepresentedObject {

    void writeJson(JsonWriter writer) throws IOException;
}
