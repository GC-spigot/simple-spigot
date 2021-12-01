package me.hyfe.simplespigot.nbt.enums;

import lombok.SneakyThrows;
import me.hyfe.simplespigot.version.ServerVersion;

import java.lang.reflect.Constructor;

public enum ObjectCreator {
    NMS_NBTTAGCOMPOUND(null, null, ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz()),
    NMS_BLOCKPOSITION(null, null, ClassWrapper.NMS_BLOCKPOSITION.getClazz(), int.class, int.class, int.class),
    NMS_COMPOUNDFROMITEM(ServerVersion.MC1_11_R1, null, ClassWrapper.NMS_ITEMSTACK.getClazz(), ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz()),;

    private Constructor<?> construct;
    private Class<?> targetClass;

    @SneakyThrows
    ObjectCreator(ServerVersion from, ServerVersion to, Class<?> clazz, Class<?>... args) {
        if (clazz == null)
            return;
        if (from != null && ServerVersion.getVersion().getVersionId() < from.getVersionId())
            return;
        if (to != null && ServerVersion.getVersion().getVersionId() > to.getVersionId())
            return;
        try {
            this.targetClass = clazz;
            construct = clazz.getDeclaredConstructor(args);
            construct.setAccessible(true);
        } catch (Exception ex) {
        }
    }

    /**
     * Creates an Object instance with given args
     *
     * @param args
     * @return Object created
     */
    @SneakyThrows
    public Object getInstance(Object... args) {
        try {
            return construct.newInstance(args);
        } catch (Exception ex) {
            return null;
        }
    }

}