package me.hyfe.simplespigot.scheduler;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class BukkitSchedulerWrapper {
    private final Plugin plugin;

    public BukkitSchedulerWrapper(Plugin plugin) {
        this.plugin = plugin;
    }

    public void run(ThreadContext threadContext, Runnable runnable) {
        if (threadContext.equals(ThreadContext.SYNC)) {
            Bukkit.getScheduler().runTask(this.plugin, runnable);
        } else {
            Bukkit.getScheduler().runTaskAsynchronously(this.plugin, runnable);
        }
    }

    public void runDelay(ThreadContext threadContext, Runnable runnable, long delay) {
        if (threadContext.equals(ThreadContext.SYNC)) {
            Bukkit.getScheduler().runTaskLater(this.plugin, runnable, delay);
        } else {
            Bukkit.getScheduler().runTaskLaterAsynchronously(this.plugin, runnable, delay);
        }
    }

    public void runTimer(ThreadContext threadContext, Runnable runnable, long delay, long interval) {
        if (threadContext.equals(ThreadContext.SYNC)) {
            Bukkit.getScheduler().runTaskTimer(this.plugin, runnable, delay, interval);
        } else {
            Bukkit.getScheduler().runTaskTimerAsynchronously(this.plugin, runnable, delay, interval);
        }
    }
}
