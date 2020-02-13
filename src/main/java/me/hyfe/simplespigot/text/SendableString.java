package me.hyfe.simplespigot.text;

import org.bukkit.command.CommandSender;

import java.util.Collection;

public class SendableString {
    private final String string;

    public SendableString(String string) {
        this.string = string;
    }

    public void to(CommandSender recipient) {
        Text.sendMessage(recipient, this.string);
    }

    public void to(Collection<CommandSender> recipients) {
        Text.sendMessage(recipients, this.string);
    }

    public static SendableString from(String string) {
        return new SendableString(string);
    }
}