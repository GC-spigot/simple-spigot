package me.hyfe.simplespigot.text;

import org.bukkit.command.CommandSender;

import java.util.Collection;

public class SendableString {
    private final String string;

    /**
     * Creates a new SendableString class with a persisting value.
     *
     * @param string The value assigned to the class.
     */
    public SendableString(String string) {
        this.string = string;
    }

    /**
     * Gets a SendableString from a String.
     *
     * @param string The string to convert to a SendableString.
     * @return A SendableString.
     */
    public static SendableString from(String string) {
        return new SendableString(string);
    }

    /**
     * Sends the message in the class to a CommandSender.
     *
     * @param recipient The CommandSender to send the message to.
     */
    public void to(CommandSender recipient) {
        Text.sendMessage(recipient, this.string);
    }

    /**
     * Sends the message in the class to lots of CommandSenders
     *
     * @param recipients The CommandSenders to send the message to.
     */
    public void to(Collection<CommandSender> recipients) {
        Text.sendMessage(recipients, this.string);
    }
}