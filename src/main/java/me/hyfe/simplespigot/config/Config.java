package me.hyfe.simplespigot.config;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import me.hyfe.simplespigot.text.Text;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.UnaryOperator;

public class Config {
    private final Plugin plugin;
    private final File file;
    private final boolean reloadable;
    private YamlConfiguration configuration;
    private Map<String, Object> valueMap;
    private Set<String> enduringKeys;

    /**
     * Used for creating a new instance using a Path.
     *
     * @param plugin       The instance of the main class (it extends Plugin).
     * @param path         The path to the file.
     * @param reloadable   Whether the config file can be reloaded.
     * @param enduringKeys Keys in the file that will not be reloaded.
     */
    public Config(Plugin plugin, UnaryOperator<Path> path, boolean reloadable, String... enduringKeys) {
        this.plugin = plugin;
        this.file = path.apply(plugin.getDataFolder().toPath()).toFile();
        this.reloadable = reloadable;
        this.enduringKeys = Sets.newHashSet(enduringKeys);
        this.createIfAbsent(path.apply(Paths.get("")).toString());
        this.reload();
        this.load();
    }

    /**
     * Used for creating a new instance using a File.
     *
     * @param plugin       The instance of the main class (it extends Plugin).
     * @param file         The file to load into the Config.
     * @param reloadable   Whether the config file can be reloaded.
     * @param enduringKeys Keys in the file that will not be reloaded.
     */
    public Config(Plugin plugin, File file, boolean reloadable, String... enduringKeys) {
        this.plugin = plugin;
        this.file = file;
        this.reloadable = reloadable;
        this.enduringKeys = Sets.newHashSet(enduringKeys);
        this.reload();
        this.load();
    }

    /**
     * Gets the YAML configuration of the file.
     *
     * @return A YamlConfiguration of the inner config file.
     */
    public YamlConfiguration getConfiguration() {
        return this.configuration;
    }

    /**
     * Gets whether the config file is set to be reloadable.
     *
     * @return A boolean of whether the config file will be reloaded.
     */
    public boolean isReloadable() {
        return this.reloadable;
    }

    /**
     * Checks if a key is contained in the configuration, e.g this.key
     *
     * @param key The key to be checked if the config contains.
     * @return A boolean of whether the file contained the key.
     */
    public boolean has(String key) {
        return this.configuration.contains(key);
    }

    /**
     * Gets a string from the config file.
     *
     * @param key The key of where the string can be found in the file.
     * @return The string that was found at the key specified in the config file.
     */
    public String string(String key) {
        return Text.modify((String) this.get(key));
    }

    /**
     * Gets a boolean from the config file.
     *
     * @param key The key of where the boolean can be found in the file.
     * @return The boolean that was found at the key specified in the config file.
     */
    public boolean bool(String key) {
        Object object = this.get(key);
        return (object instanceof Boolean) ? (Boolean) object : false;
    }

    /**
     * Gets a integer from the config file.
     *
     * @param key The key of where the integer can be found in the file.
     * @return The integer that was found at the key specified in the config file.
     */
    public int integer(String key) {
        Object object = this.get(key);
        return object instanceof Number ? ((Number) object).intValue() : -1;
    }

    /**
     * Gets a double from the config file.
     *
     * @param key The key of where the double can be found in the file.
     * @return The double that was found at the key specified in the config file.
     */
    public double doubl(String key) {
        Object object = this.get(key);
        return object instanceof Number ? ((Number) object).doubleValue() : -1;
    }

    /**
     * Gets a list of strings from the config file.
     *
     * @param key The key of where the list of strings can be found in the file.
     * @return The list of strings that was found at the key specified in the config file.
     */
    @SuppressWarnings("unchecked")
    public List<String> stringList(String key) {
        Object object = this.get(key);
        return object instanceof List ? (List<String>) object : Lists.newArrayList();
    }

    /**
     * Gets a list of generic types from the config file.
     *
     * @param key The key of where the list can be found in the file.
     * @return The list that was found at the key specified in the config file.
     */
    @SuppressWarnings("unchecked")
    public <T> List<T> list(String key) {
        Object object = this.get(key);
        return object instanceof List ? (List<T>) object : Lists.newArrayList();
    }

    /**
     * Gets the keys of the config file.
     *
     * @param key  The key of where to check for all the keys. Can be empty.
     * @param deep Whether the keys will be of the select layer or deeper (see Spigot YamlConfig docs)
     * @return A set of all the keys
     */
    public Set<String> keys(String key, boolean deep) {
        ConfigurationSection configurationSection = this.configuration.getConfigurationSection(key);
        if (configurationSection == null) {
            return null;
        } else {
            return configurationSection.getKeys(deep);
        }
    }

    /**
     * Gets a value without a set type from the value map.
     *
     * @param key The key of the location for the value.
     * @return The value located at the specified key in the map.
     */
    public Object get(String key) {
        return this.valueMap.getOrDefault(key, null);
    }

    /**
     * Loads the configuration file.
     */
    public synchronized void load() {
        boolean isReload = true;
        if (this.valueMap == null) {
            this.valueMap = Maps.newHashMap();
            isReload = false;
        }
        for (String key : this.configuration.getKeys(true)) {
            if (isReload && this.enduringKeys.contains(key)) {
                continue;
            }
            this.valueMap.put(key, this.configuration.get(key));
        }
    }

    /**
     * Updates the configuration file from the disk.
     */
    public void reload() {
        this.configuration = YamlConfiguration.loadConfiguration(this.file);
        this.load();
    }

    /**
     * Creates necessary files if they are not present.
     *
     * @param file The name of the file that needs to be saved - done from resources.
     */
    private void createIfAbsent(String file) {
        if (!this.file.exists()) {
            this.plugin.getDataFolder().mkdirs();
            this.plugin.saveResource(file, false);
        }
    }
}