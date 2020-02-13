package me.hyfe.simplespigot.plugin;

import me.hyfe.simplespigot.command.CommandBase;
import me.hyfe.simplespigot.config.ConfigStore;
import me.hyfe.simplespigot.registry.Registry;
import me.hyfe.simplespigot.storage.BackendFactory;
import me.hyfe.simplespigot.storage.StorageSettings;
import me.hyfe.simplespigot.command.command.SimpleCommand;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public interface SimplePlugin extends Plugin {

    void runAsync(Runnable runnable);

    <T> CompletableFuture<T> asyncCallback(Supplier<T> supplier);

    void runSync(Runnable runnable);

    <T> CompletableFuture<T> syncCallback(Supplier<T> supplier);

    void registerRegistries(Registry... registries);

    void registerListeners(Listener... listeners);

    void registerCommands(SimpleCommand... commands);

    BackendFactory getStorageFactory();

    StorageSettings getStorageSettings();

    CommandBase getCommandBase();

    ConfigStore getConfigStore();
}
