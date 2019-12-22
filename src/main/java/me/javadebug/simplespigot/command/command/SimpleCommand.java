package me.javadebug.simplespigot.command.command;

import com.google.common.collect.Sets;
import me.javadebug.simplespigot.plugin.SimplePlugin;

import java.util.Arrays;
import java.util.Set;

public abstract class SimpleCommand extends Command {
    private final String command;
    private Set<SubCommand> subCommands = Sets.newLinkedHashSet();

    public SimpleCommand(SimplePlugin plugin, String command, String permission, boolean isConsole) {
        super(plugin, permission, isConsole);
        this.command = command;
    }

    public String getCommand() {
        return this.command;
    }


    protected void setSubCommands(SubCommand... subCommands) {
        this.subCommands.addAll(Arrays.asList(subCommands));
    }

    public Set<SubCommand> getSubCommands() {
        return this.subCommands;
    }
}