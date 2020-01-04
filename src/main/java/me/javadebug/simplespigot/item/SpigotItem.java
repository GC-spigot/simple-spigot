package me.javadebug.simplespigot.item;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import me.javadebug.simplespigot.config.Config;
import me.javadebug.simplespigot.text.Replacer;
import me.javadebug.simplespigot.text.Text;
import me.javadebug.simplespigot.version.MultiMaterial;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.UnaryOperator;

public class SpigotItem {

    public static Builder builder() {
        return new Builder();
    }

    public static ItemStack toItem(Config config, String path, UnaryOperator<Replacer> replacer) {
        UnaryOperator<String> pathBuilder = string -> String.format("%s.%s", path, string);
        ItemStack itemStack = MultiMaterial.itemFrom(config.get(pathBuilder.apply("material")));
        if (itemStack == null) {
            return null;
        }
        Builder builder = builder()
                .itemStack(itemStack)
                .name(Text.modify(config.string(pathBuilder.apply("name")), replacer))
                .lore(Text.modify(config.list(pathBuilder.apply("lore")), replacer));
        for (String flag : config.stringList(pathBuilder.apply("item-flags"))) {
            builder.flag(flag);
        }
        for (String enchant : config.stringList(pathBuilder.apply("enchants"))) {
            builder.enchant(enchant);
        }
        return builder.build();
    }

    public static ItemStack toItem(Config config, String path) {
        return toItem(config, path, null);
    }

    public static class Builder {
        private ItemStack itemStack = new ItemStack(Material.DIRT);
        private Material material;
        private byte data;
        private int amount;
        private String name;
        private List<String> lore = Lists.newArrayList();
        private Set<ItemFlag> itemFlags = Sets.newHashSet();
        private Map<Enchantment, Integer> enchants = Maps.newHashMap();
        private boolean doesGlow = false;

        public Builder itemStack(ItemStack itemStack) {
            this.itemStack = itemStack;
            return this;
        }

        public Builder item(Material material, int data) {
            this.material = material;
            this.data = (byte) data;
            return this;
        }

        public Builder amount(int amount) {
            this.amount = amount;
            return this;
        }

        public Builder name(String name) {
            this.name = Text.modify(name);
            return this;
        }

        public Builder lore(List<String> lore) {
            this.lore = Text.modify(lore);
            return this;
        }

        public Builder lore(String... lore) {
            this.lore = Text.modify(Arrays.asList(lore));
            return this;
        }

        public Builder flag(ItemFlag flag) {
            this.itemFlags.add(flag);
            return this;
        }

        public Builder flag(String flagString) {
            ItemFlag flag;
            try {
                flag = ItemFlag.valueOf(flagString.toUpperCase());
            } catch (Exception e) {
                return this;
            }
            return this;
        }

        public Builder enchant(Enchantment enchant, int level) {
            this.enchants.put(enchant, level);
            return this;
        }

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

        public Builder glow() {
            this.doesGlow = true;
            return this;
        }

        public ItemStack build() {
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
            if (!this.lore.isEmpty() && !this.lore.get(0).isEmpty()) {
                itemMeta.setLore(this.lore);
            }
            if (!this.itemFlags.isEmpty()) {
                for (ItemFlag itemFlag : this.itemFlags) {
                    itemMeta.addItemFlags(itemFlag);
                }
            }

            if (this.doesGlow) {
                itemMeta.addEnchant(Enchantment.DURABILITY, 0, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            }
            this.itemStack.setItemMeta(itemMeta);
            return itemStack;
        }
    }
}