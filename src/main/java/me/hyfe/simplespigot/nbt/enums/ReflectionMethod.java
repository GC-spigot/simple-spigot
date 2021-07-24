package me.hyfe.simplespigot.nbt.enums;

import com.mojang.authlib.GameProfile;
import me.hyfe.simplespigot.version.ServerVersion;
import org.bukkit.inventory.ItemStack;

import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public enum ReflectionMethod {
    COMPOUND_SET_FLOAT(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[]{String.class, float.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "setFloat")),
    COMPOUND_SET_STRING(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[]{String.class, String.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "setString")),
    COMPOUND_SET_INT(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[]{String.class, int.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "setInt")),
    COMPOUND_SET_BYTEARRAY(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[]{String.class, byte[].class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "setByteArray")),
    COMPOUND_SET_INTARRAY(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[]{String.class, int[].class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "setIntArray")),
    COMPOUND_SET_LONG(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[]{String.class, long.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "setLong")),
    COMPOUND_SET_SHORT(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[]{String.class, short.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "setShort")),
    COMPOUND_SET_BYTE(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[]{String.class, byte.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "setByte")),
    COMPOUND_SET_DOUBLE(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[]{String.class, double.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "setDouble")),
    COMPOUND_SET_BOOLEAN(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[]{String.class, boolean.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "setBoolean")),
    COMPOUND_MERGE(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[]{ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz()}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "a")), //FIXME: No Spigot mapping!
    COMPOUND_SET(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[]{String.class, ClassWrapper.NMS_NBTBASE.getClazz()}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "set")),
    COMPOUND_GET(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[]{String.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "get")),
    COMPOUND_GET_LIST(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[]{String.class, int.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "getList")),

    COMPOUND_GET_FLOAT(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[]{String.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "getFloat")),
    COMPOUND_GET_STRING(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[]{String.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "getString")),
    COMPOUND_GET_INT(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[]{String.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "getInt")),
    COMPOUND_GET_BYTEARRAY(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[]{String.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "getByteArray")),
    COMPOUND_GET_INTARRAY(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[]{String.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "getIntArray")),
    COMPOUND_GET_LONG(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[]{String.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "getLong")),
    COMPOUND_GET_SHORT(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[]{String.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "getShort")),
    COMPOUND_GET_BYTE(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[]{String.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "getByte")),
    COMPOUND_GET_DOUBLE(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[]{String.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "getDouble")),
    COMPOUND_GET_BOOLEAN(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[]{String.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "getBoolean")),
    COMPOUND_GET_COMPOUND(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[]{String.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "getCompound")),

    NMSITEM_GETTAG(ClassWrapper.NMS_ITEMSTACK.getClazz(), new Class[]{}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "getTag")),
    NMSITEM_SAVE(ClassWrapper.NMS_ITEMSTACK.getClazz(), new Class[]{ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz()}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "save")),
    NMSITEM_CREATESTACK(ClassWrapper.NMS_ITEMSTACK.getClazz(), new Class[]{ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz()}, ServerVersion.MC1_7_R4, ServerVersion.MC1_10_R1, new Since(ServerVersion.MC1_7_R4, "createStack")),

    COMPOUND_REMOVE_KEY(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[]{String.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "remove")),
    COMPOUND_HAS_KEY(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[]{String.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "hasKey")),
    COMPOUND_GET_TYPE(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[]{String.class}, ServerVersion.MC1_8_R3, new Since(ServerVersion.MC1_8_R3, "b"), new Since(ServerVersion.MC1_9_R1, "d"), new Since(ServerVersion.MC1_15_R1, "e"), new Since(ServerVersion.MC1_16_R1, "d")), //FIXME: No Spigot mapping!
    COMPOUND_GET_KEYS(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[]{}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "c"), new Since(ServerVersion.MC1_13_R1, "getKeys")),

    LISTCOMPOUND_GET_KEYS(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[]{}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "c"), new Since(ServerVersion.MC1_13_R1, "getKeys")),
    LIST_REMOVE_KEY(ClassWrapper.NMS_NBTTAGLIST.getClazz(), new Class[]{int.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "a"), new Since(ServerVersion.MC1_9_R1, "remove")),
    LIST_SIZE(ClassWrapper.NMS_NBTTAGLIST.getClazz(), new Class[]{}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "size")),
    LIST_SET(ClassWrapper.NMS_NBTTAGLIST.getClazz(), new Class[]{int.class, ClassWrapper.NMS_NBTBASE.getClazz()}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "a"), new Since(ServerVersion.MC1_13_R1, "set")),
    LEGACY_LIST_ADD(ClassWrapper.NMS_NBTTAGLIST.getClazz(), new Class[]{ClassWrapper.NMS_NBTBASE.getClazz()}, ServerVersion.MC1_7_R4, ServerVersion.MC1_13_R2, new Since(ServerVersion.MC1_7_R4, "add")),
    LIST_ADD(ClassWrapper.NMS_NBTTAGLIST.getClazz(), new Class[]{int.class, ClassWrapper.NMS_NBTBASE.getClazz()}, ServerVersion.MC1_14_R1, new Since(ServerVersion.MC1_14_R1, "add")),
    LIST_GET_STRING(ClassWrapper.NMS_NBTTAGLIST.getClazz(), new Class[]{int.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "getString")),
    LIST_GET_COMPOUND(ClassWrapper.NMS_NBTTAGLIST.getClazz(), new Class[]{int.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "get")),
    LIST_GET(ClassWrapper.NMS_NBTTAGLIST.getClazz(), new Class[]{int.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "g"), new Since(ServerVersion.MC1_9_R1, "h"), new Since(ServerVersion.MC1_12_R1, "i"), new Since(ServerVersion.MC1_13_R1, "get")),

    ITEMSTACK_SET_TAG(ClassWrapper.NMS_ITEMSTACK.getClazz(), new Class[]{ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz()}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "setTag")),
    ITEMSTACK_NMSCOPY(ClassWrapper.CRAFT_ITEMSTACK.getClazz(), new Class[]{ItemStack.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "asNMSCopy")),
    ITEMSTACK_BUKKITMIRROR(ClassWrapper.CRAFT_ITEMSTACK.getClazz(), new Class[]{ClassWrapper.NMS_ITEMSTACK.getClazz()}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "asCraftMirror")),

    CRAFT_WORLD_GET_HANDLE(ClassWrapper.CRAFT_WORLD.getClazz(), new Class[]{}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "getHandle")),
    NMS_WORLD_GET_TILEENTITY(ClassWrapper.NMS_WORLDSERVER.getClazz(), new Class[]{ClassWrapper.NMS_BLOCKPOSITION.getClazz()}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "getTileEntity")),
    NMS_WORLD_SET_TILEENTITY(ClassWrapper.NMS_WORLDSERVER.getClazz(), new SinceArgs[]{new SinceArgs(ServerVersion.MC1_7_R4, new Class[]{ClassWrapper.NMS_BLOCKPOSITION.getClazz(), ClassWrapper.NMS_TILEENTITY.getClazz()} ), new SinceArgs(ServerVersion.MC1_17_R1, new Class[]{ClassWrapper.NMS_TILEENTITY.getClazz()})}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "setTileEntity")),
    NMS_WORLD_REMOVE_TILEENTITY(ClassWrapper.NMS_WORLDSERVER.getClazz(), new Class[]{ClassWrapper.NMS_BLOCKPOSITION.getClazz()}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "t"), new Since(ServerVersion.MC1_9_R1, "s"), new Since(ServerVersion.MC1_13_R1, "n"), new Since(ServerVersion.MC1_14_R1, "removeTileEntity")),

    TILEENTITY_LOAD_LEGACY191(ClassWrapper.NMS_TILEENTITY.getClazz(), new Class[]{ClassWrapper.NMS_MINECRAFTSERVER.getClazz(), ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz()}, ServerVersion.MC1_9_R1, ServerVersion.MC1_9_R1, new Since(ServerVersion.MC1_9_R1, "a")), //FIXME: No Spigot mapping!
    TILEENTITY_LOAD_LEGACY183(ClassWrapper.NMS_TILEENTITY.getClazz(), new Class[]{ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz()}, ServerVersion.MC1_8_R3, ServerVersion.MC1_9_R2, new Since(ServerVersion.MC1_8_R3, "c"), new Since(ServerVersion.MC1_9_R1, "a"), new Since(ServerVersion.MC1_9_R2, "c")), //FIXME: No Spigot mapping!
    TILEENTITY_LOAD_LEGACY1121(ClassWrapper.NMS_TILEENTITY.getClazz(), new Class[]{ClassWrapper.NMS_WORLD.getClazz(), ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz()}, ServerVersion.MC1_10_R1, ServerVersion.MC1_12_R1, new Since(ServerVersion.MC1_10_R1, "a"), new Since(ServerVersion.MC1_12_R1, "create")),
    TILEENTITY_LOAD(ClassWrapper.NMS_TILEENTITY.getClazz(), new SinceArgs[]{new SinceArgs(ServerVersion.MC1_12_R1, new Class[]{ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz()}), new SinceArgs(ServerVersion.MC1_17_R1, new Class[]{ClassWrapper.NMS_BLOCKPOSITION.getClazz(), ClassWrapper.NMS_IBLOCKDATA.getClazz(), ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz()})}, ServerVersion.MC1_13_R1, new Since(ServerVersion.MC1_12_R1, "create")),

    TILEENTITY_GET_NBT(ClassWrapper.NMS_TILEENTITY.getClazz(), new Class[]{ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz()}, ServerVersion.MC1_8_R3, new Since(ServerVersion.MC1_8_R3, "b"), new Since(ServerVersion.MC1_9_R1, "save")),
    TILEENTITY_SET_NBT(ClassWrapper.NMS_TILEENTITY.getClazz(), new Class[]{ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz()}, ServerVersion.MC1_8_R3, new Since(ServerVersion.MC1_8_R3, "a"), new Since(ServerVersion.MC1_12_R1, "load")),

    CRAFT_ENTITY_GET_HANDLE(ClassWrapper.CRAFT_ENTITY.getClazz(), new Class[]{}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "getHandle")),
    NMS_ENTITY_SET_NBT(ClassWrapper.NMS_ENTITY.getClazz(), new Class[]{ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz()}, ServerVersion.MC1_8_R3, new Since(ServerVersion.MC1_8_R3, "f"), new Since(ServerVersion.MC1_17_R1, "save")), //FIXME: No Spigot mapping!
    NMS_ENTITY_GET_NBT(ClassWrapper.NMS_ENTITY.getClazz(), new Class[]{ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz()}, ServerVersion.MC1_8_R3, new Since(ServerVersion.MC1_8_R3, "e"), new Since(ServerVersion.MC1_12_R1, "save")),
    NMS_ENTITY_GETSAVEID(ClassWrapper.NMS_ENTITY.getClazz(), new Class[]{}, ServerVersion.MC1_14_R1, new Since(ServerVersion.MC1_14_R1, "getSaveID")),

    NBTFILE_READ(ClassWrapper.NMS_NBTCOMPRESSEDSTREAMTOOLS.getClazz(), new Class[]{InputStream.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "a")), //FIXME: No Spigot mapping!
    NBTFILE_WRITE(ClassWrapper.NMS_NBTCOMPRESSEDSTREAMTOOLS.getClazz(), new Class[]{ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), OutputStream.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "a")), //FIXME: No Spigot mapping!


    PARSE_NBT(ClassWrapper.NMS_MOJANGSONPARSER.getClazz(), new Class[]{String.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "parse")),
    REGISTRY_KEYSET(ClassWrapper.NMS_REGISTRYSIMPLE.getClazz(), new Class[]{}, ServerVersion.MC1_11_R1, ServerVersion.MC1_13_R1, new Since(ServerVersion.MC1_11_R1, "keySet")),
    REGISTRY_GET(ClassWrapper.NMS_REGISTRYSIMPLE.getClazz(), new Class[]{Object.class}, ServerVersion.MC1_11_R1, ServerVersion.MC1_13_R1, new Since(ServerVersion.MC1_11_R1, "get")),
    REGISTRY_SET(ClassWrapper.NMS_REGISTRYSIMPLE.getClazz(), new Class[]{Object.class, Object.class}, ServerVersion.MC1_11_R1, ServerVersion.MC1_13_R1, new Since(ServerVersion.MC1_11_R1, "a")), //FIXME: No Spigot mapping!
    REGISTRY_GET_INVERSE(ClassWrapper.NMS_REGISTRYMATERIALS.getClazz(), new Class[]{Object.class}, ServerVersion.MC1_11_R1, ServerVersion.MC1_13_R1, new Since(ServerVersion.MC1_11_R1, "b")), //FIXME: No Spigot mapping!
    REGISTRYMATERIALS_KEYSET(ClassWrapper.NMS_REGISTRYMATERIALS.getClazz(), new Class[]{}, ServerVersion.MC1_13_R1, new Since(ServerVersion.MC1_13_R1, "keySet")),
    REGISTRYMATERIALS_GET(ClassWrapper.NMS_REGISTRYMATERIALS.getClazz(), new Class[]{ClassWrapper.NMS_MINECRAFTKEY.getClazz()}, ServerVersion.MC1_13_R1, new Since(ServerVersion.MC1_13_R1, "get")),

    GAMEPROFILE_DESERIALIZE(ClassWrapper.NMS_GAMEPROFILESERIALIZER.getClazz(), new Class[]{ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz()}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "deserialize")),
    GAMEPROFILE_SERIALIZE(ClassWrapper.NMS_GAMEPROFILESERIALIZER.getClazz(), new Class[]{ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), GameProfile.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "serialize"));

    private Method method;
    private boolean loaded = false;
    private boolean compatible = false;
    private String methodName = null;

    ReflectionMethod(Class<?> targetClass, Class<?>[] args, ServerVersion addedSince, ServerVersion removedAfter, Since... methodNames) {
        ServerVersion server = ServerVersion.getVersion();
        if (server.compareTo(addedSince) < 0 || (removedAfter != null && server.getVersionId() > removedAfter.getVersionId())) {
            return;
        }
        this.compatible = true;
        Since target = methodNames[0];
        for (Since since : methodNames) {
            if (since.version.getVersionId() <= server.getVersionId() && target.version.getVersionId() < since.version.getVersionId())
                target = since;
        }
        Since targetVersion = target;
        try {
            this.method = targetClass.getMethod(targetVersion.name, args);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        this.method.setAccessible(true);
        this.loaded = true;
        this.methodName = targetVersion.name;
    }

    ReflectionMethod(Class<?> targetClass, Class<?>[] args, ServerVersion addedSince, Since... methodNames) {
        this(targetClass, args, addedSince, null, methodNames);
    }

    ReflectionMethod(Class<?> targetClass, SinceArgs[] args, ServerVersion addedSince, Since... methodNames) {
        this(targetClass, getParams(args), addedSince, null, methodNames);
    }

    private static Class<?>[] getParams(SinceArgs[] args) {
        SinceArgs temp = null;
        for (SinceArgs arg : args) {
            if (temp != null) {
                if (arg.version.getVersionId() <= temp.version.getVersionId()) {
                    continue;
                }
            }
            if (arg.version.getVersionId() <= ServerVersion.getVersion().getVersionId())
                temp = arg;
        }
        return temp.args;
    }

    public Object run(Object target, Object... args) {
        try {
            return this.method == null ? null : this.method.invoke(target, args);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getMethodName() {
        return this.methodName;
    }

    public boolean isLoaded() {
        return this.loaded;
    }

    public boolean isCompatible() {
        return this.compatible;
    }

    protected static class Since {
        private final ServerVersion version;
        private final String name;

        public Since(ServerVersion version, String name) {
            this.version = version;
            this.name = name;
        }
    }

    protected static class SinceArgs {
        private final ServerVersion version;
        private final Class<?>[] args;

        public SinceArgs(ServerVersion version, Class<?>[] args) {
            this.version = version;
            this.args = args;
        }
    }

}