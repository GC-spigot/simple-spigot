package me.javadebug.simplespigot.storage.types.mysql;

import com.google.gson.JsonObject;
import me.javadebug.simplespigot.storage.StorageInterface;

public class MySqlStorage<T> implements StorageInterface<T> {
    private final MySqlFactory mySqlFactory;

    private static final String CREATE_TABLE = "CREATE TABLE...";
    private static final String DELETE = "DELETE...";
    private static final String INSERT = "INSERT...";

    public MySqlStorage() {
        this.mySqlFactory = new MySqlFactory();
    }

    @Override
    public JsonObject load(String identifier) {
        return null;
    }

    @Override
    public T save(JsonObject jsonObject) {
        return null;
    }
}
