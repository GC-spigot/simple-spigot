package me.hyfe.simplespigot.nbt.enums;

import lombok.SneakyThrows;
import me.hyfe.simplespigot.version.ServerVersion;
import org.bukkit.Bukkit;

public enum ClassWrapper {
    CRAFT_ITEMSTACK(PackageWrapper.CRAFTBUKKIT, "inventory.CraftItemStack"),
    CRAFT_ENTITY(PackageWrapper.CRAFTBUKKIT, "entity.CraftEntity"),
    CRAFT_WORLD(PackageWrapper.CRAFTBUKKIT, "CraftWorld"),
    NMS_NBTBASE(PackageWrapper.NMS, "NBTBase"),
    NMS_NBTTAGSTRING(PackageWrapper.NMS, "NBTTagString"),
    NMS_NBTTAGINT(PackageWrapper.NMS, "NBTTagInt"),
    NMS_ITEMSTACK(PackageWrapper.NMS, "ItemStack"),
    NMS_NBTTAGCOMPOUND(PackageWrapper.NMS, "NBTTagCompound"),
    NMS_NBTTAGLIST(PackageWrapper.NMS, "NBTTagList"),
    NMS_NBTCOMPRESSEDSTREAMTOOLS(PackageWrapper.NMS, "NBTCompressedStreamTools"),
    NMS_MOJANGSONPARSER(PackageWrapper.NMS, "MojangsonParser"),
    NMS_TILEENTITY(PackageWrapper.NMS, "TileEntity"),
    NMS_BLOCKPOSITION(PackageWrapper.NMS, "BlockPosition"),
    NMS_WORLDSERVER(PackageWrapper.NMS, "WorldServer"),
    NMS_MINECRAFTSERVER(PackageWrapper.NMS, "MinecraftServer"),
    NMS_WORLD(PackageWrapper.NMS, "World"),
    NMS_ENTITY(PackageWrapper.NMS, "Entity"),
    NMS_ENTITYTYPES(PackageWrapper.NMS, "EntityTypes"),
    NMS_REGISTRYSIMPLE(PackageWrapper.NMS, "RegistrySimple", ServerVersion.MC1_11_R1, ServerVersion.MC1_12_R1),
    NMS_REGISTRYMATERIALS(PackageWrapper.NMS, "RegistryMaterials"),
    NMS_IREGISTRY(PackageWrapper.NMS, "IRegistry"),
    NMS_MINECRAFTKEY(PackageWrapper.NMS, "MinecraftKey"),
    NMS_GAMEPROFILESERIALIZER(PackageWrapper.NMS, "GameProfileSerializer");

    private Class<?> clazz;
    private boolean enabled = false;

    ClassWrapper(PackageWrapper packageId, String suffix) {
        this(packageId, suffix, null, null);
    }

    @SneakyThrows
    ClassWrapper(PackageWrapper packageId, String suffix, ServerVersion from, ServerVersion to) {
        if ((from != null && ServerVersion.getVersion().getVersionId() < from.getVersionId()) || to != null && ServerVersion.getVersion().getVersionId() > to.getVersionId()) {
            return;
        }
        this.enabled = true;
        this.clazz = Class.forName(packageId.getUri().concat(".").concat(Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3]).concat(".").concat(suffix));
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public boolean isEnabled() {
        return enabled;
    }

}