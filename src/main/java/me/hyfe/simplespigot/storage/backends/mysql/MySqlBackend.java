package me.hyfe.simplespigot.storage.backends.mysql;

import com.google.common.collect.Sets;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.SneakyThrows;
import me.hyfe.simplespigot.plugin.SimplePlugin;
import me.hyfe.simplespigot.storage.Backend;
import me.hyfe.simplespigot.storage.StorageSettings;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Set;
import java.util.function.UnaryOperator;

public class MySqlBackend implements Backend {
    private final StorageSettings storageSettings; // getters can return null values
    private final MySqlConnectionFactory connectionFactory;

    private final UnaryOperator<String> processor;

    private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS '%where%' ( id VARCHAR(36) NOT NULL,  json MEDIUMBLOB NOT NULL, PRIMARY KEY (id)";
    private static final String DELETE = "DELETE FROM '%where%' WHERE id=?";
    private static final String INSERT = "INSERT INTO '%where%' (id, json) VALUES(?, ?)";
    private static final String SELECT = "SELECT id, json FROM %where% WHERE id=?";
    private static final String SELECT_ALL = "SELECT * FROM %where%";

    public MySqlBackend(SimplePlugin plugin, String tableName) {
        this.storageSettings = plugin.getStorageSettings();
        this.connectionFactory = new MySqlConnectionFactory(this.storageSettings);
        this.processor = query -> query.replace("%where%", tableName.concat(this.storageSettings.getPrefix()));
        this.createTable();
    }

    @Override
    @SneakyThrows
    public JsonObject load(String id) {
        try (Connection connection = this.connectionFactory.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(this.processor.apply(SELECT))) {
                statement.setString(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next())
                        return new JsonParser().parse(resultSet.getString("json")).getAsJsonObject();
                }
            }
        }
        return null;
    }

    @Override
    @SneakyThrows
    public void save(String id, JsonObject json) {
        try (Connection connection = this.connectionFactory.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(this.processor.apply(DELETE))) {
                statement.setString(1, id);
                statement.execute();
            }
        }
        try (Connection connection = this.connectionFactory.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(this.processor.apply(INSERT))) {
                statement.setString(1, id);
                statement.setString(2, new Gson().toJson(json));
                statement.execute();
            }
        }
    }

    @Override
    @SneakyThrows
    public Set<JsonObject> loadAll() {
        Set<JsonObject> all = Sets.newHashSet();
        try (Connection connection = this.connectionFactory.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(this.processor.apply(SELECT_ALL))) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        all.add(new JsonParser().parse(resultSet.getString("json")).getAsJsonObject());
                    }
                }
            }
        }
        return all;
    }

    @Override
    public void close() {
        this.connectionFactory.close();
    }

    @SneakyThrows
    private void createTable() {
        try (Connection connection = this.connectionFactory.getConnection()) {
            connection.createStatement().execute(this.processor.apply(CREATE_TABLE));
        }
    }
}
