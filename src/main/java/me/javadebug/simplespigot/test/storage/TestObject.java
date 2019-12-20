package me.javadebug.simplespigot.test.storage;

import java.util.UUID;

class TestObject {
    private final UUID uuid;

    public TestObject(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUuid() {
        return this.uuid;
    }
}