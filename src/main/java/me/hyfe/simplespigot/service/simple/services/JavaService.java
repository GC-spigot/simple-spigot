package me.hyfe.simplespigot.service.simple.services;

import java.text.NumberFormat;
import java.util.Locale;

public class JavaService {

    public static String format(double number) {
        return NumberFormat.getNumberInstance(Locale.US).format(number);
    }
}
