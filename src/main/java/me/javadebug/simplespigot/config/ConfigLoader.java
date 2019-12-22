package me.javadebug.simplespigot.config;

import me.javadebug.simplespigot.item.SpigotItem;
import me.javadebug.simplespigot.text.Replacer;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

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

        public String string(String path) {
            return this.config.string(this.currentPath + "." + path);
        }

        public int integer(String path) {
            return this.config.integer(this.currentPath + "." + path);
        }

        public List<String> list(String path) {
            return this.config.list(this.currentPath + "." + path);
        }

        public ItemStack getItem(String path) {
            return this.getItem(path, null);
        }

        public ItemStack getItem(String path, UnaryOperator<Replacer> replacer) {
            return SpigotItem.toItem(this.config, this.currentPath + "." + path, replacer);
        }

        public Reader keyLoop(String path, boolean deep, Consumer<String> consumer) {
            if (this.currentPath.isEmpty()) {
                this.currentPath = path;
            } else {
                this.currentPath += ("." + path);
            }
            for (String key : this.config.keys(path, deep)) {
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
