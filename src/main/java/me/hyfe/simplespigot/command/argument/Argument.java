package me.hyfe.simplespigot.command.argument;

public class Argument<T> {
    private final ArgumentType<T> type;
    private final String argument;

    public Argument(ArgumentType<T> type, String argument) {
        this.type = type;
        this.argument = argument;
    }

    public ArgumentType<T> getType() {
        return this.type;
    }

    public String getArgument() {
        return this.argument;
    }
}