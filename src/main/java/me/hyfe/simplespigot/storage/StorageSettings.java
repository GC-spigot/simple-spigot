package me.hyfe.simplespigot.storage;

import com.google.common.collect.Maps;

import java.util.Map;

public class StorageSettings {
    private final String address;
    private final String prefix;
    private final String database;
    private final String username;
    private final String password;
    private final int maximumPoolSize;
    private final int minimumIdle;
    private final int maximumLifetime;
    private final int connectionTimeout;
    private final Map<String, String> properties = Maps.newHashMap();

    public StorageSettings() {
        this.address = "";
        this.prefix = "";
        this.database = "";
        this.username = "";
        this.password = "";
        this.maximumPoolSize = 0;
        this.minimumIdle = 0;
        this.maximumLifetime = 0;
        this.connectionTimeout = 0;
    }

    public String getHost() {
        return this.address.split(":")[0];
    }

    public String getPort() {
        String[] hostAndPort = this.address.split(":");
        return hostAndPort.length > 1 ? hostAndPort[1] : "3306";
    }

    public String getPrefix() {
        return this.prefix;
    }

    public String getDatabase() {
        return this.database;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public int getMaximumPoolSize() {
        return this.maximumPoolSize;
    }

    public int getMinimumIdle() {
        return this.minimumIdle;
    }

    public int getMaximumLifetime() {
        return this.maximumLifetime;
    }

    public int getConnectionTimeout() {
        return this.connectionTimeout;
    }

    public Map<String, String> getProperties() {
        return this.properties;
    }
}
