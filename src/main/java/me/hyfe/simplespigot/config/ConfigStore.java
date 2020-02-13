package me.hyfe.simplespigot.config;

import com.google.common.collect.Maps;
import org.bukkit.plugin.Plugin;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class ConfigStore {
    private final Plugin plugin;
    private Map<String, Config> configMap = Maps.newHashMap();
    private Map<String, String> commons = Maps.newHashMap();

    public ConfigStore(Plugin plugin) {
        this.plugin = plugin;
    }

    public Map<String, String> commons() {
        return this.commons;
    }

    public Config getConfig(String string) {
        return configMap.get(string);
    }

    public ConfigStore config(String name, BiFunction<Path, String, Path> pathFunc) {
        this.configMap.put(name, new Config(this.plugin, path -> Paths.get(pathFunc.apply(path, name).toString() + ".yml")));
        return this;
    }

    public ConfigStore common(String id, String config, Function<Config, String> function) {
        this.commons.put(id, function.apply(this.getConfig(config)));
        return this;
    }

    public void reload(String string) {
        Config config = this.getConfig(string);
        if (config != null) {
            config.reload();
        }
    }

    public void reload(String... configs) {
        for (String config : configs) {
            this.reload(config);
        }
    }

    public void reloadAll() {
        for (Config config : this.configMap.values()) {
            config.reload();
        }
    }
}
