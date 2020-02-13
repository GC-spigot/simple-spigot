package me.hyfe.simplespigot.command.argument;

public interface ArgumentType<T> {

    T parse(String arg);
}