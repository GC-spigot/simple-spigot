package me.javadebug.simplespigot.command.argument;

public interface ArgumentType<T> {

    T parse(String arg);
}