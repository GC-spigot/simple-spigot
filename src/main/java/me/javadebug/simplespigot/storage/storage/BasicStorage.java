package me.javadebug.simplespigot.storage.storage;

import me.javadebug.simplespigot.plugin.SimplePlugin;

public abstract class BasicStorage<T> extends DynamicStorage<T> {

    public BasicStorage(SimplePlugin plugin, StorageType storageType) {
        super(plugin, storageType);
        this.setTableQuery("'{location}' ()");
        this.setSelectQuery("id, json FROM {location} WHERE id=?");
        this.setInsertQuery("'{location}' (id, json) VALUES(?, ?)");
        this.setDeleteQuery("'{location}' WHERE id=?");
    }
}
