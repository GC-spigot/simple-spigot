package me.hyfe.simplespigot.command.command.compact;

import com.google.common.collect.Sets;
import me.hyfe.simplespigot.command.argument.Argument;
import me.hyfe.simplespigot.command.command.SubCommand;
import me.hyfe.simplespigot.plugin.SimplePlugin;
import org.bukkit.command.CommandSender;

import java.util.List;
import java.util.Set;
import java.util.function.UnaryOperator;

public class SubChain<T extends CommandSender> {
    private Set<SubCommand<? extends CommandSender>> subCommands = Sets.newHashSet();

    public Set<SubCommand<? extends CommandSender>> getSubCommands() {
        return this.subCommands;
    }

    public SubChain<T> newSub(SimplePlugin plugin, String permission, boolean isConsole, UnaryOperator<ArgumentBuilder> builder, Executor executor) {
        List<Argument<?>> arguments = builder.apply(new ArgumentBuilder()).getArguments();
        SubCommand<T> subCommand = new SubCommand<T>(plugin, permission, isConsole) {

            @Override
            public void onExecute(CommandSender sender, String[] args) {
                executor.execute(sender, args, null);
            }
        };
        subCommand.setArguments(arguments);
        this.subCommands.add(subCommand);
        return this;
    }

    public SubChain<T> newSub(SimplePlugin plugin, UnaryOperator<ArgumentBuilder> builder, Executor executor) {
        return this.newSub(plugin, "", true, builder, executor);
    }

    public SubChain<T> newSub(SimplePlugin plugin, String permission, UnaryOperator<ArgumentBuilder> builder, Executor executor) {
        return this.newSub(plugin, permission, true, builder, executor);
    }

    public SubChain<T> newSub(SimplePlugin plugin, boolean isConsole, UnaryOperator<ArgumentBuilder> builder, Executor executor) {
        return this.newSub(plugin, "", isConsole, builder, executor);
    }
}
