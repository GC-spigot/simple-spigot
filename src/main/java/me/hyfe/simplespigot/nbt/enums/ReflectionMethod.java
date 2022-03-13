package me.hyfe.simplespigot.nbt.enums;

import com.mojang.authlib.GameProfile;
import me.hyfe.simplespigot.nbt.MojangToMapping;
import me.hyfe.simplespigot.version.ServerVersion;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.UUID;

public enum ReflectionMethod {

    COMPOUND_SET_FLOAT(ClassWrapper.NMS_NBTTAGCOMPOUND, new Class[]{String.class, float.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "setFloat"), new Since(ServerVersion.MC1_18_R1, "putFloat(java.lang.String,float)")),
    COMPOUND_SET_STRING(ClassWrapper.NMS_NBTTAGCOMPOUND, new Class[]{String.class, String.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "setString"), new Since(ServerVersion.MC1_18_R1, "putString(java.lang.String,java.lang.String)")),
    COMPOUND_SET_INT(ClassWrapper.NMS_NBTTAGCOMPOUND, new Class[]{String.class, int.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "setInt"), new Since(ServerVersion.MC1_18_R1, "putInt(java.lang.String,int)")),
    COMPOUND_SET_BYTEARRAY(ClassWrapper.NMS_NBTTAGCOMPOUND, new Class[]{String.class, byte[].class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "setByteArray"), new Since(ServerVersion.MC1_18_R1, "putByteArray(java.lang.String,byte[])")),
    COMPOUND_SET_INTARRAY(ClassWrapper.NMS_NBTTAGCOMPOUND, new Class[]{String.class, int[].class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "setIntArray"), new Since(ServerVersion.MC1_18_R1, "putIntArray(java.lang.String,int[])")),
    COMPOUND_SET_LONG(ClassWrapper.NMS_NBTTAGCOMPOUND, new Class[]{String.class, long.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "setLong"), new Since(ServerVersion.MC1_18_R1, "putLong(java.lang.String,long)")),
    COMPOUND_SET_SHORT(ClassWrapper.NMS_NBTTAGCOMPOUND, new Class[]{String.class, short.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "setShort"), new Since(ServerVersion.MC1_18_R1, "putShort(java.lang.String,short)")),
    COMPOUND_SET_BYTE(ClassWrapper.NMS_NBTTAGCOMPOUND, new Class[]{String.class, byte.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "setByte"), new Since(ServerVersion.MC1_18_R1, "putByte(java.lang.String,byte)")),
    COMPOUND_SET_DOUBLE(ClassWrapper.NMS_NBTTAGCOMPOUND, new Class[]{String.class, double.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "setDouble"), new Since(ServerVersion.MC1_18_R1, "putDouble(java.lang.String,double)")),
    COMPOUND_SET_BOOLEAN(ClassWrapper.NMS_NBTTAGCOMPOUND, new Class[]{String.class, boolean.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "setBoolean"), new Since(ServerVersion.MC1_18_R1, "putBoolean(java.lang.String,boolean)")),
    COMPOUND_SET_UUID(ClassWrapper.NMS_NBTTAGCOMPOUND, new Class[]{String.class, UUID.class}, ServerVersion.MC1_16_R1, new Since(ServerVersion.MC1_16_R1, "a"), new Since(ServerVersion.MC1_18_R1, "putUUID(java.lang.String,java.util.UUID)")),
    COMPOUND_MERGE(ClassWrapper.NMS_NBTTAGCOMPOUND, new Class[]{ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz()}, ServerVersion.MC1_8_R3, new Since(ServerVersion.MC1_8_R3, "a"), new Since(ServerVersion.MC1_18_R1, "put(java.lang.String,net.minecraft.nbt.Tag)")),
    COMPOUND_SET(ClassWrapper.NMS_NBTTAGCOMPOUND, new Class[]{String.class, ClassWrapper.NMS_NBTBASE.getClazz()}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "set"), new Since(ServerVersion.MC1_18_R1, "put(java.lang.String,net.minecraft.nbt.Tag)")),
    COMPOUND_GET(ClassWrapper.NMS_NBTTAGCOMPOUND, new Class[]{String.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "get"), new Since(ServerVersion.MC1_18_R1, "get(java.lang.String)")),
    COMPOUND_GET_LIST(ClassWrapper.NMS_NBTTAGCOMPOUND, new Class[]{String.class, int.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "getList"), new Since(ServerVersion.MC1_18_R1, "getList(java.lang.String,int)")),
    COMPOUND_OWN_TYPE(ClassWrapper.NMS_NBTBASE, new Class[]{}, ServerVersion.MC1_7_R4, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "getTypeId")), // Only needed for 1.7.10 getType

    COMPOUND_GET_FLOAT(ClassWrapper.NMS_NBTTAGCOMPOUND, new Class[]{String.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "getFloat"), new Since(ServerVersion.MC1_18_R1, "getFloat(java.lang.String)")),
    COMPOUND_GET_STRING(ClassWrapper.NMS_NBTTAGCOMPOUND, new Class[]{String.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "getString"), new Since(ServerVersion.MC1_18_R1, "getString(java.lang.String)")),
    COMPOUND_GET_INT(ClassWrapper.NMS_NBTTAGCOMPOUND, new Class[]{String.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "getInt"), new Since(ServerVersion.MC1_18_R1, "getInt(java.lang.String)")),
    COMPOUND_GET_BYTEARRAY(ClassWrapper.NMS_NBTTAGCOMPOUND, new Class[]{String.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "getByteArray"), new Since(ServerVersion.MC1_18_R1, "getByteArray(java.lang.String)")),
    COMPOUND_GET_INTARRAY(ClassWrapper.NMS_NBTTAGCOMPOUND, new Class[]{String.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "getIntArray"), new Since(ServerVersion.MC1_18_R1, "getIntArray(java.lang.String)")),
    COMPOUND_GET_LONG(ClassWrapper.NMS_NBTTAGCOMPOUND, new Class[]{String.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "getLong"), new Since(ServerVersion.MC1_18_R1, "getLong(java.lang.String)")),
    COMPOUND_GET_SHORT(ClassWrapper.NMS_NBTTAGCOMPOUND, new Class[]{String.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "getShort"), new Since(ServerVersion.MC1_18_R1, "getShort(java.lang.String)")),
    COMPOUND_GET_BYTE(ClassWrapper.NMS_NBTTAGCOMPOUND, new Class[]{String.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "getByte"), new Since(ServerVersion.MC1_18_R1, "getByte(java.lang.String)")),
    COMPOUND_GET_DOUBLE(ClassWrapper.NMS_NBTTAGCOMPOUND, new Class[]{String.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "getDouble"), new Since(ServerVersion.MC1_18_R1, "getDouble(java.lang.String)")),
    COMPOUND_GET_BOOLEAN(ClassWrapper.NMS_NBTTAGCOMPOUND, new Class[]{String.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "getBoolean"), new Since(ServerVersion.MC1_18_R1, "getBoolean(java.lang.String)")),
    COMPOUND_GET_UUID(ClassWrapper.NMS_NBTTAGCOMPOUND, new Class[]{String.class}, ServerVersion.MC1_16_R1, new Since(ServerVersion.MC1_16_R1, "a"), new Since(ServerVersion.MC1_18_R1, "getUUID(java.lang.String)")),
    COMPOUND_GET_COMPOUND(ClassWrapper.NMS_NBTTAGCOMPOUND, new Class[]{String.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "getCompound"), new Since(ServerVersion.MC1_18_R1, "getCompound(java.lang.String)")),

    NMSITEM_GETTAG(ClassWrapper.NMS_ITEMSTACK, new Class[] {}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "getTag"), new Since(ServerVersion.MC1_18_R1, "getTag()")),
    NMSITEM_SAVE(ClassWrapper.NMS_ITEMSTACK, new Class[] {ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz()}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "save"), new Since(ServerVersion.MC1_18_R1, "save(net.minecraft.nbt.CompoundTag)")),
    NMSITEM_CREATESTACK(ClassWrapper.NMS_ITEMSTACK, new Class[] {ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz()}, ServerVersion.MC1_7_R4, ServerVersion.MC1_10_R1, new Since(ServerVersion.MC1_7_R4, "createStack")),

    COMPOUND_REMOVE_KEY(ClassWrapper.NMS_NBTTAGCOMPOUND, new Class[]{String.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "remove"), new Since(ServerVersion.MC1_18_R1, "remove(java.lang.String)")),
    COMPOUND_HAS_KEY(ClassWrapper.NMS_NBTTAGCOMPOUND, new Class[]{String.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "hasKey"), new Since(ServerVersion.MC1_18_R1, "contains(java.lang.String)")),
    COMPOUND_GET_TYPE(ClassWrapper.NMS_NBTTAGCOMPOUND, new Class[]{String.class}, ServerVersion.MC1_8_R3, new Since(ServerVersion.MC1_8_R3, "b"), new Since(ServerVersion.MC1_9_R1, "d"), new Since(ServerVersion.MC1_15_R1, "e"), new Since(ServerVersion.MC1_16_R1, "d"), new Since(ServerVersion.MC1_18_R1, "getTagType(java.lang.String)")),
    COMPOUND_GET_KEYS(ClassWrapper.NMS_NBTTAGCOMPOUND, new Class[]{}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "c"), new Since(ServerVersion.MC1_13_R1, "getKeys"), new Since(ServerVersion.MC1_18_R1, "getAllKeys()")),

    LISTCOMPOUND_GET_KEYS(ClassWrapper.NMS_NBTTAGCOMPOUND, new Class[]{}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "c"), new Since(ServerVersion.MC1_13_R1, "getKeys"), new Since(ServerVersion.MC1_18_R1, "getAllKeys()")), // FIXME ?!?
    LIST_REMOVE_KEY(ClassWrapper.NMS_NBTTAGLIST, new Class[]{int.class}, ServerVersion.MC1_8_R3, new Since(ServerVersion.MC1_8_R3, "a"), new Since(ServerVersion.MC1_9_R1, "remove"), new Since(ServerVersion.MC1_18_R1, "remove(int)")),
    LIST_SIZE(ClassWrapper.NMS_NBTTAGLIST, new Class[]{}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "size"), new Since(ServerVersion.MC1_18_R1, "size()")),
    LIST_SET(ClassWrapper.NMS_NBTTAGLIST, new Class[]{int.class, ClassWrapper.NMS_NBTBASE.getClazz()}, ServerVersion.MC1_8_R3, new Since(ServerVersion.MC1_8_R3, "a"), new Since(ServerVersion.MC1_13_R1, "set"), new Since(ServerVersion.MC1_18_R1, "setTag(int,net.minecraft.nbt.Tag)")),
    LEGACY_LIST_ADD(ClassWrapper.NMS_NBTTAGLIST, new Class[]{ClassWrapper.NMS_NBTBASE.getClazz()}, ServerVersion.MC1_7_R4, ServerVersion.MC1_13_R2, new Since(ServerVersion.MC1_7_R4, "add")),
    LIST_ADD(ClassWrapper.NMS_NBTTAGLIST, new Class[]{int.class, ClassWrapper.NMS_NBTBASE.getClazz()}, ServerVersion.MC1_14_R1, new Since(ServerVersion.MC1_14_R1, "add"), new Since(ServerVersion.MC1_18_R1, "addTag(int,net.minecraft.nbt.Tag)")),
    LIST_GET_STRING(ClassWrapper.NMS_NBTTAGLIST, new Class[]{int.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "getString"), new Since(ServerVersion.MC1_18_R1, "getString(int)")),
    LIST_GET_COMPOUND(ClassWrapper.NMS_NBTTAGLIST, new Class[]{int.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "get"), new Since(ServerVersion.MC1_18_R1, "getCompound(int)")),
    LIST_GET(ClassWrapper.NMS_NBTTAGLIST, new Class[]{int.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "get"), new Since(ServerVersion.MC1_8_R3, "g"), new Since(ServerVersion.MC1_9_R1, "h"), new Since(ServerVersion.MC1_12_R1, "i"), new Since(ServerVersion.MC1_13_R1, "get"), new Since(ServerVersion.MC1_18_R1, "get(int)")),

    ITEMSTACK_SET_TAG(ClassWrapper.NMS_ITEMSTACK, new Class[]{ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz()}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "setTag"), new Since(ServerVersion.MC1_18_R1, "setTag(net.minecraft.nbt.CompoundTag)")),
    ITEMSTACK_NMSCOPY(ClassWrapper.CRAFT_ITEMSTACK, new Class[]{ItemStack.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "asNMSCopy")),
    ITEMSTACK_BUKKITMIRROR(ClassWrapper.CRAFT_ITEMSTACK, new Class[]{ClassWrapper.NMS_ITEMSTACK.getClazz()}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "asCraftMirror")),

    CRAFT_WORLD_GET_HANDLE(ClassWrapper.CRAFT_WORLD, new Class[]{}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "getHandle")),
    NMS_WORLD_GET_TILEENTITY(ClassWrapper.NMS_WORLDSERVER, new Class[]{ClassWrapper.NMS_BLOCKPOSITION.getClazz()}, ServerVersion.MC1_8_R3, new Since(ServerVersion.MC1_8_R3, "getTileEntity"), new Since(ServerVersion.MC1_18_R1, "getBlockEntity(net.minecraft.core.BlockPos)")),
    NMS_WORLD_SET_TILEENTITY(ClassWrapper.NMS_WORLDSERVER, new Class[]{ClassWrapper.NMS_BLOCKPOSITION.getClazz(), ClassWrapper.NMS_TILEENTITY.getClazz()}, ServerVersion.MC1_8_R3, ServerVersion.MC1_16_R3, new Since(ServerVersion.MC1_8_R3, "setTileEntity")),
    NMS_WORLD_REMOVE_TILEENTITY(ClassWrapper.NMS_WORLDSERVER, new Class[]{ClassWrapper.NMS_BLOCKPOSITION.getClazz()}, ServerVersion.MC1_8_R3, ServerVersion.MC1_17_R1, new Since(ServerVersion.MC1_8_R3, "t"), new Since(ServerVersion.MC1_9_R1, "s"), new Since(ServerVersion.MC1_13_R1, "n"),  new Since(ServerVersion.MC1_14_R1, "removeTileEntity")),

    NMS_WORLD_GET_TILEENTITY_1_7_10(ClassWrapper.NMS_WORLDSERVER, new Class[]{int.class, int.class, int.class}, ServerVersion.MC1_7_R4, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "getTileEntity")),

    TILEENTITY_LOAD_LEGACY191(ClassWrapper.NMS_TILEENTITY, new Class[]{ClassWrapper.NMS_MINECRAFTSERVER.getClazz(), ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz()}, ServerVersion.MC1_9_R1, ServerVersion.MC1_9_R1, new Since(ServerVersion.MC1_9_R1, "a")), //FIXME: No Spigot mapping!
    TILEENTITY_LOAD_LEGACY183(ClassWrapper.NMS_TILEENTITY, new Class[]{ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz()}, ServerVersion.MC1_8_R3, ServerVersion.MC1_9_R2, new Since(ServerVersion.MC1_8_R3, "c"), new Since(ServerVersion.MC1_9_R1, "a"), new Since(ServerVersion.MC1_9_R2, "c")), //FIXME: No Spigot mapping!
    TILEENTITY_LOAD_LEGACY1121(ClassWrapper.NMS_TILEENTITY, new Class[]{ClassWrapper.NMS_WORLD.getClazz(), ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz()}, ServerVersion.MC1_10_R1, ServerVersion.MC1_12_R1, new Since(ServerVersion.MC1_10_R1, "a"), new Since(ServerVersion.MC1_12_R1, "create")),
    TILEENTITY_LOAD_LEGACY1151(ClassWrapper.NMS_TILEENTITY, new Class[]{ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz()}, ServerVersion.MC1_13_R1, ServerVersion.MC1_15_R1, new Since(ServerVersion.MC1_12_R1, "create")),
    TILEENTITY_LOAD(ClassWrapper.NMS_TILEENTITY, new Class[]{ClassWrapper.NMS_IBLOCKDATA.getClazz(), ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz()}, ServerVersion.MC1_16_R1, ServerVersion.MC1_16_R3, new Since(ServerVersion.MC1_16_R1, "create")),

    TILEENTITY_GET_NBT(ClassWrapper.NMS_TILEENTITY, new Class[]{ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz()}, ServerVersion.MC1_7_R4, ServerVersion.MC1_17_R1, new Since(ServerVersion.MC1_7_R4, "b"), new Since(ServerVersion.MC1_9_R1, "save")),
    TILEENTITY_GET_NBT_1181(ClassWrapper.NMS_TILEENTITY, new Class[]{}, ServerVersion.MC1_18_R1, new Since(ServerVersion.MC1_18_R1, "saveWithId()")),
    TILEENTITY_SET_NBT_LEGACY1151(ClassWrapper.NMS_TILEENTITY, new Class[]{ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz()}, ServerVersion.MC1_7_R4, ServerVersion.MC1_15_R1, new Since(ServerVersion.MC1_7_R4, "a"), new Since(ServerVersion.MC1_12_R1, "load")),
    TILEENTITY_SET_NBT_LEGACY1161(ClassWrapper.NMS_TILEENTITY, new Class[]{ClassWrapper.NMS_IBLOCKDATA.getClazz(), ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz()}, ServerVersion.MC1_16_R1, ServerVersion.MC1_16_R3, new Since(ServerVersion.MC1_16_R1, "load")),
    TILEENTITY_SET_NBT(ClassWrapper.NMS_TILEENTITY, new Class[]{ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz()}, ServerVersion.MC1_17_R1, new Since(ServerVersion.MC1_16_R1, "load"), new Since(ServerVersion.MC1_18_R1, "load(net.minecraft.nbt.CompoundTag)")),
    TILEENTITY_GET_BLOCKDATA(ClassWrapper.NMS_TILEENTITY, new Class[]{}, ServerVersion.MC1_16_R1, new Since(ServerVersion.MC1_16_R1, "getBlock"), new Since(ServerVersion.MC1_18_R1, "getBlockState()")),

    CRAFT_ENTITY_GET_HANDLE(ClassWrapper.CRAFT_ENTITY, new Class[]{}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "getHandle")),
    NMS_ENTITY_SET_NBT(ClassWrapper.NMS_ENTITY, new Class[]{ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz()}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "f"), new Since(ServerVersion.MC1_16_R1, "load"), new Since(ServerVersion.MC1_18_R1, "load(net.minecraft.nbt.CompoundTag)")),
    NMS_ENTITY_GET_NBT(ClassWrapper.NMS_ENTITY, new Class[]{ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz()}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "e"), new Since(ServerVersion.MC1_12_R1, "save"), new Since(ServerVersion.MC1_18_R1, "saveWithoutId(net.minecraft.nbt.CompoundTag)")),
    NMS_ENTITY_GETSAVEID(ClassWrapper.NMS_ENTITY, new Class[]{}, ServerVersion.MC1_14_R1,new Since(ServerVersion.MC1_14_R1, "getSaveID"), new Since(ServerVersion.MC1_18_R1, "getEncodeId()")),

    NBTFILE_READ(ClassWrapper.NMS_NBTCOMPRESSEDSTREAMTOOLS, new Class[]{InputStream.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "a"), new Since(ServerVersion.MC1_18_R1, "readCompressed(java.io.InputStream)")),
    NBTFILE_WRITE(ClassWrapper.NMS_NBTCOMPRESSEDSTREAMTOOLS, new Class[]{ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), OutputStream.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "a"), new Since(ServerVersion.MC1_18_R1, "writeCompressed(net.minecraft.nbt.CompoundTag,java.io.OutputStream)")),

    PARSE_NBT(ClassWrapper.NMS_MOJANGSONPARSER, new Class[]{String.class}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "parse"), new Since(ServerVersion.MC1_18_R1, "parseTag(java.lang.String)")),
    REGISTRY_KEYSET (ClassWrapper.NMS_REGISTRYSIMPLE, new Class[]{}, ServerVersion.MC1_11_R1, ServerVersion.MC1_13_R1, new Since(ServerVersion.MC1_11_R1, "keySet")),
    REGISTRY_GET (ClassWrapper.NMS_REGISTRYSIMPLE, new Class[]{Object.class}, ServerVersion.MC1_11_R1, ServerVersion.MC1_13_R1, new Since(ServerVersion.MC1_11_R1, "get")),
    REGISTRY_SET (ClassWrapper.NMS_REGISTRYSIMPLE, new Class[]{Object.class, Object.class}, ServerVersion.MC1_11_R1, ServerVersion.MC1_13_R1, new Since(ServerVersion.MC1_11_R1, "a")), //FIXME: No Spigot mapping!
    REGISTRY_GET_INVERSE (ClassWrapper.NMS_REGISTRYMATERIALS, new Class[]{Object.class}, ServerVersion.MC1_11_R1, ServerVersion.MC1_13_R1, new Since(ServerVersion.MC1_11_R1, "b")), //FIXME: No Spigot mapping!
    REGISTRYMATERIALS_KEYSET (ClassWrapper.NMS_REGISTRYMATERIALS, new Class[]{}, ServerVersion.MC1_13_R1, ServerVersion.MC1_17_R1, new Since(ServerVersion.MC1_13_R1, "keySet")),
    REGISTRYMATERIALS_GET (ClassWrapper.NMS_REGISTRYMATERIALS, new Class[]{ClassWrapper.NMS_MINECRAFTKEY.getClazz()}, ServerVersion.MC1_13_R1, ServerVersion.MC1_17_R1,  new Since(ServerVersion.MC1_13_R1, "get")),
    REGISTRYMATERIALS_GETKEY (ClassWrapper.NMS_REGISTRYMATERIALS, new Class[]{Object.class}, ServerVersion.MC1_13_R2, ServerVersion.MC1_17_R1, new Since(ServerVersion.MC1_13_R2, "getKey")),

    GAMEPROFILE_DESERIALIZE (ClassWrapper.NMS_GAMEPROFILESERIALIZER, new Class[]{ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz()}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "deserialize"), new Since(ServerVersion.MC1_18_R1, "readGameProfile(net.minecraft.nbt.CompoundTag)")),
    GAMEPROFILE_SERIALIZE (ClassWrapper.NMS_GAMEPROFILESERIALIZER, new Class[]{ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), ClassWrapper.GAMEPROFILE.getClazz()}, ServerVersion.MC1_8_R3, new Since(ServerVersion.MC1_8_R3, "serialize"), new Since(ServerVersion.MC1_18_R1, "writeGameProfile(net.minecraft.nbt.CompoundTag,com.mojang.authlib.GameProfile)")),

    CRAFT_PERSISTENT_DATA_CONTAINER_TO_TAG (ClassWrapper.CRAFT_PERSISTENTDATACONTAINER, new Class[]{}, ServerVersion.MC1_14_R1, new Since(ServerVersion.MC1_14_R1, "toTagCompound")),
    CRAFT_PERSISTENT_DATA_CONTAINER_GET_MAP (ClassWrapper.CRAFT_PERSISTENTDATACONTAINER, new Class[]{}, ServerVersion.MC1_14_R1, new Since(ServerVersion.MC1_14_R1, "getRaw")),
    CRAFT_PERSISTENT_DATA_CONTAINER_PUT_ALL (ClassWrapper.CRAFT_PERSISTENTDATACONTAINER, new Class[]{ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz()}, ServerVersion.MC1_14_R1, new Since(ServerVersion.MC1_14_R1, "putAll")),
    // Block
    CRAFT_MagicNumbers_getBlock(ClassWrapper.CRAFT_MagicNumbers.getClazz(), new Class[]{ Material.class }, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "getBlock")),
    // NMS_World_getTileEntity(ClassWrapper.NMS_World.getClazz(), new Class[]{ ClassWrapper.NMS_BlockPosition.getClazz() }, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "getTileEntity")),
    NMS_Block_getBlockData(ClassWrapper.NMS_Block.getClazz(), new Class[]{}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_13_R1, "getBlockData"),
            new Since(ServerVersion.MC1_18_R1, "n")), // TODO: remove if fixed in new 1.18

    // Item
    CRAFT_MagicNumbers_getItem(ClassWrapper.CRAFT_MagicNumbers.getClazz(), new Class[]{ Material.class }, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "getItem")),
    CRAFT_ItemStack_asNMSCopy(ClassWrapper.CRAFT_ItemStack.getClazz(), new Class[]{ ItemStack.class }, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "asNMSCopy")),

    NMS_ItemStack_canDestroySpecialBlock(ClassWrapper.NMS_ItemStack.getClazz(), new SinceArgs[]{ new SinceArgs(ServerVersion.MC1_7_R4, new Class[]{ ClassWrapper.NMS_Block.getClazz() }),
            new SinceArgs(ServerVersion.MC1_9_R1, new Class[]{ ClassWrapper.NMS_IBlockData.getClazz() }) }, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "b"),
            new Since(ServerVersion.MC1_15_R1, "canDestroySpecialBlock"),
            new Since(ServerVersion.MC1_18_R1, "b")), // TODO: remove if fixed in new 1.18),

    // Entities
    CRAFT_Entity_getHandle(ClassWrapper.CRAFT_Entity.getClazz(), new Class[]{}, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "getHandle")),
    NMS_Entity_damageEntity(ClassWrapper.NMS_Entity.getClazz(), new Class[]{ ClassWrapper.NMS_DamageSource.getClazz(), float.class }, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "damageEntity"),
            new Since(ServerVersion.MC1_18_R1, "a")),// TODO: remove if fixed in new 1.18),
    NMS_EntityPlayer_attack(ClassWrapper.NMS_EntityPlayer.getClazz(), new Class[]{ ClassWrapper.NMS_Entity.getClazz() }, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "attack"),
            new Since(ServerVersion.MC1_18_R1, "d")),// TODO: remove if fixed in new 1.18),

    // DamageSource
    NMS_DamageSource_explosion(ClassWrapper.NMS_DamageSource.getClazz(), new Class[]{ ClassWrapper.NMS_Explosion.getClazz() }, ServerVersion.MC1_7_R4, new Since(ServerVersion.MC1_7_R4, "explosion"),
            new Since(ServerVersion.MC1_18_R1, "a")),// TODO: remove if fixed in new 1.18)
    ;

    private ServerVersion removedAfter;
    private Since targetVersion;
    private Method method;
    private boolean loaded = false;
    private boolean compatible = false;
    private String methodName = null;
    private ClassWrapper parentClassWrapper;

    ReflectionMethod(Class<?> targetClass, SinceArgs[] args, ServerVersion addedSince, ServerVersion removedAfter, Since... methodNames) {
        this.removedAfter = removedAfter;
        ServerVersion server = ServerVersion.getCurrentVersion();
        if (server.compareTo(addedSince) < 0 || (this.removedAfter != null && server.getVersionId() > this.removedAfter.getVersionId()))
            return;
        compatible = true;
        Since target = methodNames[0];
        for (Since s : methodNames) {
            if (s.version.getVersionId() > server.getVersionId()) continue;
            if (s.version.getVersionId() < target.version.getVersionId()) continue;
            target = s;
        }
        targetVersion = target;
        SinceArgs targetArgs = args[0];
        for (SinceArgs s : args) {
            if (s.version.getVersionId() > server.getVersionId()) continue;
            if (s.version.getVersionId() < targetArgs.version.getVersionId()) continue;
            targetArgs = s;
        }
        try {
            method = targetClass.getMethod(targetVersion.name, targetArgs.args);
            method.setAccessible(true);
            loaded = true;
        } catch (NullPointerException | NoSuchMethodException | SecurityException ex) {
            ex.printStackTrace();
        }
    }

    ReflectionMethod(Class<?> targetClass, Class<?>[] args, ServerVersion addedSince, ServerVersion removedAfter, Since... methodNames) {
        this(targetClass, new SinceArgs[]{ new SinceArgs(addedSince, args) }, addedSince, removedAfter, methodNames);
    }

    ReflectionMethod(Class<?> targetClass, SinceArgs[] args, ServerVersion addedSince, Since... methodNames) {
        this(targetClass, args, addedSince, null, methodNames);
    }

    ReflectionMethod(Class<?> targetClass, Class<?>[] args, ServerVersion addedSince, Since... methodNames) {
        this(targetClass, new SinceArgs[]{ new SinceArgs(addedSince, args) }, addedSince, methodNames);
    }
    ReflectionMethod(ClassWrapper targetClass, Class<?>[] args, ServerVersion addedSince, ServerVersion removedAfter, Since... methodnames){
        this.removedAfter = removedAfter;
        this.parentClassWrapper = targetClass;
        if(!ServerVersion.isAtLeastVersion(addedSince) || (this.removedAfter != null && ServerVersion.isNewerThan(removedAfter)))return;
        compatible = true;
        ServerVersion server = ServerVersion.getVersion();
        Since target = methodnames[0];
        for(Since s : methodnames){
            if(s.version.getVersionId() <= server.getVersionId() && target.version.getVersionId() < s.version.getVersionId())
                target = s;
        }
        targetVersion = target;
        String targetMethodName = targetVersion.name;
        try{
            if(targetVersion.version.isMojangMapping())
                targetMethodName = MojangToMapping.getMapping().getOrDefault(targetClass.getMojangName() + "#" + targetVersion.name, "Unmapped" + targetVersion.name);
            method = targetClass.getClazz().getDeclaredMethod(targetMethodName, args);
            method.setAccessible(true);
            loaded = true;
            methodName = targetVersion.name;
        }catch(NullPointerException | NoSuchMethodException | SecurityException ex){
            try{
                if(targetVersion.version.isMojangMapping())
                    targetMethodName = MojangToMapping.getMapping().getOrDefault(targetClass.getMojangName() + "#" + targetVersion.name, "Unmapped" + targetVersion.name);
                method = targetClass.getClazz().getMethod(targetMethodName, args);
                method.setAccessible(true);
                loaded = true;
                methodName = targetVersion.name;
            }catch(NullPointerException | NoSuchMethodException | SecurityException ex2){
            }
        }
    }

    ReflectionMethod(ClassWrapper targetClass, Class<?>[] args, ServerVersion addedSince, Since... methodnames){
        this(targetClass, args, addedSince, null, methodnames);
    }

    /**
     * Runs the method on a given target object using the given args.
     *
     * @param target
     * @param args
     * @return Value returned by the method
     */
    public Object run(Object target, Object... args){
        if(method == null)
            throw new NullPointerException("Method not loaded! '" + this + "'");
        try{
            return method.invoke(target, args);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * @return The MethodName, used in this Minecraft Version
     */
    public String getMethodName() {
        return methodName;
    }

    /**
     * @return Has this method been linked
     */
    public boolean isLoaded() {
        return loaded;
    }

    /**
     * @return Is this method available in this Minecraft Version
     */
    public boolean isCompatible() {
        return compatible;
    }

    public Since getSelectedVersionInfo() {
        return targetVersion;
    }

    /**
     * @return Get Wrapper of the parent class
     */
    public ClassWrapper getParentClassWrapper() {
        return parentClassWrapper;
    }

    public static class Since{
        public final ServerVersion version;
        public final String name;
        public Since(ServerVersion version, String name) {
            this.version = version;
            this.name = name;
        }
    }

    private static class SinceArgs {
        public final ServerVersion version;
        public final Class<?>[] args;

        public SinceArgs(ServerVersion version, Class<?>[] args) {
            this.version = version;
            this.args = args;
        }
    }

}