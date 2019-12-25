package me.javadebug.simplespigot.storage.types;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.SneakyThrows;
import me.javadebug.simplespigot.storage.Backend;
import me.javadebug.simplespigot.storage.storage.load.Deserializer;
import me.javadebug.simplespigot.storage.storage.load.Serializer;

import java.io.FileReader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

public class FlatStorage implements Backend {
    private final Path path;

    public FlatStorage(Path subPath) {
        this.path = this.createPath(subPath);
    }

    @Override
    @SneakyThrows
    public JsonObject load(String id) {
        Path userPath = this.path.resolve(id + ".json");
        if (!Files.exists(userPath)) {
            return null;
        }
        FileReader reader = new FileReader(userPath.toFile());
        JsonParser parser = new JsonParser();
        return parser.parse(reader).getAsJsonObject();
    }

    @Override
    @SneakyThrows
    public void save(String id, JsonObject json) {
        Path userPath = this.path.resolve(id + ".json");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Writer writer = Files.newBufferedWriter(userPath);
        gson.toJson(json, writer);
        writer.close();
    }

    @Override
    public void close() {

    }

    @SneakyThrows
    private Path createPath(Path path) {
        if (Files.exists(path) && (Files.isDirectory(path) || Files.isSymbolicLink(path))) {
            return path;
        }
        return Files.createDirectory(path);
    }
}
