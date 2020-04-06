package me.hyfe.simplespigot.command.command.compact;

import com.google.common.collect.Lists;
import me.hyfe.simplespigot.command.argument.Argument;
import me.hyfe.simplespigot.command.argument.ArgumentHandler;

import java.util.List;

public class ArgumentBuilder {
    private final List<Argument<?>> arguments = Lists.newArrayList();

    public List<Argument<?>> getArguments() {
        return this.arguments;
    }

    public ArgumentBuilder addFlat(String flat) {
        this.arguments.add(new Argument<>(null, flat));
        return this;
    }

    public ArgumentBuilder addFlatWithAliases(String flat, String... aliases) {
        this.arguments.add(new Argument<>(null, flat, aliases));
        return this;
    }

    public ArgumentBuilder addFlats(String... flat) {
        for (String flatArgument : flat) {
            this.addFlat(flatArgument);
        }
        return this;
    }

    public <T> ArgumentBuilder addArgument(Class<T> clazz, String argument) {
        this.arguments.add(new Argument<T>(ArgumentHandler.getArgumentType(clazz), argument));
        return this;
    }
}
