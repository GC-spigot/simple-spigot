package me.javadebug.simplespigot.command.command;

import me.javadebug.simplespigot.plugin.SimplePlugin;
import org.bukkit.command.CommandSender;

public abstract class Command {
    protected final SimplePlugin plugin;
    private final String permission;
    private final boolean isConsole;

    public Command(SimplePlugin plugin, String permission, boolean isConsole) {
        this.plugin = plugin;
        this.permission = permission;
        this.isConsole = isConsole;
    }

    public abstract void onExecute(CommandSender commandSender, String[] args);

    public String getPermission() {
        return this.permission;
    }

    public boolean isConsole() {
        return this.isConsole;
    }
}