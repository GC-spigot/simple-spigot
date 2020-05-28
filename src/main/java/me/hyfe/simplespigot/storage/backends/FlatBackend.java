package me.hyfe.simplespigot.storage.backends;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.SneakyThrows;
import me.hyfe.simplespigot.storage.Backend;

import java.io.FileReader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class FlatBackend implements Backend {
    private final Path path;
    private final Path subPath;

    public FlatBackend(Path subPath) {
        this.subPath = subPath;
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
        if (Files.exists(this.path)) {
            Path userPath = this.path.resolve(id + ".json");
            Gson gson = new GsonBuilder().create();
            Writer writer = Files.newBufferedWriter(userPath);
            gson.toJson(json, writer);
            writer.close();
        }
    }

    @Override
    @SneakyThrows
    public Set<JsonObject> loadAll() {
        return Files.walk(this.path)
                .map(Path::toString)
                .filter(file -> file.endsWith(".json"))
                .map(file -> file.replace(".json", ""))
                .map(this::load)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
    }

    @Override
    public void close() {

    }

    @SneakyThrows
    private Path createPath(Path path) {
        if (Files.exists(path) && (Files.isDirectory(path) || Files.isSymbolicLink(path))) {
            return path;
        }
        path.toFile().mkdirs();
        return path;
    }
}
