package me.hyfe.simplespigot.service.simple;

import me.hyfe.simplespigot.service.simple.services.JavaService;
import me.hyfe.simplespigot.service.simple.services.SpigotService;
import me.hyfe.simplespigot.service.simple.services.TimeService;

public class Simple {
    private static final SpigotService SPIGOT_SERVICE = new SpigotService();
    private static final JavaService JAVA_SERVICE = new JavaService();
    private static final TimeService TIME_SERVICE = new TimeService();

    public static SpigotService spigot() {
        return SPIGOT_SERVICE;
    }

    public static JavaService java() {
        return JAVA_SERVICE;
    }

    public static TimeService time() {
        return TIME_SERVICE;
    }
}
