package me.hyfe.simplespigot.service.simple.services;

import java.util.concurrent.TimeUnit;

public class TimeService {

    public static String format(TimeUnit timeUnit, long duration) {
        long origin = timeUnit.toSeconds(duration);
        long years = origin / 31536000;
        long months = origin % 31536000 / 2592000; // Months calculated with 30 days.
        long weeks = origin % 2592000 / 604800;
        long days = origin % 604800 / 86400;
        long hours = origin % 86400 / 3600;
        long minutes = origin % 3600 / 60;
        long seconds = origin % 60;

        if (minutes < 1) {
            return String.format("%ds", seconds);
        }
        if (hours < 1) {
            return String.format("%dm %ds", minutes, seconds);
        }
        if (days < 1) {
            return String.format("%dh %dm %ds", hours, minutes, seconds);
        }
        if (weeks < 1) {
            return String.format("%dd %dh %dm %ds", days, hours, minutes, seconds);
        }
        if (months < 1) {
            return String.format("%dw %dd %dh %dm %ds", weeks, days, hours, minutes, seconds);
        }
        if (years < 1) {
            return String.format("%dmo %dw %dd %dh %dm %ds", months, weeks, days, hours, minutes, seconds);
        }
        return String.format("%dy %dmo %dw %dd %dh %dm %ds", years, months, weeks, days, hours, minutes, seconds);
    }
}
