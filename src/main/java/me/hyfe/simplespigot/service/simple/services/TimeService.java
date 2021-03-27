package me.hyfe.simplespigot.service.simple.services;

import java.util.concurrent.TimeUnit;

public class TimeService {
    private final SimpleTimeFormat defaultFormat = new SimpleTimeFormat("%dy %dmo %dw %dd %dh %dm %ds",
            "%dmo %dw %dd %dh %dm %ds",
            "%dw %dd %dh %dm %ds",
            "%dd %dh %dm %ds",
            "%dh %dm %ds",
            "%dm %ds",
            "%ds");

    public String format(TimeUnit timeUnit, long duration) {
        return this.format(this.defaultFormat, timeUnit, duration);
    }

    public String format(SimpleTimeFormat timeFormat, TimeUnit timeUnit, long duration) {
        long origin = timeUnit.toSeconds(duration);
        long years = origin / 31536000;
        long months = origin % 31536000 / 2592000; // Months calculated with 30 days.
        long weeks = origin % 2592000 / 604800;
        long days = origin % 604800 / 86400;
        long hours = origin % 86400 / 3600;
        long minutes = origin % 3600 / 60;
        long seconds = origin % 60;

        if (years >= 1) {
            return String.format(timeFormat.getYearsMonths(), years, months, weeks, days, hours, minutes, seconds);
        }
        if (months >= 1) {
            return String.format(timeFormat.getMonthsWeeks(), months, weeks, days, hours, minutes, seconds);
        }
        if (weeks >= 1) {
            return String.format(timeFormat.getWeeksDays(), weeks, days, hours, minutes, seconds);
        }
        if (days >= 1) {
            return String.format(timeFormat.getDaysHours(), days, hours, minutes, seconds);
        }
        if (hours >= 1) {
            return String.format(timeFormat.getHoursMinutes(), hours, minutes, seconds);
        }
        if (minutes >= 1) {
            return String.format(timeFormat.getMinutesSeconds(), minutes, seconds);
        }
        return String.format(timeFormat.getSeconds(), seconds);
    }

    public static class SimpleTimeFormat {
        private final String yearsMonths;
        private final String monthsWeeks;
        private final String weeksDays;
        private final String daysHours;
        private final String hoursMinutes;
        private final String minutesSeconds;
        private final String seconds;

        public SimpleTimeFormat(String yearsMonths, String monthsWeeks, String weeksDays, String daysHours, String hoursMinutes, String minutesSeconds, String seconds) {
            this.yearsMonths = yearsMonths;
            this.monthsWeeks = monthsWeeks;
            this.weeksDays = weeksDays;
            this.daysHours = daysHours;
            this.hoursMinutes = hoursMinutes;
            this.minutesSeconds = minutesSeconds;
            this.seconds = seconds;
        }

        public String getYearsMonths() {
            return this.yearsMonths;
        }

        public String getMonthsWeeks() {
            return this.monthsWeeks;
        }

        public String getWeeksDays() {
            return this.weeksDays;
        }

        public String getDaysHours() {
            return this.daysHours;
        }

        public String getHoursMinutes() {
            return this.hoursMinutes;
        }

        public String getMinutesSeconds() {
            return this.minutesSeconds;
        }

        public String getSeconds() {
            return this.seconds;
        }
    }
}
