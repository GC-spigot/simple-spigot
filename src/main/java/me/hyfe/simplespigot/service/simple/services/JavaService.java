package me.hyfe.simplespigot.service.simple.services;

import java.text.NumberFormat;
import java.util.Locale;

public class JavaService {

    public String formatNumber(Locale locale, double number) {
        return NumberFormat.getNumberInstance(locale).format(number);
    }
}
