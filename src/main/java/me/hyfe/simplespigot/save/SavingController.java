package me.hyfe.simplespigot.save;

import com.google.common.collect.Sets;
import org.bukkit.plugin.Plugin;

import java.util.Set;

public class SavingController {
    private final Plugin plugin;
    private Set<SaveTask> saveTasks = Sets.newHashSet();

    public SavingController(Plugin plugin) {
        this.plugin = plugin;
    }

    public void addSavable(Savable savable, int interval) {
        this.saveTasks.add(new SaveTask(this.plugin, savable, interval));
    }

    public void clearController() {
        for (SaveTask saveTask : this.saveTasks) {
            saveTask.stop();
        }
        this.saveTasks.clear();
    }
}
