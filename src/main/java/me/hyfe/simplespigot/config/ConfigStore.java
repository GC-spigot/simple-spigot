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

    /**
     * Gets the common values set in the config store.
     *
     * @return A Map of identifier to value of the common values.
     */
    public Map<String, String> commons() {
        return this.commons;
    }

    /**
     * Gets a Config from the config store using its identified name.
     *
     * @param string The name of the config file.
     * @return The requested Config from the store.
     */
    public Config getConfig(String string) {
        return configMap.get(string);
    }

    /**
     * Adds a config to the config store.
     *
     * @param name       The name of the file to identify it by.
     * @param pathFunc   The path where the file is located or is to be located.
     * @param reloadable Whether the config can be reloaded.
     * @return The ConfigStore of the plugin allowing chaining.
     */
    public ConfigStore config(String name, BiFunction<Path, String, Path> pathFunc, boolean reloadable) {
        this.configMap.put(name, new Config(this.plugin, path -> Paths.get(pathFunc.apply(path, name).toString().concat(".yml")), reloadable));
        return this;
    }

    /**
     * Adds a common value into the list of commons.
     *
     * @param id       The identifier (key) that will be used in the map of commons.
     * @param config   The config in which the common value can be found.
     * @param function The function to get the common value from the config.
     * @return The ConfigStore of the plugin allowing chaining.
     */
    public ConfigStore common(String id, String config, Function<Config, String> function) {
        this.commons.put(id, function.apply(this.getConfig(config)));
        return this;
    }

    /**
     * Reloads a config whether it allows reloading or not.
     *
     * @param string The name of the config.
     */
    public void forceReload(String string) {
        Config config = this.getConfig(string);
        if (config != null) {
            config.reload();
        }
    }

    /**
     * Reloads multiple configs whether they allow reloading or not.
     *
     * @param configs The names of the configs.
     */
    public void forceReload(String... configs) {
        for (String config : configs) {
            this.forceReload(config);
        }
    }

    /**
     * Reloads all configs that are labelled as reloadable.
     */
    public void reloadReloadableConfigs() {
        for (Config config : this.configMap.values()) {
            if (config.isReloadable()) {
                config.reload();
            }
        }
    }
}
