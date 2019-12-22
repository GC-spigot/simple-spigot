package me.javadebug.simplespigot.menu.item;

import me.javadebug.simplespigot.item.SpigotItem;
import me.javadebug.simplespigot.menu.item.click.ClickAction;
import org.bukkit.inventory.ItemStack;

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

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builderOf(MenuItem menuItem) {
        return new Builder(menuItem);
    }

    public static class Builder extends SpigotItem.Builder {
        private int slot;
        private int row;
        private ClickAction clickAction;

        public Builder() {
        }

        public Builder(MenuItem menuItem) {
            this.slot = menuItem.getSlot();
            this.row = menuItem.getRow();
            this.clickAction = menuItem.getClickAction();
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

        public MenuItem compose() {
            return new MenuItem(super.build(), this.row, this.slot, this.clickAction);
        }
    }
}
