package me.javadebug.simplespigot.plugin;

import me.javadebug.simplespigot.command.CommandBase;
import me.javadebug.simplespigot.command.command.SimpleCommand;
import me.javadebug.simplespigot.config.ConfigStore;
import me.javadebug.simplespigot.registry.Registry;
import me.javadebug.simplespigot.storage.BackendFactory;
import me.javadebug.simplespigot.storage.StorageSettings;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public abstract class SpigotPlugin extends JavaPlugin implements SimplePlugin {
    private final BackendFactory storageFactory = new BackendFactory(this);
    private final StorageSettings storageSettings = new StorageSettings();
    private final CommandBase commandBase = new CommandBase(this);
    private final ConfigStore configStore = new ConfigStore(this);

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
}
