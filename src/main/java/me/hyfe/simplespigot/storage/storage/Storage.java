package me.hyfe.simplespigot.storage.storage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import me.hyfe.simplespigot.plugin.SimplePlugin;
import me.hyfe.simplespigot.storage.Backend;
import me.hyfe.simplespigot.storage.BackendFactory;
import me.hyfe.simplespigot.storage.storage.load.Deserializer;
import me.hyfe.simplespigot.storage.storage.load.Serializer;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public abstract class Storage<T> {
    private Backend backend;
    private Gson serializerGson;
    private Gson deserializerGson;

    public Storage(SimplePlugin plugin, Function<BackendFactory, Backend> backend) {
        this.backend = backend.apply(new BackendFactory(plugin));
        this.serializerGson = new Gson();
        this.deserializerGson = new Gson();
    }

    public Storage(Backend backend) {
        this.backend = backend;
    }

    public abstract Serializer<T> serializer();

    public abstract Deserializer<T> deserializer();

    public void setSerializerGson(UnaryOperator<GsonBuilder> builder) {
        this.serializerGson = builder.apply(new GsonBuilder()).setPrettyPrinting().create();
    }

    public void setDeserializerGson(UnaryOperator<GsonBuilder> builder) {
        this.deserializerGson = builder.apply(new GsonBuilder()).setPrettyPrinting().create();
    }

    public T load(String id) {
        JsonObject json = this.backend.load(id);
        return json == null ? null : this.deserializer().apply(json, this.deserializerGson);
    }

    public T save(String id, T object) {
        this.backend.save(id, this.serializer().apply(object, new JsonObject(), this.serializerGson));
        return object;
    }

    public void closeBack() {
        this.backend.close();
    }
}
