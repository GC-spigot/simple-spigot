package me.javadebug.simplespigot.command.command;

import me.javadebug.simplespigot.plugin.SimplePlugin;
import org.bukkit.command.CommandSender;

import java.util.function.Function;

public abstract class Command<T extends CommandSender> {
    protected final SimplePlugin plugin;
    private final String permission;
    private final boolean isConsole;
    private Function<T, String> noPermission;

    public Command(SimplePlugin plugin, String permission, boolean isConsole) {
        this.plugin = plugin;
        this.permission = permission;
        this.isConsole = isConsole;
        this.noPermission = player -> "&cYou do not have permission to do this";
    }

    public abstract void onExecute(T sender, String[] args);

    @SuppressWarnings("unchecked")
    public void middleMan(CommandSender sender, String[] args) {
        this.onExecute((T) sender, args);
    }

    public String getPermission() {
        return this.permission;
    }

    public boolean isConsole() {
        return this.isConsole;
    }

    public void noPermissionLang(Function<T, String> noPermission) {
        this.noPermission = noPermission;
    }

    @SuppressWarnings("unchecked")
    public String getNoPermissionLang(CommandSender sender) {
        return this.noPermission.apply((T) sender);
    }
}