package me.hyfe.simplespigot.command.command;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import me.hyfe.simplespigot.command.argument.Argument;
import me.hyfe.simplespigot.command.argument.ArgumentHandler;
import me.hyfe.simplespigot.plugin.SimplePlugin;
import org.bukkit.command.CommandSender;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public abstract class SubCommand<T extends CommandSender> extends Command<T> {
    private final boolean endless;
    private List<Argument<?>> arguments = Lists.newArrayList();
    private boolean inheritPermission;

    public SubCommand(SimplePlugin plugin, String permission, boolean isConsole) {
        this(plugin, permission, isConsole, false);
    }

    public SubCommand(SimplePlugin plugin, String permission, boolean isConsole, boolean endless) {
        super(plugin, permission, isConsole);
        this.endless = endless;
    }

    public SubCommand(SimplePlugin plugin) {
        this(plugin, "", true);
    }

    public SubCommand(SimplePlugin plugin, String permission) {
        this(plugin, permission, true);
    }

    public SubCommand(SimplePlugin plugin, boolean isConsole) {
        this(plugin, "", isConsole);
    }

    protected void inheritPermission() {
        this.inheritPermission = true;
    }

    public boolean doesInheritPermission() {
        return this.inheritPermission;
    }

    public boolean isEndless() {
        return this.endless;
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

    protected <S> void addArgument(Class<S> clazz, String argument, String... aliases) {
        this.arguments.add(new Argument<S>(ArgumentHandler.getArgumentType(clazz), argument, aliases));
    }

    protected <S> void addArgument(Class<S> clazz, String argument, Function<CommandSender, List<String>> onTabComplete, String... aliases) {
        this.arguments.add(new Argument<S>(ArgumentHandler.getArgumentType(clazz), argument, onTabComplete, aliases));
    }

    public int getArgumentsSize() {
        return this.arguments.size();
    }

    @SuppressWarnings("unchecked")
    public <U> U parseArgument(String[] args, int index) {
        return ((Argument<U>) this.arguments.get(index)).getType().parse(args[index]);
    }

    public boolean isMatch(String[] args) {
        return this.isMatchUntilIndex(args, args.length);
    }

    public String[] getEnd(String[] arguments) {
        Set<String> newSet = Sets.newLinkedHashSet();
        for (int i = 0; i < arguments.length; i++) {
            if (i < this.arguments.size() - 1) {
                continue;
            }
            newSet.add(arguments[i]);
        }
        return newSet.toArray(new String[]{});
    }

    public boolean isMatchUntilIndex(String[] args, int index) {
        for (int i = 0; i < index; i++) {
            if (!this.isArgumentValid(args, i)) {
                return false;
            }
        }
        return true;
    }

    public List<String> tabCompletionSuggestion(CommandSender commandSender, int index) {
        if (index > this.arguments.size() - 1) {
            return Lists.newArrayList();
        }
        return this.arguments.get(index).getOnTabComplete().apply(commandSender);
    }

    private boolean isArgumentValid(String[] arguments, int index) {
        if (this.arguments.size() - 1 < index && this.endless) {
            return true;
        }
        if (this.arguments.size() - 1 < index) {
            return false;
        }
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