package me.hyfe.simplespigot.config;

import me.hyfe.simplespigot.item.SpigotItem;
import me.hyfe.simplespigot.text.Replace;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.function.Consumer;

public class ConfigLoader {

    public static Reader reader(Config config) {
        return new Reader(config);
    }

    public static class Reader {
        private final Config config;
        private String currentPath = "";

        public Reader(Config config) {
            this.config = config;
        }

        public Reader readWrap(Consumer<Reader> reader) {
            reader.accept(this);
            return this;
        }

        public String getCurrentPath() {
            return this.currentPath;
        }

        public void setCurrentPath(String currentPath) {
            this.currentPath = currentPath;
        }

        public boolean has(String path) {
            return this.config.has(this.currentPath.concat(".").concat(path));
        }

        public String string(String path) {
            return this.config.string(this.currentPath.concat(".").concat(path));
        }

        public String string() {
            return this.config.string(this.currentPath);
        }

        public int integer(String path) {
            return this.config.integer(this.currentPath.concat(".").concat(path));
        }

        public int integer() {
            return this.config.integer(this.currentPath);
        }

        public List<String> list(String path) {
            return this.config.list(this.currentPath.concat(".").concat(path));
        }

        public List<String> list() {
            return this.config.list(this.currentPath);
        }

        public ItemStack getItem(String path) {
            return this.getItem(path, null);
        }

        public ItemStack getItem(String path, Replace replace) {
            return SpigotItem.toItem(this.config, path.isEmpty() ? this.currentPath : this.currentPath.concat(".").concat(path), replace);
        }

        public Reader keyLoop(String path, boolean deep, Consumer<String> consumer) {
            if (this.currentPath.isEmpty()) {
                this.currentPath = path;
            } else if (!path.isEmpty()) {
                this.currentPath += (".".concat(path));
            }
            for (String key : this.config.keys(path, deep)) {
                this.currentPath = path.isEmpty() ? key : path.concat(".").concat(key);
                consumer.accept(key);
            }
            return this;
        }

        public Reader keyLoop(String path, Consumer<String> consumer) {
            return this.keyLoop(path, false, consumer);
        }

        public Reader keyLoop(boolean deep, Consumer<String> consumer) {
            return this.keyLoop("", deep, consumer);
        }

        public Reader keyLoop(Consumer<String> consumer) {
            return this.keyLoop("", false, consumer);
        }
    }
}
