package me.javadebug.simplespigot.plugin;

import me.javadebug.simplespigot.registry.Registry;
import me.javadebug.simplespigot.service.ClassReflector;
import me.javadebug.simplespigot.storage.StorageFactory;
import me.javadebug.simplespigot.storage.StorageSettings;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Supplier;

public interface SimplePlugin extends Plugin {

    void runAsync(Runnable runnable);

    <T> CompletableFuture<T> asyncCallback(Supplier<T> supplier);

    void runSync(Runnable runnable);

    <T> CompletableFuture<T> syncCallback(Supplier<T> supplier);

    void registerRegistries(Registry... registries);

    void registerListeners(Listener... listeners);

    StorageFactory getStorageFactory();

    StorageSettings getStorageSettings();
}
