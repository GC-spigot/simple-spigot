package me.hyfe.simplespigot.scheduler;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

public class BukkitSchedulerWrapper {
    private final Plugin plugin;

    public BukkitSchedulerWrapper(Plugin plugin) {
        this.plugin = plugin;
    }

    public BukkitTask run(ThreadContext threadContext, Runnable runnable) {
        if (threadContext.equals(ThreadContext.SYNC)) {
            return Bukkit.getScheduler().runTask(this.plugin, runnable);
        } else {
            return Bukkit.getScheduler().runTaskAsynchronously(this.plugin, runnable);
        }
    }

    public BukkitTask runDelay(ThreadContext threadContext, Runnable runnable, long delay) {
        if (threadContext.equals(ThreadContext.SYNC)) {
            return Bukkit.getScheduler().runTaskLater(this.plugin, runnable, delay);
        } else {
            return Bukkit.getScheduler().runTaskLaterAsynchronously(this.plugin, runnable, delay);
        }
    }

    public BukkitTask runTimer(ThreadContext threadContext, Runnable runnable, long delay, long interval) {
        if (threadContext.equals(ThreadContext.SYNC)) {
            return Bukkit.getScheduler().runTaskTimer(this.plugin, runnable, delay, interval);
        } else {
            return Bukkit.getScheduler().runTaskTimerAsynchronously(this.plugin, runnable, delay, interval);
        }
    }
}
