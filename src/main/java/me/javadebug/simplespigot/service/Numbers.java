package me.javadebug.simplespigot.service;

import java.text.NumberFormat;
import java.util.Locale;

public class Numbers {

    public static String format(double number) {
        return NumberFormat.getNumberInstance(Locale.US).format(number);
    }
}
