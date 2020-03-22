package me.hyfe.simplespigot.command.command;

import com.google.common.collect.Lists;
import me.hyfe.simplespigot.command.command.Command;
import me.hyfe.simplespigot.plugin.SimplePlugin;
import me.hyfe.simplespigot.command.argument.Argument;
import me.hyfe.simplespigot.command.argument.ArgumentHandler;
import org.bukkit.command.CommandSender;

import java.util.List;

public abstract class SubCommand<T extends CommandSender> extends Command<T> {
    private List<Argument<?>> arguments = Lists.newArrayList();
    private boolean inheritPermission;

    public SubCommand(SimplePlugin plugin, String permission, boolean isConsole) {
        super(plugin, permission, isConsole);
    }

    public SubCommand(SimplePlugin plugin) {
        super(plugin, "", true);
    }

    public SubCommand(SimplePlugin plugin, String permission) {
        super(plugin, permission, true);
    }

    public SubCommand(SimplePlugin plugin, boolean isConsole) {
        super(plugin, "", isConsole);
    }

    protected void inheritPermission() {
        this.inheritPermission = true;
    }

    public boolean doesInheritPermission() {
        return this.inheritPermission;
    }

    public void setArguments(List<Argument<?>> arguments) {
        this.arguments = arguments;
    }

    public void addFlat(String flat) {
        this.arguments.add(new Argument<>(null, flat));
    }

    public void addFlatWithAliases(String flat, String... aliases) {
        this.arguments.add(new Argument<>(null, flat, aliases));
    }

    public void addFlats(String... flat) {
        for (String flatArgument : flat) {
            this.addFlat(flatArgument);
        }
    }

    protected <S> void addArgument(Class<S> clazz, String argument) {
        this.arguments.add(new Argument<S>(ArgumentHandler.getArgumentType(clazz), argument));
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
            String matchTo = arguments[index];
            for (String alias : argument.getAliases()) {
                if (matchTo.equalsIgnoreCase(alias)) {
                    return true;
                }
            }
            return arguments[index].equalsIgnoreCase(argument.getArgument());
        }
        return true;
    }
}