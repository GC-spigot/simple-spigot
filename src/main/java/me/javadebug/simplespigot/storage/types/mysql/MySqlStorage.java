package me.javadebug.simplespigot.storage.types.mysql;

import com.google.gson.JsonObject;
import me.javadebug.simplespigot.plugin.SimplePlugin;
import me.javadebug.simplespigot.storage.StorageInterface;
import me.javadebug.simplespigot.storage.StorageSettings;

import java.util.function.UnaryOperator;

public class MySqlStorage<T> implements StorageInterface<T> {
    private final StorageSettings storageSettings; // getters can return null values
    private final MySqlConnectionFactory connectionFactory;

    private final UnaryOperator<String> processor;

    private static final String CREATE_TABLE = "";
    private static final String DELETE = "";
    private static final String INSERT = "";
    private static final String SELECT = "";

    public MySqlStorage(SimplePlugin plugin, String tableName) {
        this.storageSettings = plugin.getStorageSettings();
        this.connectionFactory = new MySqlConnectionFactory(this.storageSettings);
        this.processor = query -> query.replace("{location}", tableName + this.storageSettings.getPrefix());
    }

    @Override
    public JsonObject load(String identifier) {
        return null;
    }

    @Override
    public T save(JsonObject jsonObject) {
        return null;
    }

    @Override
    public void close() {
        this.connectionFactory.close();
    }
}
