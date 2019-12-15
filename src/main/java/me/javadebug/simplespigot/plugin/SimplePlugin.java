package me.javadebug.simplespigot.plugin;

import me.javadebug.simplespigot.registry.Registry;
import me.javadebug.simplespigot.service.ClassReflector;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Supplier;

public interface SimplePlugin {

    void runAsync(Runnable runnable);

    <T> CompletableFuture<T> runAsyncCallback(Supplier<T> supplier);

    void runSync(Runnable runnable);

    <T> CompletableFuture<T> runSyncCallback(Supplier<T> supplier);

    <T extends Registry> void registerRegistries(Consumer<ClassReflector<T>> consumer, Class<T>... registries);
}
