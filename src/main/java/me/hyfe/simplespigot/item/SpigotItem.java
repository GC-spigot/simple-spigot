package me.hyfe.simplespigot.item;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import me.hyfe.simplespigot.config.Config;
import me.hyfe.simplespigot.nbt.type.NbtItem;
import me.hyfe.simplespigot.text.Replace;
import me.hyfe.simplespigot.text.Text;
import me.hyfe.simplespigot.version.MultiMaterial;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
     * @param config  The config to get the item from.
     * @param path    The path inside the config to get the item from (e.g 1.item)
     * @param replace A replacer to replace certain parts of the configurable options necessary (name, lore).
     * @return The ItemStack built from the config path - nullable.
     */
    public static ItemStack toItem(Config config, String path, Replace replace) {
        UnaryOperator<String> pathBuilder = string -> String.format("%s.%s", path, string);
        ItemStack itemStack = MultiMaterial.itemFrom(config.string(pathBuilder.apply("material")));
        if (itemStack == null) {
            return null;
        }
        Builder builder = builder().itemStack(itemStack);
        validatePath(config, pathBuilder.apply("name"), localPath -> builder.name(Text.modify(config.string(pathBuilder.apply("name")), replace)));
        validatePath(config, pathBuilder.apply("lore"), localPath -> builder.lore(Text.modify(config.list(localPath), replace)));
        validatePath(config, pathBuilder.apply("amount"), localPath -> builder.amount(config.integer(localPath)));
        config.stringList(pathBuilder.apply("item-flags")).forEach(builder::flag);
        config.stringList(pathBuilder.apply("enchants")).forEach(builder::enchant);
        return builder.build();
    }

    /**
     * Converts a section from a config into an ItemStack (must use specific format).
     *
     * @param config The config to get the item from.
     * @param path   The path inside the config to get the item from (e.g 1.item)
     * @return The ItemStack built from the config path - nullable.
     */
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
                this.itemStack = new ItemStack(this.material, this.amount, this.data);
            }
            if (this.amount > 0) {
                this.itemStack.setAmount(this.amount);
            }
            if (this.itemStack.getItemMeta() == null) {
                return this.itemStack;
            }
            ItemMeta itemMeta = this.itemStack.getItemMeta();
            if (this.name != null) {
                itemMeta.setDisplayName(this.name);
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
            this.itemStack.setItemMeta(itemMeta);
            if (function == null) {
                return this.itemStack;
            }
            return function.apply(new NbtItem(this.itemStack)).getItem();
        }
    }
}