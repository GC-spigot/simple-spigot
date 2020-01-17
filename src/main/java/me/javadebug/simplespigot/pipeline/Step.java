package me.javadebug.simplespigot.pipeline;

public interface Step<T, R> {

    R process(T type);
}
