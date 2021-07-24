package me.hyfe.simplespigot.nbt.enums;

import me.hyfe.simplespigot.version.ServerVersion;
import org.bukkit.Bukkit;

public enum ClassWrapper {
    CRAFT_ITEMSTACK(PackageWrapper.CRAFTBUKKIT, "", "inventory.CraftItemStack"),
    CRAFT_ENTITY(PackageWrapper.CRAFTBUKKIT, "", "entity.CraftEntity"),
    CRAFT_WORLD(PackageWrapper.CRAFTBUKKIT, "", "CraftWorld"),
    NMS_NBTBASE(PackageWrapper.NMS, "nbt", "NBTBase"),
    NMS_NBTTAGSTRING(PackageWrapper.NMS, "nbt", "NBTTagString"),
    NMS_NBTTAGINT(PackageWrapper.NMS, "nbt", "NBTTagInt"),
    NMS_ITEMSTACK(PackageWrapper.NMS, "world.item", "ItemStack"),
    NMS_NBTTAGCOMPOUND(PackageWrapper.NMS, "nbt", "NBTTagCompound"),
    NMS_NBTTAGLIST(PackageWrapper.NMS, "nbt", "NBTTagList"),
    NMS_NBTCOMPRESSEDSTREAMTOOLS(PackageWrapper.NMS, "nbt", "NBTCompressedStreamTools"),
    NMS_MOJANGSONPARSER(PackageWrapper.NMS, "nbt", "MojangsonParser"),
    NMS_TILEENTITY(PackageWrapper.NMS, "world.level.block.entity", "TileEntity"),
    NMS_BLOCKPOSITION(PackageWrapper.NMS, "core", "BlockPosition"),
    NMS_IBLOCKDATA(PackageWrapper.NMS, "world.level.block.state", "IBlockData"),
    NMS_WORLDSERVER(PackageWrapper.NMS, "server.level", "WorldServer"),
    NMS_MINECRAFTSERVER(PackageWrapper.NMS, "server", "MinecraftServer"),
    NMS_WORLD(PackageWrapper.NMS, "world.level", "World"),
    NMS_ENTITY(PackageWrapper.NMS, "world.entity", "Entity"),
    NMS_ENTITYTYPES(PackageWrapper.NMS, "world.entity", "EntityTypes"),
    NMS_REGISTRYSIMPLE(PackageWrapper.NMS, "", "RegistrySimple", ServerVersion.MC1_11_R1, ServerVersion.MC1_12_R1),
    NMS_REGISTRYMATERIALS(PackageWrapper.NMS, "core", "RegistryMaterials"),
    NMS_IREGISTRY(PackageWrapper.NMS, "core", "IRegistry"),
    NMS_MINECRAFTKEY(PackageWrapper.NMS, "resources", "MinecraftKey"),
    NMS_GAMEPROFILESERIALIZER(PackageWrapper.NMS, "nbt", "GameProfileSerializer");

    private Class<?> clazz;
    private boolean enabled = false;

    ClassWrapper(PackageWrapper packageId, String mid, String suffix) {
        this(packageId, mid, suffix, null, null);
    }

    ClassWrapper(PackageWrapper packageId, String mid, String suffix, ServerVersion from, ServerVersion to) {
        if ((from != null && ServerVersion.getVersion().getVersionId() < from.getVersionId()) || to != null && ServerVersion.getVersion().getVersionId() > to.getVersionId()) {
            return;
        }
        try {
            if (packageId == PackageWrapper.NMS && ServerVersion.getVersion().getVersionId() >= ServerVersion.MC1_17_R1.getVersionId()) {
                this.clazz = Class.forName(packageId.getUri().replace(".server", "") + "." + ((!mid.isEmpty()) ? mid + "." : "") + suffix);
            } else {
                this.clazz = Class.forName(packageId.getUri().concat(".").concat(Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3]).concat(".").concat(suffix));
            }
            this.enabled = true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public boolean isEnabled() {
        return enabled;
    }

}
