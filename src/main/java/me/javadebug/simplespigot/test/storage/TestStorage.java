package me.javadebug.simplespigot.test.storage;

import com.eatthepath.uuid.FastUUID;
import com.google.gson.JsonObject;
import me.javadebug.simplespigot.plugin.SimplePlugin;
import me.javadebug.simplespigot.storage.storage.BasicStorage;
import me.javadebug.simplespigot.storage.storage.StorageType;

import java.util.UUID;
import java.util.function.BiFunction;
import java.util.function.Function;

public class TestStorage extends BasicStorage<TestObject> {

    public TestStorage(SimplePlugin plugin) {
        super(plugin, StorageType.FLAT);
    }

    @Override
    public BiFunction<TestObject, JsonObject, JsonObject> serializer() {
        return (test, jsonObject) -> {
            jsonObject.addProperty("uuid", test.getUuid().toString());
            return jsonObject;
        };
    }

    @Override
    public Function<JsonObject, TestObject> deserializer() {
        return jsonObject -> {
            UUID uuid = FastUUID.parseUUID(jsonObject.get("uuid").getAsString());
            return new TestObject(uuid);
        };
    }
}
