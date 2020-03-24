package me.hyfe.simplespigot.command.command;

import com.google.common.collect.Sets;
import me.hyfe.simplespigot.plugin.SimplePlugin;
import me.hyfe.simplespigot.text.Text;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;

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

    public void setSubCommands(Set<SubCommand<? extends CommandSender>> subCommands) {
        this.subCommands = subCommands;
    }

    protected void setSubCommands(SubCommand<? extends CommandSender>... subCommands) {
        this.subCommands.addAll(Arrays.asList(subCommands));
    }

    public Set<SubCommand<? extends CommandSender>> getSubCommands() {
        return this.subCommands;
    }

    public void sendHelpMessage(Plugin plugin, CommandSender sendTo) {
        PluginDescriptionFile description = plugin.getDescription();
        Text.sendMessage(sendTo, "&f".concat(description.getName()).concat(" &7v").concat(description.getVersion()));
        Text.sendMessage(sendTo, "&7Use &f&n".concat(this.command).concat(" to view usage information."));
    }
}