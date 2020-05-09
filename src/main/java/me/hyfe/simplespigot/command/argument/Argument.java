package me.hyfe.simplespigot.command.argument;

import com.google.common.collect.Sets;

import java.util.Set;

public class Argument<T> {
    private final ArgumentType<T> type;
    private final String argument;
    private final Set<String> aliases;

    /**
     * Creates an argument for use with a SimpleCommand.
     *
     * @param type     The clazz type of the argument, e.g a Player, OfflinePlayer, Integer or User.
     * @param argument The type of argument (used in help), e.g player or amount.
     */
    public Argument(ArgumentType<T> type, String argument) {
        this.type = type;
        this.argument = argument;
        this.aliases = Sets.newHashSet();
    }

    /**
     * Creates an argument for use with a SimpleCommand which has aliases.
     *
     * @param type     The clazz type of the argument, e.g a Player, OfflinePlayer, Integer or User.
     * @param argument The type of argument (used in help), e.g player or amount.
     * @param aliases  The alternatives (aliases) that can be used.
     */
    public Argument(ArgumentType<T> type, String argument, String... aliases) {
        this.type = type;
        this.argument = argument;
        this.aliases = Sets.newHashSet(aliases);
    }

    /**
     * Gets the type of the Argument.
     *
     * @return The ArgumentType of the class
     */
    public ArgumentType<T> getType() {
        return this.type;
    }

    /**
     * Gets the argument of the class.
     *
     * @return The argument of the class, e.g "player" or "ban"
     */
    public String getArgument() {
        return this.argument;
    }

    /**
     * Gets the aliases, will return an empty hash set if there are none.
     *
     * @return The aliases of the command.
     */
    public Set<String> getAliases() {
        return this.aliases;
    }
}