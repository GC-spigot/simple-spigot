package me.hyfe.simplespigot.version;

import org.apache.logging.log4j.core.Core;
import org.bukkit.Bukkit;
import org.bukkit.Server;

import java.util.logging.Level;

public enum ServerVersion {

    Unknown(Integer.MAX_VALUE),
    MC1_7_R4(174),
    MC1_8_R1(181),
    MC1_8_R2(182),
    MC1_8_R3(183),
    MC1_9_R1(191),
    MC1_9_R2(192),
    MC1_10_R1(1101),
    MC1_11_R1(1111),
    MC1_12_R1(1121),
    MC1_13_R1(1131),
    MC1_13_R2(1132),
    MC1_14_R1(1141),
    MC1_15_R1(1151),
    MC1_16_R1(1161),
    MC1_16_R2(1162),
    MC1_16_R3(1163),
    MC1_16_R4(1164),
    MC1_17_R1(1170),
    MC1_17_R2(1171);

    private static ServerVersion serverVersion;
    private final int versionId;

    ServerVersion(int versionId) {
        this.versionId = versionId;
    }

    /**
     * Gets the version the server is running.
     *
     * @return The ServerVersion of the server
     */
    public static ServerVersion getVersion() {
        if (serverVersion != null) {
            return serverVersion;
        }
        final String ver = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];

        try {
            serverVersion = ServerVersion.valueOf(ver.replace("v", "MC"));
        } catch (IllegalArgumentException ex) {
            serverVersion = Unknown;
        }
        if (serverVersion == Unknown) {
            System.out.println("[BattlePass] You are using invalid version of Minecraft [" + ver + "]!");
        }
        return serverVersion;
    }

    /**
     * Identifies if the server is above or below 1.12.2.
     *
     * @return A boolean of whether the server is over 1.12.2.
     */
    public static boolean isOver_V1_12() {
        return getVersion().getVersionId() > 1121;
    }

    /**
     * Gets the specific version number of the server.
     *
     * @return An integer of the specific version number of the server.
     */
    public int getVersionId() {
        return versionId;
    }

    public boolean isThis() {
        return this.versionId == getVersion().versionId;
    }
}
