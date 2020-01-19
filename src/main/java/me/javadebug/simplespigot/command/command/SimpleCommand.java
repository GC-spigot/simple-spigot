package me.javadebug.simplespigot.command.command;

import com.google.common.collect.Sets;
import me.javadebug.simplespigot.plugin.SimplePlugin;
import org.bukkit.command.CommandSender;

import java.util.Arrays;
import java.util.Set;

public abstract class SimpleCommand<T extends CommandSender> extends Command<T> {
    private final String command;
    private Set<SubCommand<? extends CommandSender>> subCommands = Sets.newLinkedHashSet();

    public SimpleCommand(SimplePlugin plugin, String command, String permission, boolean isConsole) {
        super(plugin, permission, isConsole);
        this.command = command;
    }

    public SimpleCommand(SimplePlugin plugin, String command, boolean isConsole) {
        this(plugin, command, "", isConsole);
    }

    public SimpleCommand(SimplePlugin plugin, String command, String permission) {
        this(plugin, command, permission, true);
    }

    public SimpleCommand(SimplePlugin plugin, String command) {
        this(plugin, command, true);
    }

    public String getCommand() {
        return this.command;
    }

    protected void setSubCommands(SubCommand<? extends CommandSender>... subCommands) {
        this.subCommands.addAll(Arrays.asList(subCommands));
    }

    public Set<SubCommand<? extends CommandSender>> getSubCommands() {
        return this.subCommands;
    }
}