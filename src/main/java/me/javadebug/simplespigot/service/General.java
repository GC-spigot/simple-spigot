package me.javadebug.simplespigot.service;

public class General {

    public static String formatSeconds(int initialSeconds) {
        int days = initialSeconds / 86400;
        int hours = initialSeconds % 86400 / 3600;
        int minutes = initialSeconds % 3600 / 60;
        int seconds = initialSeconds % 60;
        if (days < 1) {
            return String.format("%dh %dm %ds", hours, minutes, seconds);
        }
        if (hours < 1) {
            return String.format("%dm %ds", minutes, seconds);
        }
        if (minutes < 1) {
            return String.format("%ds", seconds);
        }
        return String.format("%dd %dh %dm %ds", days, hours, minutes, seconds);
    }
}
