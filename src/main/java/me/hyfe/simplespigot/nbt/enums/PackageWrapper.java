package me.hyfe.simplespigot.nbt.enums;

public enum PackageWrapper {
    NMS("net.minecraft.server"),
    CRAFTBUKKIT("org.bukkit.craftbukkit");

    private final String uri;

    PackageWrapper(String uri) {
        this.uri = uri;
    }

    public String getUri() {
        return uri;
    }

}