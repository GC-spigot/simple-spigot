package me.hyfe.simplespigot.plugin;

import me.hyfe.simplespigot.command.CommandBase;
import me.hyfe.simplespigot.config.ConfigStore;
import me.hyfe.simplespigot.registry.Registry;
import me.hyfe.simplespigot.save.SavingController;
import me.hyfe.simplespigot.storage.BackendFactory;
import me.hyfe.simplespigot.storage.StorageSettings;
import me.hyfe.simplespigot.command.command.SimpleCommand;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public abstract class SpigotPlugin extends JavaPlugin implements SimplePlugin {
    private final BackendFactory storageFactory = new BackendFactory(this);
    private final StorageSettings storageSettings = new StorageSettings();
    private final CommandBase commandBase = new CommandBase(this);
    private final ConfigStore configStore = new ConfigStore(this);
    private final SavingController savingController = new SavingController(this);

    @Override
    public void runAsync(Runnable runnable) {
        Bukkit.getScheduler().runTaskAsynchronously(this, runnable);
    }

    @Override
    public <T> CompletableFuture<T> asyncCallback(Supplier<T> supplier) {
        return CompletableFuture.supplyAsync(supplier, this::runAsync);
    }

    @Override
    public void runSync(Runnable runnable) {
        Bukkit.getScheduler().runTask(this, runnable);
    }

    @Override
    public <T> CompletableFuture<T> syncCallback(Supplier<T> supplier) {
        return CompletableFuture.supplyAsync(supplier, this::runSync);
    }

    @Override
    public void registerRegistries(Registry... registries) {
        for (Registry registry : registries) {
            registry.register();
        }
    }

    @Override
    public void registerListeners(Listener... listeners) {
        for (Listener listener : listeners) {
            Bukkit.getPluginManager().registerEvents(listener, this);
        }
    }

    @Override
    public void registerCommands(SimpleCommand... commands) {
        for (SimpleCommand command : commands) {
            this.commandBase.registerCommand(command);
        }
    }

    @Override
    public BackendFactory getStorageFactory() {
        return this.storageFactory;
    }

    @Override
    public StorageSettings getStorageSettings() {
        return this.storageSettings;
    }

    @Override
    public CommandBase getCommandBase() {
        return this.commandBase;
    }

    @Override
    public ConfigStore getConfigStore() {
        return this.configStore;
    }

    @Override
    public SavingController getSavingController() {
        return this.savingController;
    }
}
