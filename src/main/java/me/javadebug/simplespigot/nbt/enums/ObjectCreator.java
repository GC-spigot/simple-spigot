package me.javadebug.simplespigot.nbt.enums;

import lombok.SneakyThrows;
import me.javadebug.simplespigot.version.ServerVersion;

import java.lang.reflect.Constructor;

public enum ObjectCreator {
    NMS_NBTTAGCOMPOUND(null, null, ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz()),
    NMS_COMPOUNDFROMITEM(ServerVersion.MC1_11_R1, null, ClassWrapper.NMS_ITEMSTACK.getClazz(), ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz());

    private Constructor<?> construct;

    @SneakyThrows
    ObjectCreator(ServerVersion from, ServerVersion to, Class<?> clazz, Class<?>... args) {
        if ((from != null && ServerVersion.getVersion().getVersionId() < from.getVersionId()) || (to != null && ServerVersion.getVersion().getVersionId() > to.getVersionId())) {
            return;
        }
        this.construct = clazz.getDeclaredConstructor(args);
        this.construct.setAccessible(true);
    }

    @SneakyThrows
    public Object getInstance(Object... args) {
        return this.construct.newInstance(args);
    }

}