package me.hyfe.simplespigot.text.json;

import com.google.gson.stream.JsonWriter;
import org.bukkit.configuration.serialization.ConfigurationSerializable;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JsonString implements JsonRepresentedObject, ConfigurationSerializable {
    private final String value;

    public JsonString(CharSequence value) {
        this.value = value == null ? null : value.toString();
    }

    public static JsonString deserialize(Map<String, Object> map) {
        return new JsonString(map.get("stringValue").toString());
    }

    @Override
    public void writeJson(JsonWriter writer) throws IOException {
        writer.value(getValue());
    }

    public String getValue() {
        return this.value;
    }

    public Map<String, Object> serialize() {
        HashMap<String, Object> theSingleValue = new HashMap<String, Object>();
        theSingleValue.put("stringValue", this.value);
        return theSingleValue;
    }

    @Override
    public String toString() {
        return this.value;
    }

}