package me.hyfe.simplespigot.command;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.sun.istack.internal.NotNull;
import me.hyfe.simplespigot.command.argument.ArgumentHandler;
import me.hyfe.simplespigot.command.argument.ArgumentType;
import me.hyfe.simplespigot.command.command.SimpleCommand;
import me.hyfe.simplespigot.command.command.SubCommand;
import me.hyfe.simplespigot.text.Text;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.Set;
import java.util.logging.Level;

public class CommandBase implements CommandExecutor, TabCompleter {
    private final JavaPlugin plugin;
    private Set<SimpleCommand<? extends CommandSender>> commands = Sets.newHashSet();

    public CommandBase(JavaPlugin plugin) {
        this.plugin = plugin;
        this.registerArgumentTypes();
    }

    public void registerCommand(SimpleCommand<? super CommandSender> command) {
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
    public synchronized boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String commandName = command.getName();
        for (SimpleCommand<? extends CommandSender> simpleCommand : this.commands) {
            if (!simpleCommand.getCommand().equalsIgnoreCase(commandName)) {
                continue;
            }
            if (simpleCommand.getPermission() != null && !simpleCommand.getPermission().isEmpty() && !sender.hasPermission(simpleCommand.getPermission())) {
                Text.sendMessage(sender, simpleCommand.getNoPermissionLang(sender));
                return true;
            }
            if (!simpleCommand.isConsole() && sender instanceof ConsoleCommandSender) {
                sender.sendMessage("The console can not execute this command.");
                return true;
            }
            if (args.length == 0) {
                simpleCommand.middleMan(sender, args);
                return true;
            }
            SubCommand<? extends CommandSender> subResult = null;
            for (SubCommand<? extends CommandSender> subCommand : simpleCommand.getSubCommands()) {
                if ((args.length > subCommand.getArgumentsSize() && subCommand.isEndless()) || (subCommand.getArgumentsSize() == args.length && subCommand.isMatch(args))) {
                    subResult = subCommand;
                    break;
                }
            }
            if (subResult == null) {
                simpleCommand.middleMan(sender, args);
                return true;
            }
            if (!subResult.doesInheritPermission() && subResult.getPermission() != null && !sender.hasPermission(subResult.getPermission()) && !simpleCommand.getPermission().isEmpty()) {
                Text.sendMessage(sender, subResult.getNoPermissionLang(sender));
                return true;
            }
            if (!subResult.isConsole() && sender instanceof ConsoleCommandSender) {
                sender.sendMessage("The console can not execute this command.");
                return true;
            }
            subResult.middleMan(sender, args);
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> tabCompleteSuggestions = Lists.newArrayList();
        String commandName = command.getName();
        for (SimpleCommand<? extends CommandSender> simpleCommand : this.commands) {
            if (!simpleCommand.getCommand().equalsIgnoreCase(commandName)) {
                continue;
            }
            if (simpleCommand.getPermission() != null && !simpleCommand.getPermission().isEmpty() && !sender.hasPermission(simpleCommand.getPermission())) {
                continue;
            }
            if (!simpleCommand.isConsole() && sender instanceof ConsoleCommandSender) {
                continue;
            }
            if (args.length == 0) {
                continue;
            }
            Set<SubCommand<? extends CommandSender>> subResults = Sets.newHashSet();
            for (SubCommand<? extends CommandSender> subCommand : simpleCommand.getSubCommands()) {
                if (subCommand.isMatchUntilIndex(args, args.length - 1)) {
                    subResults.add(subCommand);
                }
            }
            if (subResults.isEmpty()) {
                continue;
            }
            for (SubCommand<? extends CommandSender> subResult : subResults) {
                if (!subResult.doesInheritPermission() && subResult.getPermission() != null && !sender.hasPermission(subResult.getPermission()) && !simpleCommand.getPermission().isEmpty()) {
                    continue;
                }
                if (!subResult.isConsole() && sender instanceof ConsoleCommandSender) {
                    continue;
                }
                tabCompleteSuggestions.addAll(subResult.tabCompletionSuggestion(sender, args.length - 1));
            }
        }
        return tabCompleteSuggestions;
    }

    public Set<SimpleCommand<? extends CommandSender>> getCommands() {
        return this.commands;
    }

    private void registerArgumentTypes() {
        this.registerArgumentType(String.class, string -> string)
                .registerArgumentType(Player.class, Bukkit::getPlayerExact)
                .registerArgumentType(OfflinePlayer.class, Bukkit::getOfflinePlayer)
                .registerArgumentType(Integer.class, string -> StringUtils.isNumeric(string) ? Integer.parseInt(string) : -1)
                .registerArgumentType(Boolean.class, string -> string.equalsIgnoreCase("true") ? true : string.equalsIgnoreCase("false") ? false : null);
    }
}