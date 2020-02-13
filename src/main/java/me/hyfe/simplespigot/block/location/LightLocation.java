package me.hyfe.simplespigot.block.location;

import org.bukkit.Location;

public class LightLocation {
    private final String world;
    private final double x;
    private final double y;
    private final double z;
    private final double pitch;
    private final double yaw;

    public LightLocation(Location location) {
        this.world = location.getWorld().getName();
        this.x = location.getX();
        this.y = location.getY();
        this.z = location.getZ();
        this.pitch = location.getPitch();
        this.yaw = location.getYaw();
    }

    public LightLocation(Location location, boolean alwaysTrue) {
        this.world = location.getWorld().getName();
        this.x = location.getBlockX();
        this.y = location.getBlockY();
        this.z = location.getBlockZ();
        this.pitch = location.getPitch();
        this.yaw = location.getYaw();
    }

    public LightLocation(String world, double x, double y, double z) {
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
        this.pitch = 0.0;
        this.yaw = 0.0;
    }

    public LightLocation(String world, double x, double y, double z, double pitch, double yaw) {
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
        this.pitch = pitch;
        this.yaw = yaw;
    }

    public String getWorld() {
        return this.world;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getZ() {
        return this.z;
    }
}
