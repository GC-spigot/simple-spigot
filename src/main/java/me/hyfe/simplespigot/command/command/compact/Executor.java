package me.hyfe.simplespigot.command.command.compact;

import me.hyfe.simplespigot.command.command.SubCommand;
import org.bukkit.command.CommandSender;

public interface Executor {

    void execute(CommandSender sender, String[] args, SubCommand<CommandSender> sub);
}
