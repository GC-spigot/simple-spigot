package me.javadebug.simplespigot.command.command;

import com.google.common.collect.Lists;
import me.javadebug.simplespigot.command.argument.Argument;
import me.javadebug.simplespigot.command.argument.ArgumentHandler;
import me.javadebug.simplespigot.plugin.SimplePlugin;
import org.bukkit.command.CommandSender;

import java.util.List;

public abstract class SubCommand<T extends CommandSender> extends Command<T> {
    private final List<Argument<?>> arguments = Lists.newArrayList();

    public SubCommand(SimplePlugin plugin, String permission, boolean isConsole) {
        super(plugin, permission, isConsole);
    }

    public void addArgument(String flatArgument) {
        this.arguments.add(new Argument<>(null, flatArgument));
    }

    protected <U> void addArgument(Class<U> clazz, String argument) {
        this.arguments.add(new Argument<U>(ArgumentHandler.getArgumentType(clazz), argument));
    }

    public int getArgumentsSize() {
        return this.arguments.size();
    }

    @SuppressWarnings("unchecked")
    public <U> U parseArgument(String[] args, int index) {
        return ((Argument<U>) this.arguments.get(index)).getType().parse(args[index]);
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