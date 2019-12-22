package me.javadebug.simplespigot.text;

import com.google.common.collect.Lists;
import org.bukkit.command.CommandSender;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

public class Text {
    private static final char SECTION_CHAR = '\u00A7';
    private static final char AMPERSAND_CHAR = '&';
    private static final String COLOR_CODES = "0123456789AaBbCcDdEeFfKkLlMmNnOoRr";
    private static final Pattern STRIP_COLOR_PATTERN = Pattern.compile("(?i)" + SECTION_CHAR + "[0-9A-FK-OR]");

    public static void sendMessage(CommandSender recipient, String message) {
        recipient.sendMessage(Objects.requireNonNull(modify(message)));
    }

    public static void sendMessage(Collection<CommandSender> recipient, String message) {
        for (CommandSender commandSender : recipient) {
            commandSender.sendMessage(message);
        }
    }

    public static String modify(String string, Object... args) {
        return modify(string, null, args);
    }

    public static String modify(String string, UnaryOperator<Replacer> replacerFunction, Object... args) {
        return string == null ? null : renderColorCodes(String.format(replacerFunction == null ? string : replacerFunction.apply(new Replacer()).applyTo(string), args));
    }

    public static List<String> modify(List<String> list) {
        return modify(list, null);
    }

    public static List<String> modify(List<String> list, UnaryOperator<Replacer> replacerFunction) {
        if (list == null) {
            return null;
        }
        List<String> middleList = Lists.newArrayList();
        for (String string : list) {
            middleList.add(modify(string, replacerFunction));
        }
        return middleList;
    }

    public static String decolorize(String string) {
        return string == null ? null : unrenderColorCodes(string);
    }

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