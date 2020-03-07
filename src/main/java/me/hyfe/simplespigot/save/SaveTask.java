package me.hyfe.simplespigot.save;

import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class SaveTask extends BukkitRunnable {
    private final Savable savable;
    private final BukkitTask bukkitTask;

    public SaveTask(Plugin plugin, Savable savable, int interval) {
        this.savable = savable;
        this.bukkitTask = this.runTaskTimerAsynchronously(plugin, interval, interval);
    }

    public void stop() {
        if (!this.bukkitTask.isCancelled()) {
            this.bukkitTask.cancel();
        }
    }

    @Override
    public void run() {
        this.savable.save();
    }
}
