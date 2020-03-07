package me.hyfe.simplespigot.command.command.preset;

import me.hyfe.simplespigot.command.command.SimpleCommand;
import me.hyfe.simplespigot.command.command.SubCommand;
import me.hyfe.simplespigot.plugin.SimplePlugin;
import org.bukkit.command.CommandSender;

public class HelpSub extends SubCommand<CommandSender> {

    public HelpSub(SimplePlugin plugin, SimpleCommand<?> command) {
        super(plugin, "", true);
    }

    @Override
    public void onExecute(CommandSender sender, String[] args) {

    }
}
