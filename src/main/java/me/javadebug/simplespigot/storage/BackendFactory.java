package me.javadebug.simplespigot.storage;

import com.google.common.collect.Maps;
import me.javadebug.simplespigot.plugin.SimplePlugin;
import me.javadebug.simplespigot.storage.backends.FlatBackend;
import me.javadebug.simplespigot.storage.backends.MongoBackend;
import me.javadebug.simplespigot.storage.backends.mysql.MySqlBackend;

import java.nio.file.Path;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class BackendFactory {
    private final SimplePlugin plugin;
    private Map<String, BiFunction<UnaryOperator<Path>, String, Backend>> backendMap = Maps.newConcurrentMap();

    public BackendFactory(SimplePlugin plugin) {
        this.plugin = plugin;
        this.addBackend("mysql", destination -> new MySqlBackend(this.plugin, destination)).addBackend("mongodb", destination -> new MongoBackend());
    }

    public Backend create(String backendType, UnaryOperator<Path> path, String destination) {
        for (Map.Entry<String, BiFunction<UnaryOperator<Path>, String, Backend>> backendEntry : backendMap.entrySet()) {
            if (backendEntry.getKey().toLowerCase().equalsIgnoreCase(backendType)) {
                return backendEntry.getValue().apply(path, destination);
            }
        }
        return new FlatBackend(path.apply(this.plugin.getDataFolder().toPath().toAbsolutePath()).resolve(destination));
    }

    public Backend create(String backendType, String destination) {
        return this.create(backendType, path -> path, destination);
    }

    public Backend create(String backendType, UnaryOperator<Path> path) {
        return this.create(backendType, path, "");
    }

    public BackendFactory addBackend(String name, BiFunction<UnaryOperator<Path>, String, Backend> backend) {
        this.backendMap.put(name, backend);
        return this;
    }

    public BackendFactory addBackend(String name, Function<String, Backend> backend) {
        this.addBackend(name, (path, destination) -> backend.apply(destination));
        return this;
    }

    public BackendFactory addBackendAsPath(String name, Function<UnaryOperator<Path>, Backend> backend) {
        this.addBackend(name, (path, destination) -> backend.apply(path));
        return this;
    }
}
