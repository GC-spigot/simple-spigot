package me.javadebug.simplespigot.config;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import me.javadebug.simplespigot.text.Text;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.UnaryOperator;

public class Config {
    private final Plugin plugin;
    private final File file;
    private YamlConfiguration configuration;
    private Map<String, Object> valueMap;
    private Set<String> enduringKeys;

    public Config(Plugin plugin, UnaryOperator<Path> path, String... enduringKeys) {
        this.plugin = plugin;
        this.file = path.apply(plugin.getDataFolder().toPath()).toFile();
        this.enduringKeys = Sets.newHashSet(enduringKeys);
        this.createIfAbsent();
        this.reload();
        this.load();
    }

    public YamlConfiguration getConfiguration() {
        return this.configuration;
    }

    public String string(String key) {
        return Text.modify((String) this.get(key));
    }

    public boolean bool(String key) {
        return Boolean.parseBoolean(this.get(key));
    }

    public boolean conditionalBool(String key, Runnable falseRun, Runnable trueRun) {
        boolean bool = this.bool(key);
        if (bool) {
            trueRun.run();
        } else {
            falseRun.run();
        }
        return bool;
    }

    public int integer(String key) {
        return this.get(key);
    }

    public List<String> stringList(String key) {
        List<String> list = this.get(key);
        return list == null ? Lists.newArrayList() : list;
    }

    public <T> List<T> list(String key) {
        List<T> list = this.get(key);
        return list == null ? Lists.newArrayList() : list;
    }

    public Set<String> keys(String key, boolean deep) {
        ConfigurationSection configurationSection = this.configuration.getConfigurationSection(key);
        if (configurationSection == null) {
            return null;
        } else {
            return configurationSection.getKeys(deep);
        }
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String key) {
        if (this.valueMap.containsKey(key)) {
            return (T) this.valueMap.get(key);
        } else {
            return null;
        }
    }

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

    public void reload() {
        this.configuration = YamlConfiguration.loadConfiguration(this.file);
    }

    private void createIfAbsent() {
        if (!this.file.exists()) {
            this.plugin.getDataFolder().mkdirs();
            this.plugin.saveResource(this.file.getPath().replace(this.plugin.getDataFolder().getPath() + "/", ""), false);
        }
    }
}