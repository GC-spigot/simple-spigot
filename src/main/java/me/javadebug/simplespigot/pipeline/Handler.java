package me.javadebug.simplespigot.pipeline;

public interface Handler<T, R> {

    R process(T type);
}
