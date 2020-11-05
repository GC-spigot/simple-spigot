package me.hyfe.simplespigot.text;

import com.google.common.collect.Lists;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;
import java.util.regex.Pattern;

public class Text {
    private static final char SECTION_CHAR = '\u00A7';
    private static final char AMPERSAND_CHAR = '&';
    private static final String COLOR_CODES = "0123456789AaBbCcDdEeFfKkLlMmNnOoRr";
    private static final Pattern STRIP_COLOR_PATTERN = Pattern.compile("(?i)" + SECTION_CHAR + "[0-9A-FK-OR]");

    /**
     * Sends a message to a player, inserts placeholders and replaces colours.
     *
     * @param recipient The CommandSender to send the message to.
     * @param message   The message to send to the CommandSender.
     */
    public static void sendMessage(CommandSender recipient, String message) {
        Supplier<String> processor = () -> {
            if (recipient instanceof OfflinePlayer && Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
                return PlaceholderAPI.setPlaceholders((OfflinePlayer) recipient, message);
            }
            return message;
        };
        recipient.sendMessage(modify(processor.get()));
    }

    /**
     * Sends a message to multiple players, inserts placeholders and replaces colours.
     *
     * @param recipients The CommandSenders to send the message to
     * @param message    The message to send to all the CommandSenders
     */
    public static void sendMessage(Collection<CommandSender> recipients, String message) {
        for (CommandSender commandSender : recipients) {
            String[] lines = message.split("\n");
            for (String line : lines) {
                sendMessage(commandSender, line);
            }
        }
    }

    /**
     * Applies colours
     *
     * @param string The string to modify
     * @return A string which has been modified replacing colours ("&amp;") for use in Minecraft
     */
    public static String modify(String string) {
        return modify(string, null);
    }

    /**
     * Applies colours and replaces certain internally set placeholders
     *
     * @param string   The string to modify
     * @param replacer The replacer to apply to the string.
     * @return A string which has been modified replacing colours ("&amp;") for use in Minecraft
     */
    public static String modify(String string, Replace replacer) {
        return string == null ? null : renderColorCodes(replacer == null ? string : replacer.apply(new Replacer()).applyTo(string));
    }

    /**
     * Applies colours
     *
     * @param list The strings to modify
     * @return A string list which has been modified replacing colours ("&amp;") for use in Minecraft
     */
    public static List<String> modify(List<String> list) {
        return modify(list, null);
    }

    /**
     * Applies colours and replaces certain internally set placeholders
     *
     * @param list     The strings to modify
     * @param replacer The replacer to apply to the string.
     * @return A string which has been modified replacing colours ("&amp;") for use in Minecraft
     */
    public static List<String> modify(List<String> list, Replace replacer) {
        if (list == null) {
            return null;
        }
        List<String> middleList = Lists.newArrayList();
        for (String string : list) {
            middleList.add(modify(string, replacer));
        }
        return middleList;
    }

    /**
     * Applies colours and replaces certain internally set placeholders on an item.
     *
     * @param itemStack The item to modify
     * @param replacer  The replacer to apply to the string.
     * @return An item which has been modified
     */
    public static ItemStack modify(ItemStack itemStack, Replace replacer) {
        ItemStack mutableItem = itemStack.clone();
        ItemMeta itemMeta = mutableItem.getItemMeta();
        if (itemMeta == null) {
            return mutableItem;
        }
        itemMeta.setDisplayName(modify(itemMeta.getDisplayName(), replacer));
        itemMeta.setLore(modify(itemMeta.getLore(), replacer));
        mutableItem.setItemMeta(itemMeta);
        return mutableItem;
    }

    /**
     * Removes colour codes from a string.
     *
     * @param string The string to remove colours from.
     * @return The string with colours removed.
     */
    public static String decolorize(String string) {
        return string == null ? null : unrenderColorCodes(string);
    }

    /**
     * Removes colour codes from a string.
     *
     * @param input The string to remove colours from.
     * @return The string with colours removed.
     */
    private static String unrenderColorCodes(String input) {
        return input == null ? null : STRIP_COLOR_PATTERN.matcher(input).replaceAll("");
    }

    private static String renderColorCodes(String textToRender) {
        char[] charArray = textToRender.toCharArray();
        for (int i = 0; i < charArray.length - 1; i++) {
            if (charArray[i] == Text.AMPERSAND_CHAR && COLOR_CODES.indexOf(charArray[i + 1]) > -1) {
                charArray[i] = Text.SECTION_CHAR;
                charArray[i + 1] = Character.toLowerCase(charArray[i + 1]);
            }
        }
        return new String(charArray);
    }
}