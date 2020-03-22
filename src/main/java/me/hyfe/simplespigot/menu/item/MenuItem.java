package me.hyfe.simplespigot.menu.item;

import me.hyfe.simplespigot.config.Config;
import me.hyfe.simplespigot.item.SpigotItem;
import me.hyfe.simplespigot.menu.item.click.ClickAction;
import me.hyfe.simplespigot.text.Replace;
import org.bukkit.inventory.ItemStack;

import java.util.function.UnaryOperator;

public class MenuItem {
    private final ItemStack itemStack;
    private final int row;
    private final int slot;
    private final ClickAction clickAction;

    public MenuItem(ItemStack itemStack, int row, int slot, ClickAction clickAction) {
        this.itemStack = itemStack;
        this.row = row;
        this.slot = slot;
        this.clickAction = clickAction;
    }

    public ItemStack getItemStack() {
        return this.itemStack;
    }

    public int getRow() {
        return this.row;
    }

    public int getSlot() {
        return this.slot;
    }

    public ClickAction getClickAction() {
        return this.clickAction;
    }

    public static MenuItem of(ItemStack itemStack) {
        return new MenuItem(itemStack, 1, 1, (menuItem, clickType) -> {});
    }

    public static Builder builderOf(ItemStack itemStack) {
        return new Builder(new MenuItem(itemStack, 1, 1, (menuItem, clickType) -> {}));
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builderOf(MenuItem menuItem) {
        return new Builder(menuItem);
    }

    public static class Builder {
        private ItemStack itemStack;
        private int slot;
        private int row;
        private ClickAction clickAction;

        public Builder() {
        }

        public Builder(MenuItem menuItem) {
            this.itemStack = menuItem.getItemStack();
            this.slot = menuItem.getSlot();
            this.row = menuItem.getRow();
            this.clickAction = menuItem.getClickAction();
        }

        public Builder item(UnaryOperator<SpigotItem.Builder> itemBuilder) {
            this.itemStack = itemBuilder.apply(new SpigotItem.Builder()).build();
            return this;
        }

        public Builder item(Config config, String path) {
            this.itemStack = SpigotItem.toItem(config, path);
            return this;
        }

        public Builder item(Config config, String path, Replace replace) {
            this.itemStack = SpigotItem.toItem(config, path, replace);
            return this;
        }

        public Builder slot(int slot) {
            this.slot = slot;
            return this;
        }

        public Builder row(int row) {
            this.row = row;
            return this;
        }

        public Builder rawSlot(int slot) {
            this.row = slot / 9 + 1;
            this.slot = -9 * this.row + 10 + slot;
            return this;
        }

        public Builder grid(int slot, int row) {
            this.slot = slot;
            this.row = row;
            return this;
        }

        public Builder onClick(ClickAction clickAction) {
            this.clickAction = clickAction;
            return this;
        }

        public MenuItem build() {
            return new MenuItem(this.itemStack, this.row, this.slot, this.clickAction);
        }
    }
}
