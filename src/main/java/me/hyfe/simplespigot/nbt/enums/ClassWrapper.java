package me.hyfe.simplespigot.nbt.enums;

import me.hyfe.simplespigot.version.ServerVersion;
import org.bukkit.Bukkit;

public enum ClassWrapper {
    // Blocks
    CRAFT_BlockData("org.bukkit.craftbukkit", "", "block.data.CraftBlockData", ServerVersion.MC1_13_R1),
    CRAFT_World("org.bukkit.craftbukkit", "", "CraftWorld", ServerVersion.MC1_8_R3),
    // Entities
    CRAFT_Entity("org.bukkit.craftbukkit", "", "entity.CraftEntity", ServerVersion.MC1_8_R3),
    CRAFT_Player("org.bukkit.craftbukkit", "", "entity.CraftPlayer", ServerVersion.MC1_8_R3),
    // Misc
    CRAFT_MagicNumbers("org.bukkit.craftbukkit", "", "util.CraftMagicNumbers", ServerVersion.MC1_8_R3),
    CRAFT_ItemStack("org.bukkit.craftbukkit", "", "inventory.CraftItemStack", ServerVersion.MC1_8_R3),
    CRAFT_MetaBook("org.bukkit.craftbukkit", "", "inventory.CraftMetaBook", ServerVersion.MC1_8_R3),
    CRAFT_Enchantment("org.bukkit.craftbukkit", "", "enchantments.CraftEnchantment", ServerVersion.MC1_8_R3),

    // NBT
    NMS_NBTBase("net.minecraft", "nbt", "NBTBase", ServerVersion.MC1_8_R3),
    NMS_NBTTagString("net.minecraft", "nbt", "NBTTagString", ServerVersion.MC1_8_R3),
    NMS_NBTTagInt("net.minecraft", "nbt", "NBTTagInt", ServerVersion.MC1_8_R3),
    NMS_NBTTagCompound("net.minecraft", "nbt", "NBTTagCompound", ServerVersion.MC1_8_R3),
    NMS_NBTTagList("net.minecraft", "nbt", "NBTTagList", ServerVersion.MC1_8_R3),
    NMS_NBTCompressedStreamTools("net.minecraft", "nbt", "NBTCompressedStreamTools", ServerVersion.MC1_8_R3),
    // Blocks
    NMS_TileEntity("net.minecraft", "world.level.block.entity", "TileEntity", ServerVersion.MC1_8_R3),
    NMS_Block("net.minecraft", "world.level.block", "Block", ServerVersion.MC1_8_R3),
    NMS_IBlockData("net.minecraft", "world.level.block.state", "IBlockData", ServerVersion.MC1_8_R3),
    NMS_BlockPosition("net.minecraft", "core", "BlockPosition", ServerVersion.MC1_8_R3),
    NMS_World("net.minecraft", "server.level", "WorldServer", ServerVersion.MC1_8_R3),
    NMS_Material("net.minecraft", "world.level.material", "Material", ServerVersion.MC1_8_R3),
    // Items
    NMS_ItemStack("net.minecraft", "world.item", "ItemStack", ServerVersion.MC1_8_R3),
    NMS_ItemTool("net.minecraft", "world.item", "ItemTool", ServerVersion.MC1_8_R3),
    // Entities
    NMS_Entity("net.minecraft", "world.entity", "Entity", ServerVersion.MC1_8_R3),
    NMS_EntityPlayer("net.minecraft", "server.level", "EntityPlayer", ServerVersion.MC1_8_R3),
    NMS_EntityTypes("net.minecraft", "world.entity", "EntityTypes", ServerVersion.MC1_8_R3),
    NMS_EntityHuman("net.minecraft", "world.entity.player", "EntityHuman", ServerVersion.MC1_8_R3),
    NMS_DamageSource("net.minecraft", "world.damagesource", "DamageSource", ServerVersion.MC1_8_R3),
    // Misc
    NMS_MojangsonParser("net.minecraft", "nbt", "MojangsonParser", ServerVersion.MC1_8_R3),
    NMS_IChatBaseComponent("net.minecraft", "network.chat", "IChatBaseComponent", ServerVersion.MC1_8_R3),
    NMS_IChatBaseComponent$ChatSerializer("net.minecraft", "network.chat", "IChatBaseComponent$ChatSerializer", ServerVersion.MC1_8_R3),
    NMS_EnumHand("net.minecraft", "world", "EnumHand", ServerVersion.MC1_9_R1),
    NMS_Explosion("net.minecraft", "world.level", "Explosion", ServerVersion.MC1_8_R3),
    CRAFT_ITEMSTACK(PackageWrapper.CRAFTBUKKIT, "inventory.CraftItemStack", null, null),
    CRAFT_METAITEM(PackageWrapper.CRAFTBUKKIT, "inventory.CraftMetaItem", null, null),
    CRAFT_ENTITY(PackageWrapper.CRAFTBUKKIT, "entity.CraftEntity", null, null),
    CRAFT_WORLD(PackageWrapper.CRAFTBUKKIT, "CraftWorld", null, null),
    CRAFT_PERSISTENTDATACONTAINER(PackageWrapper.CRAFTBUKKIT, "persistence.CraftPersistentDataContainer",
            ServerVersion.MC1_14_R1, null),
    NMS_NBTBASE(PackageWrapper.NMS, "NBTBase", null, null, "net.minecraft.nbt", "net.minecraft.nbt.Tag"),
    NMS_NBTTAGSTRING(PackageWrapper.NMS, "NBTTagString", null, null, "net.minecraft.nbt", "net.minecraft.nbt.StringTag"),
    NMS_NBTTAGINT(PackageWrapper.NMS, "NBTTagInt", null, null, "net.minecraft.nbt", "net.minecraft.nbt.IntTag"),
    NMS_NBTTAGFLOAT(PackageWrapper.NMS, "NBTTagFloat", null, null, "net.minecraft.nbt", "net.minecraft.nbt.FloatTag"),
    NMS_NBTTAGDOUBLE(PackageWrapper.NMS, "NBTTagDouble", null, null, "net.minecraft.nbt", "net.minecraft.nbt.DoubleTag"),
    NMS_NBTTAGLONG(PackageWrapper.NMS, "NBTTagLong", null, null, "net.minecraft.nbt", "net.minecraft.nbt.LongTag"),
    NMS_ITEMSTACK(PackageWrapper.NMS, "ItemStack", null, null, "net.minecraft.world.item", "net.minecraft.world.item.ItemStack"),
    NMS_NBTTAGCOMPOUND(PackageWrapper.NMS, "NBTTagCompound", null, null, "net.minecraft.nbt", "net.minecraft.nbt.CompoundTag"),
    NMS_NBTTAGLIST(PackageWrapper.NMS, "NBTTagList", null, null, "net.minecraft.nbt", "net.minecraft.nbt.ListTag"),
    NMS_NBTCOMPRESSEDSTREAMTOOLS(PackageWrapper.NMS, "NBTCompressedStreamTools", null, null, "net.minecraft.nbt", "net.minecraft.nbt.NbtIo"),
    NMS_MOJANGSONPARSER(PackageWrapper.NMS, "MojangsonParser", null, null, "net.minecraft.nbt", "net.minecraft.nbt.TagParser"),
    NMS_TILEENTITY(PackageWrapper.NMS, "TileEntity", null, null, "net.minecraft.world.level.block.entity", "net.minecraft.world.level.block.entity.BlockEntity"),
    NMS_BLOCKPOSITION(PackageWrapper.NMS, "BlockPosition", ServerVersion.MC1_8_R3, null, "net.minecraft.core", "net.minecraft.core.BlockPos"),
    NMS_WORLDSERVER(PackageWrapper.NMS, "WorldServer", null, null, "net.minecraft.server.level", "net.minecraft.server.level.ServerLevel"),
    NMS_MINECRAFTSERVER(PackageWrapper.NMS, "MinecraftServer", null, null, "net.minecraft.server", "net.minecraft.server.MinecraftServer"),
    NMS_WORLD(PackageWrapper.NMS, "World", null, null, "net.minecraft.world.level", "net.minecraft.world.level.Level"),
    NMS_ENTITY(PackageWrapper.NMS, "Entity", null, null, "net.minecraft.world.entity", "net.minecraft.world.entity.Entity"),
    NMS_ENTITYTYPES(PackageWrapper.NMS, "EntityTypes", null, null, "net.minecraft.world.entity", "net.minecraft.world.entity.EntityType"),
    NMS_REGISTRYSIMPLE(PackageWrapper.NMS, "RegistrySimple", ServerVersion.MC1_11_R1, ServerVersion.MC1_12_R1),
    NMS_REGISTRYMATERIALS(PackageWrapper.NMS, "RegistryMaterials", null, null, "net.minecraft.core", "net.minecraft.core.MappedRegistry"),
    NMS_IREGISTRY(PackageWrapper.NMS, "IRegistry", null, null, "net.minecraft.core", "net.minecraft.core.Registry"),
    NMS_MINECRAFTKEY(PackageWrapper.NMS, "MinecraftKey", ServerVersion.MC1_8_R3, null, "net.minecraft.resources", "net.minecraft.resources.ResourceKey"),
    NMS_GAMEPROFILESERIALIZER(PackageWrapper.NMS, "GameProfileSerializer", null, null, "net.minecraft.nbt", "net.minecraft.nbt.NbtUtils"),
    NMS_IBLOCKDATA(PackageWrapper.NMS, "IBlockData", ServerVersion.MC1_8_R3, null,
            "net.minecraft.world.level.block.state", "net.minecraft.world.level.block.state.BlockState"),
    GAMEPROFILE(PackageWrapper.NONE, "com.mojang.authlib.GameProfile", ServerVersion.MC1_8_R3, null)
    ;

    private Class<?> clazz;
    private String mojangName = "";

    ClassWrapper(PackageWrapper packageId, String clazzName, ServerVersion from, ServerVersion to) {
        this(packageId, clazzName, from, to, null, null);
    }

    ClassWrapper(PackageWrapper packageId, String clazzName, ServerVersion from, ServerVersion to,
                 String mojangMap, String mojangName) {
        this.mojangName = mojangName;
        if (from != null && ServerVersion.getVersion().getVersionId() < from.getVersionId()) {
            return;
        }
        if (to != null && ServerVersion.getVersion().getVersionId() > to.getVersionId()) {
            return;
        }
        try {
            if (ServerVersion.isAtLeastVersion(ServerVersion.MC1_8_R3) && mojangMap != null) {
                clazz = Class.forName(mojangMap + "." + clazzName);
            } else if (packageId == PackageWrapper.NONE) {
                clazz = Class.forName(clazzName);
            } else {
                String version = ServerVersion.getVersion().getPackageName();
                clazz = Class.forName(packageId.getUri() + "." + version + "." + clazzName);
            }
        } catch (Throwable ex) {
        }
    }

    /**
     * @param pre         First part of the package.
     * @param mid The rest of the package path after "net.minecraft" for 1.17+.
     * @param suffix      Rest of the package + class name.
     * @param subClass    Whether the class requested is a sub-class or not.
     */
    ClassWrapper(String pre, String mid, String suffix, ServerVersion since, boolean subClass) {
        if (ServerVersion.getVersion().getVersionId() < since.getVersionId())
            return;
        try {
            String version = Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];
            if (ServerVersion.getVersion().getVersionId() < 1_17_0) {
                clazz = Class.forName(pre + (pre.equals("net.minecraft") ? ".server." : ".") + version + ((subClass) ? "$" : ".") + suffix);
            } else {
                String middle = (pre.equals("org.bukkit.craftbukkit")) ? version : mid;
                clazz = Class.forName(pre + "." + middle + ((subClass) ? "$" : ".") + suffix);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @param pre         First part of the package.
     * @param mid The rest of the package path after "net.minecraft" for 1.17+.
     * @param suffix      Rest of the package + class name.
     */
    ClassWrapper(String pre, String mid, String suffix, ServerVersion since) {
        this(pre, mid, suffix, since, false);
    }

    public Class<?> getClazz() {
        return clazz;
    }


    public String getMojangName() {
        return mojangName;
    }

}
