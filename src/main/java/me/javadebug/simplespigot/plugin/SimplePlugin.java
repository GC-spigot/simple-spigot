package me.javadebug.simplespigot.plugin;

import me.javadebug.simplespigot.command.CommandBase;
import me.javadebug.simplespigot.command.command.SimpleCommand;
import me.javadebug.simplespigot.config.ConfigStore;
import me.javadebug.simplespigot.registry.Registry;
import me.javadebug.simplespigot.storage.BackendFactory;
import me.javadebug.simplespigot.storage.StorageSettings;
import org.bukkit.command.CommandSender;
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
