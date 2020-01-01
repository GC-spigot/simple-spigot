package me.javadebug.simplespigot.command;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Sets;
import me.javadebug.simplespigot.command.argument.ArgumentHandler;
import me.javadebug.simplespigot.command.argument.ArgumentType;
import me.javadebug.simplespigot.command.command.SimpleCommand;
import me.javadebug.simplespigot.command.command.SubCommand;
import me.javadebug.simplespigot.text.Text;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;

public class CommandBase implements CommandExecutor {
    private final JavaPlugin plugin;
    private final String noPermissionMessage;
    private Set<SimpleCommand> commands = Sets.newHashSet();

    public CommandBase(JavaPlugin plugin) {
        this.plugin = plugin;
        this.noPermissionMessage = "No permission";
        this.registerArgumentTypes();
    }

    public void registerCommand(SimpleCommand command) {
        PluginCommand pluginCommand = this.plugin.getCommand(command.getCommand());
        if (pluginCommand == null) {
            Bukkit.getLogger().log(Level.WARNING, "Failed to load the command " + command.getCommand());
            return;
        }
        pluginCommand.setExecutor(this);
        this.commands.add(command);
    }

    public CommandBase registerArgumentType(Class<?> clazz, ArgumentType<?> argumentType) {
        ArgumentHandler.register(clazz, argumentType);
        return this;
    }

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        String commandName = command.getName();
        for (SimpleCommand simpleCommand : this.commands) {
            if (!simpleCommand.getCommand().equalsIgnoreCase(commandName)) {
                continue;
            }
            if (simpleCommand.getPermission() != null && !sender.hasPermission(simpleCommand.getPermission())) {
                Text.sendMessage(sender, this.noPermissionMessage);
                return true;
            }
            if (!simpleCommand.isConsole() && sender instanceof ConsoleCommandSender) {
                sender.sendMessage("The console can not execute this command.");
                return true;
            }
            if (args.length == 0) {
                simpleCommand.onExecute(sender, args);
                return true;
            }
            SubCommand subResult = null;
            for (SubCommand subCommand : simpleCommand.getSubCommands()) {
                if (subCommand.getArgumentsSize() == args.length && subCommand.isMatch(args)) {
                    subResult = subCommand;
                    break;
                }
            }
            if (subResult == null) {
                simpleCommand.onExecute(sender, args);
                return true;
            }
            if (subResult.getPermission() != null && !sender.hasPermission(subResult.getPermission())) {
                Text.sendMessage(sender, this.noPermissionMessage);
                return true;
            }
            if (!subResult.isConsole() && sender instanceof ConsoleCommandSender) {
                sender.sendMessage("The console can not execute this command.");
                return true;
            }
            if (subResult.isAsync()) {
                AtomicReference<SubCommand> atomicSubResult = new AtomicReference<>(subResult);
                Bukkit.getScheduler().runTaskAsynchronously(this.plugin, () -> atomicSubResult.get().onExecute(sender, args));
            } else {
                subResult.onExecute(sender, args);
            }
        }
        return false;
    }

    private void registerArgumentTypes() {
        this.registerArgumentType(String.class, string -> string)
                .registerArgumentType(Player.class, Bukkit::getPlayerExact)
                .registerArgumentType(OfflinePlayer.class, Bukkit::getOfflinePlayer)
                .registerArgumentType(Integer.class, string -> StringUtils.isNumeric(string) ? Integer.parseInt(string) : -1)
                .registerArgumentType(Boolean.class, string -> string.equalsIgnoreCase("true") ? true : string.equalsIgnoreCase("false") ? false : null);
    }
}