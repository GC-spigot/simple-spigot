package me.hyfe.simplespigot.item;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import me.hyfe.simplespigot.annotations.Nullable;
import me.hyfe.simplespigot.config.Config;
import me.hyfe.simplespigot.nbt.type.NbtItem;
import me.hyfe.simplespigot.text.Text;
import me.hyfe.simplespigot.text.replacer.Replace;
import me.hyfe.simplespigot.version.MultiMaterial;
import me.hyfe.simplespigot.version.ServerVersion;
import net.advancedplugins.heads.api.AdvancedHeadsAPI;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class SpigotItem {

    /**
     * Gets a item builder.
     *
     * @return A Builder.
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Converts a section from a config into an ItemStack (must use specific format).
     *
     * @param config      The config to get the item from.
     * @param path        The path inside the config to get the item from (e.g 1.item)
     * @param replace     A replacer to replace certain parts of the configurable options necessary (name, lore).
     * @param defaultItem If the section is not present, this is the default item.
     * @return The ItemStack built from the config path.
     */
    @Nullable
    public static ItemStack toItemOrDefault(Config config, String path, Replace replace, ItemStack defaultItem) {
        if (!config.has(path)) {
            return defaultItem;
        }
        UnaryOperator<String> pathBuilder = string -> String.format("%s.%s", path, string);
        String entry = config.string(pathBuilder.apply("material"));
        if (entry == null) {
            return null;
        }
        String[] entryArray = entry.split(":");
        boolean isHead = entryArray[0].equalsIgnoreCase("head") && entryArray.length == 2;
        boolean isAdvancedHead = config.has(pathBuilder.apply("advanced-heads"));

        ItemStack itemStack = isHead || isAdvancedHead? null : MultiMaterial.parseItem(entry);
        if (itemStack == null && !(isHead || isAdvancedHead)) {
            return null;
        }
        Builder builder = builder().itemStack(itemStack);
        validatePath(config, pathBuilder.apply("name"), localPath -> builder.name(Text.modify(config.string(pathBuilder.apply("name")), replace)));
        validatePath(config, pathBuilder.apply("lore"), localPath -> builder.lore(Text.modify(config.list(localPath), replace)));
        validatePath(config, pathBuilder.apply("amount"), localPath -> builder.amount(config.integer(localPath)));
        validatePath(config, pathBuilder.apply("rgb"), localPath -> builder.color(config.string(localPath)));
        validatePath(config, pathBuilder.apply("customModelData"), localPath -> builder.customModelData(config.integer(localPath)));
        if (config.bool(pathBuilder.apply("glow"))) {
            builder.glow();
        }
        config.stringList(pathBuilder.apply("item-flags")).forEach(builder::flag);
        config.stringList(pathBuilder.apply("enchants")).forEach(builder::enchant);

        if (isHead) {
            builder.head(entryArray[1]);
        } else if(isAdvancedHead) {
            builder.itemStack(AdvancedHeadsAPI.getHeadFromId(config.integer(pathBuilder.apply("advanced-heads"))));
        }

        return builder.build();
    }

    /**
     * @param config  The config to get the item from.
     * @param path    The path inside the config to get the item from (e.g 1.item)
     * @param replace A replacer to replace certain parts of the configurable options necessary (name, lore).
     * @return The ItemStack built from the config path
     */
    @Nullable
    public static ItemStack toItem(Config config, String path, Replace replace) {
        return toItemOrDefault(config, path, replace, null);
    }

    /**
     * Converts a section from a config into an ItemStack (must use specific format).
     *
     * @param config The config to get the item from.
     * @param path   The path inside the config to get the item from (e.g 1.item)
     * @return The ItemStack built from the config path.
     */
    @Nullable
    public static ItemStack toItem(Config config, String path) {
        return toItem(config, path, null);
    }

    /**
     * Runs the specified consumer if the path inside the Config is present.
     *
     * @param config    The config to perform on.
     * @param path      The path inside the config to perform on.
     * @param localPath The code to run if the path inside the config is present.
     */
    private static void validatePath(Config config, String path, Consumer<String> localPath) {
        if (config.get(path) != null) {
            localPath.accept(path);
        }
    }

    public static class Builder {
        private ItemStack itemStack = new ItemStack(Material.DIRT);
        private Material material;
        private byte data;
        private int amount = 1;
        private String name;
        private List<String> lore = Lists.newArrayList();
        private Set<ItemFlag> itemFlags = Sets.newHashSet();
        private Map<Enchantment, Integer> enchants = Maps.newHashMap();
        private boolean doesGlow = false;
        private Color color;
        private int customModelData = 0;

        private String base64Head = null;
        private String ownerHead = null;
        private boolean isHead = false;

        /**
         * Specifies the ItemStack of the builder.
         *
         * @param itemStack The ItemStack for the builder.
         * @return The builder.
         */
        public Builder itemStack(ItemStack itemStack) {
            this.itemStack = itemStack;
            return this;
        }

        /**
         * Specifies the material and data of the builder.
         *
         * @param material The material of the item in the builder.
         * @param data     The data of the material.
         * @return The builder.
         */
        public Builder item(Material material, int data) {
            this.material = material;
            this.data = (byte) data;
            return this;
        }

        /**
         * Specifies the material of the builder.
         *
         * @param material The material of the item in the builder.
         * @return The builder.
         */
        public Builder item(Material material) {
            this.material = material;
            return this;
        }

        /**
         * Sets the custom model data of the item.
         *
         * @param customModelData Custom model data to set.
         * @return The Builder.
         */
        public Builder customModelData(int customModelData) {
            this.customModelData = customModelData;
            return this;
        }

        /**
         * Sets the item to a head and sets it's texture.
         *
         * @param base64OrUsername Base64 texture or username to get texture from.
         * @return The Builder.
         */
        public Builder head(String base64OrUsername) {
            String materialName = ServerVersion.isOver_V1_12() ? "PLAYER_HEAD" : "SKULL_ITEM";
            this.itemStack = new ItemStack(Material.valueOf(materialName), 1, (byte) 3);
            this.data = 3;
            this.isHead = true;
            this.base64Head = base64OrUsername.length() > 16 ? base64OrUsername : null;
            this.ownerHead = base64OrUsername.length() < 17 ? base64OrUsername : null;
            return this;
        }

        /**
         * Specifies the amount of the item in the builder.
         *
         * @param amount The amount of the item.
         * @return The builder.
         */
        public Builder amount(int amount) {
            this.amount = amount;
            return this;
        }

        /**
         * Specifies the name of the item in the builder (converts colour codes).
         *
         * @param name The name of the item.
         * @return The builder.
         */
        public Builder name(String name) {
            this.name = Text.modify(name);
            return this;
        }

        /**
         * Specifies the lore of the item in the builder (converts colour codes).
         *
         * @param lore The lore of the item.
         * @return The builder.
         */
        public Builder lore(List<String> lore) {
            this.lore = Text.modify(lore);
            return this;
        }

        /**
         * Specifies the lore of the item in the builder (converts colour codes).
         *
         * @param lore The lore of the item.
         * @return The builder.
         */
        public Builder lore(String... lore) {
            this.lore = Text.modify(Arrays.asList(lore));
            return this;
        }

        /**
         * Adds an item flag to the item in the builder.
         *
         * @param flag The flag to add to the item.
         * @return The builder.
         */
        public Builder flag(ItemFlag flag) {
            this.itemFlags.add(flag);
            return this;
        }

        /**
         * Adds an item flag to the item in the builder using its name.
         *
         * @param flagString The name of the item flag.
         * @return The builder.
         */
        public Builder flag(String flagString) {
            try {
                ItemFlag flag = ItemFlag.valueOf(flagString.toUpperCase());
                this.itemFlags.add(flag);
            } catch (Exception ignored) {
            }
            return this;
        }

        /**
         * Adds an enchant to the item in the builder.
         *
         * @param enchant The enchant to add.
         * @param level   The level of the enchant to add.
         * @return The builder.
         */
        public Builder enchant(Enchantment enchant, int level) {
            this.enchants.put(enchant, level);
            return this;
        }

        /**
         * Adds an enchant to the item in the builder using its name.
         *
         * @param enchant The name of the enchant (could be :level as well).
         * @return The builder.
         */
        public Builder enchant(String enchant) {
            String[] enchantSplit = enchant.split(":");
            if (enchantSplit.length == 2) {
                Enchantment enchantment = Enchantment.getByName(enchantSplit[0]);
                int level = Integer.parseInt(enchantSplit[1]);
                if (enchantment == null) {
                    return this;
                }
                this.enchants.put(enchantment, level);
            }
            return this;
        }

        /**
         * Sets the item to glow without displaying an enchant.
         *
         * @return The builder
         */
        public Builder glow() {
            this.doesGlow = true;
            return this;
        }

        public Builder color(String string) {
            if (!string.contains(",")) {
                return this;
            }
            String[] elements = string.replace(" ", "").split(",");
            if (elements.length != 3) {
                return this;
            }
            this.color = Color.fromRGB(Integer.parseInt(elements[0]), Integer.parseInt(elements[1]), Integer.parseInt(elements[2]));
            return this;
        }

        /**
         * Sets a {@link String} NBT tag.
         *
         * @param key   NBT key.
         * @param value NBT value.
         * @return The Builder.
         */
        public Builder nbt(String key, String value) {
            NbtItem nbtItem = new NbtItem(this.itemStack);
            nbtItem.setString(key, value);
            this.itemStack = nbtItem.getItem();
            return this;
        }

        /**
         * Sets a {@link Boolean} NBT tag.
         *
         * @param key   NBT key.
         * @param value NBT value.
         * @return The Builder.
         */
        public Builder nbt(String key, boolean value) {
            NbtItem nbtItem = new NbtItem(this.itemStack);
            nbtItem.setBoolean(key, value);
            this.itemStack = nbtItem.getItem();
            return this;
        }

        /**
         * Sets a {@link Byte} NBT tag.
         *
         * @param key   NBT key.
         * @param value NBT value.
         * @return The Builder.
         */
        public Builder nbt(String key, byte value) {
            NbtItem nbtItem = new NbtItem(this.itemStack);
            nbtItem.setByte(key, value);
            this.itemStack = nbtItem.getItem();
            return this;
        }

        /**
         * Sets a {@link Byte[]} NBT tag.
         *
         * @param key   NBT key.
         * @param value NBT value.
         * @return The Builder.
         */
        public Builder nbt(String key, byte[] value) {
            NbtItem nbtItem = new NbtItem(this.itemStack);
            nbtItem.setByteArray(key, value);
            this.itemStack = nbtItem.getItem();
            return this;
        }

        /**
         * Sets a {@link Short} NBT tag.
         *
         * @param key   NBT key.
         * @param value NBT value.
         * @return The Builder.
         */
        public Builder nbt(String key, short value) {
            NbtItem nbtItem = new NbtItem(this.itemStack);
            nbtItem.setShort(key, value);
            this.itemStack = nbtItem.getItem();
            return this;
        }

        /**
         * Sets an {@link Integer} NBT tag.
         *
         * @param key   NBT key.
         * @param value NBT value.
         * @return The Builder.
         */
        public Builder nbt(String key, int value) {
            NbtItem nbtItem = new NbtItem(this.itemStack);
            nbtItem.setInteger(key, value);
            this.itemStack = nbtItem.getItem();
            return this;
        }

        /**
         * Sets an {@link Integer[]} NBT tag.
         *
         * @param key   NBT key.
         * @param value NBT value.
         * @return The Builder.
         */
        public Builder nbt(String key, int[] value) {
            NbtItem nbtItem = new NbtItem(this.itemStack);
            nbtItem.setIntArray(key, value);
            this.itemStack = nbtItem.getItem();
            return this;
        }

        /**
         * Sets a {@link Long} NBT tag.
         *
         * @param key   NBT key.
         * @param value NBT value.
         * @return The Builder.
         */
        public Builder nbt(String key, long value) {
            NbtItem nbtItem = new NbtItem(this.itemStack);
            nbtItem.setLong(key, value);
            this.itemStack = nbtItem.getItem();
            return this;
        }

        /**
         * Sets a {@link Float} NBT tag.
         *
         * @param key   NBT key.
         * @param value NBT value.
         * @return The Builder.
         */
        public Builder nbt(String key, float value) {
            NbtItem nbtItem = new NbtItem(this.itemStack);
            nbtItem.setFloat(key, value);
            this.itemStack = nbtItem.getItem();
            return this;
        }

        /**
         * Sets a {@link Double} NBT tag.
         *
         * @param key   NBT key.
         * @param value NBT value.
         * @return The Builder.
         */
        public Builder nbt(String key, double value) {
            NbtItem nbtItem = new NbtItem(this.itemStack);
            nbtItem.setDouble(key, value);
            this.itemStack = nbtItem.getItem();
            return this;
        }

        /**
         * Sets an {@link ItemStack} NBT tag.
         *
         * @param key   NBT key.
         * @param value NBT value.
         * @return The Builder.
         */
        public Builder nbt(String key, ItemStack value) {
            NbtItem nbtItem = new NbtItem(this.itemStack);
            nbtItem.setItemStack(key, value);
            this.itemStack = nbtItem.getItem();
            return this;
        }

        /**
         * Sets an {@link Object} NBT tag.
         *
         * @param key   NBT key.
         * @param value NBT value.
         * @return The Builder.
         */
        public Builder nbt(String key, Object value) {
            NbtItem nbtItem = new NbtItem(this.itemStack);
            nbtItem.setObject(key, value);
            this.itemStack = nbtItem.getItem();
            return this;
        }

        /**
         * Builds the item using all set values.
         *
         * @return The ItemStack
         */
        public ItemStack build() {
            return this.build(null);
        }

        /**
         * Builds the item using all set values and applies NBT changes.
         *
         * @param function The changes to apply to the item's NBT (through an NBT item)
         * @return The ItemStack
         */
        public ItemStack build(UnaryOperator<NbtItem> function) {
            if (this.material != null) {
                this.itemStack.setType(this.material);
                this.itemStack.setAmount(this.amount);
                this.itemStack.setDurability(this.data);
            }
            if (this.amount > 0) {
                this.itemStack.setAmount(this.amount);
            }
            if (this.itemStack.getItemMeta() == null) {
                return this.itemStack;
            }
            ItemMeta itemMeta = this.itemStack.getItemMeta();
            this.itemStack.setItemMeta(createMeta(itemMeta));
            if (this.isHead) {
                SkullMeta skullMeta = (SkullMeta) this.itemStack.getItemMeta();
                if (this.base64Head != null) {
                    GameProfile profile = new GameProfile(UUID.randomUUID(), "");
                    profile.getProperties().put("textures", new Property("textures", this.base64Head));
                    Field profileField = null;
                    try {
                        profileField = skullMeta.getClass().getDeclaredField("profile");
                        profileField.setAccessible(true);
                        profileField.set(skullMeta, profile);
                    } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
                        e.printStackTrace();
                    }
                } else {
                    skullMeta.setOwner(this.ownerHead);
                }
                this.itemStack.setItemMeta(skullMeta);
            }
            if (function == null) {
                return this.itemStack;
            }
            return function.apply(new NbtItem(this.itemStack)).getItem();
        }

        public ItemMeta createMeta(ItemMeta itemMeta) {
            if (this.name != null) {
                itemMeta.setDisplayName(this.name);
            }
            if (this.customModelData != 0) {
                itemMeta.setCustomModelData(customModelData);
            }
            if (!this.lore.isEmpty() && (!this.lore.get(0).isEmpty() || this.lore.size() >= 2)) {
                itemMeta.setLore(this.lore);
            }
            if (!this.itemFlags.isEmpty()) {
                for (ItemFlag itemFlag : this.itemFlags) {
                    itemMeta.addItemFlags(itemFlag);
                }
            }
            if (!this.enchants.isEmpty()) {
                for (Map.Entry<Enchantment, Integer> entry : this.enchants.entrySet()) {
                    itemMeta.addEnchant(entry.getKey(), entry.getValue(), true);
                }
            }
            if (this.doesGlow) {
                itemMeta.addEnchant(Enchantment.DURABILITY, 0, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            }
            if (this.color != null && itemMeta instanceof LeatherArmorMeta) {
                ((LeatherArmorMeta) itemMeta).setColor(this.color);
            }
            return itemMeta;
        }
    }

}
