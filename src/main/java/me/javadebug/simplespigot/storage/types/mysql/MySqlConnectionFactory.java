package me.javadebug.simplespigot.storage.types.mysql;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.SneakyThrows;
import me.javadebug.simplespigot.storage.StorageSettings;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.function.Function;

public class MySqlConnectionFactory {
    private final StorageSettings storageSettings;
    private final HikariDataSource dataSource;
    private final HikariConfig config;

    public MySqlConnectionFactory(StorageSettings storageSettings) {
        this.storageSettings = storageSettings;
        this.config = new HikariConfig();
        this.dataSource = new HikariDataSource(this.configurate(this.config));
    }

    @SneakyThrows
    public Connection getConnection() {
        if (this.dataSource == null) {
            throw new SQLException("Unable to get a connection from the pool.");
        }
        Connection connection = this.dataSource.getConnection();
        if (connection == null) {
            throw new SQLException("Unable to get a connection from the pool.");
        }
        return connection;
    }

    public void close() {
        if (this.dataSource != null) {
            this.dataSource.close();
        }
    }

    private HikariConfig configurate(HikariConfig config) {
        config.setDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource");
        this.config.setUsername(this.storageSettings.getUsername());
        this.config.setPassword(this.storageSettings.getPassword());
        this.config.setPoolName(this.storageSettings.getPrefix() + "hikari");
        this.config.setMaximumPoolSize(this.storageSettings.getMaximumPoolSize());
        this.config.setMinimumIdle(this.storageSettings.getMinimumIdle());
        this.config.setMaxLifetime(this.storageSettings.getMaximumLifetime());
        this.config.setConnectionTimeout(this.storageSettings.getConnectionTimeout());
        this.addProperty("characterEncoding", "utf8");
        this.addProperty("serverName", StorageSettings::getHost);
        this.addProperty("port", StorageSettings::getPort);
        this.addProperty("databaseName", StorageSettings::getDatabase);
        for (Map.Entry<String, String> property : this.storageSettings.getProperties().entrySet()) {
            this.addProperty(property.getKey(), property.getValue());
        }
        return config;
    }

    private void addProperty(String property, Function<StorageSettings, Object> value) {
        this.config.addDataSourceProperty(property, value.apply(this.storageSettings));
    }

    private void addProperty(String property, Object value) {
        this.config.addDataSourceProperty(property, value);
    }
}
