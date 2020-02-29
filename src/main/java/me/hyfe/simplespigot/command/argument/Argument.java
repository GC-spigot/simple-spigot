package me.hyfe.simplespigot.command.argument;

import com.google.common.collect.Sets;

import java.util.Set;

public class Argument<T> {
    private final ArgumentType<T> type;
    private final String argument;
    private final Set<String> aliases;

    public Argument(ArgumentType<T> type, String argument) {
        this.type = type;
        this.argument = argument;
        this.aliases = Sets.newHashSet();
    }

    public Argument(ArgumentType<T> type, String argument, String... aliases) {
        this.type = type;
        this.argument = argument;
        this.aliases = Sets.newHashSet(aliases);
    }

    public ArgumentType<T> getType() {
        return this.type;
    }

    public String getArgument() {
        return this.argument;
    }

    public Set<String> getAliases() {
        return this.aliases;
    }
}