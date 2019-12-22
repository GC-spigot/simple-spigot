package me.javadebug.simplespigot.command.command;

import com.google.common.collect.Lists;
import me.javadebug.simplespigot.command.argument.Argument;
import me.javadebug.simplespigot.command.argument.ArgumentHandler;
import me.javadebug.simplespigot.plugin.SimplePlugin;

import java.util.List;

public abstract class SubCommand extends Command {
    private final boolean isAsync;
    private final List<Argument<?>> arguments = Lists.newArrayList();

    public SubCommand(SimplePlugin plugin, String permission, boolean isConsole, boolean isAsync) {
        super(plugin, permission, isConsole);
        this.isAsync = isAsync;
    }

    public void addArgument(String flatArgument) {
        this.arguments.add(new Argument<>(null, flatArgument));
    }

    protected <T> void addArgument(Class<?> clazz, String argument) {
        this.arguments.add(new Argument<T>(ArgumentHandler.getArgumentType(clazz), argument));
    }

    public boolean isAsync() {
        return this.isAsync;
    }

    public int getArgumentsSize() {
        return this.arguments.size();
    }

    @SuppressWarnings("unchecked")
    public <T> T parseArgument(String[] args, int index) {
        return ((Argument<T>) this.arguments.get(index)).getType().parse(args[index]);
    }

    public boolean isMatch(String[] arguments) {
        for (int i = 0; i < arguments.length; i++) {
            if (!this.isArgumentValid(arguments, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean isArgumentValid(String[] arguments, int index) {
        Argument<?> argument = this.arguments.get(index);
        if (argument.getType() == null) {
            return arguments[index].equalsIgnoreCase(argument.getArgument());
        }
        return true;
    }
}