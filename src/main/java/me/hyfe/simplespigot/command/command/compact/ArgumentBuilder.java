package me.hyfe.simplespigot.command.command.compact;

import com.google.common.collect.Lists;
import me.hyfe.simplespigot.command.argument.Argument;
import me.hyfe.simplespigot.command.argument.ArgumentHandler;

import java.util.List;

public class ArgumentBuilder {
    private final List<Argument<?>> arguments = Lists.newArrayList();

    /**
     * Gets the arguments.
     *
     * @return A List of Arguments of the ArgumentBuilder.
     */
    public List<Argument<?>> getArguments() {
        return this.arguments;
    }

    /**
     * Adds a flat requirement, a static argument that must be met, e.g help in /lq help
     *
     * @param flat The text input of the flat, e.g add or invite
     * @return This class, allows chaining.
     */
    public ArgumentBuilder addFlat(String flat) {
        this.arguments.add(new Argument<>(null, flat));
        return this;
    }

    /**
     * Adds a flat requirement, a static argument that must be met, e.g help in /lq help with aliases.
     *
     * @param flat    The text input of the flat, e.g add or invite
     * @param aliases The alternative inputs for the flat.
     * @return This class, allows chaining.
     */
    public ArgumentBuilder addFlatWithAliases(String flat, String... aliases) {
        this.arguments.add(new Argument<>(null, flat, aliases));
        return this;
    }

    /**
     * Adds multiple flat requirements in one, e.g "add", "user", "coins".
     *
     * @param flats The flats to add.
     * @return This class, allows chaining.
     */
    public ArgumentBuilder addFlats(String... flats) {
        for (String flatArgument : flats) {
            this.addFlat(flatArgument);
        }
        return this;
    }

    /**
     * Adds a user input
     *
     * @param clazz    The class container for the type (do Type.class)
     * @param <T>      The type that the user must input, e.g Integer or Player. Custom inputs can be added via a registry.
     * @param argument The name given to the argument, used in the stock help command (future).
     * @return The class, allows chaining.
     */
    public <T> ArgumentBuilder addArgument(Class<T> clazz, String argument) {
        this.arguments.add(new Argument<T>(ArgumentHandler.getArgumentType(clazz), argument));
        return this;
    }
}
