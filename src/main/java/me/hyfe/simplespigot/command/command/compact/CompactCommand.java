package me.hyfe.simplespigot.command.command.compact;

import me.hyfe.simplespigot.command.command.SimpleCommand;
import me.hyfe.simplespigot.plugin.SimplePlugin;
import org.bukkit.command.CommandSender;

import java.util.function.UnaryOperator;

public abstract class CompactCommand<T extends CommandSender> extends SimpleCommand<T> {

    public CompactCommand(SimplePlugin plugin, String command, String permission, boolean isConsole) {
        super(plugin, command, permission, isConsole);
    }

    public CompactCommand(SimplePlugin plugin, String command, boolean isConsole) {
        super(plugin, command, isConsole);
    }

    public CompactCommand(SimplePlugin plugin, String command, String permission) {
        super(plugin, command, permission);
    }

    public CompactCommand(SimplePlugin plugin, String command) {
        super(plugin, command);
    }

    public void subChain(UnaryOperator<SubChain<? extends CommandSender>> operator) {
        SubChain<? extends CommandSender> subChain = operator.apply(new SubChain<T>());
        this.setSubCommands(subChain.getSubCommands());
    }
}
