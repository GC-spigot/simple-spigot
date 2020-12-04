package me.hyfe.simplespigot.menu.item;

import me.hyfe.simplespigot.config.Config;
import me.hyfe.simplespigot.item.SpigotItem;
import me.hyfe.simplespigot.menu.Menu;
import me.hyfe.simplespigot.menu.item.click.ClickAction;
import me.hyfe.simplespigot.text.replacer.Replace;
import org.bukkit.inventory.ItemStack;

public class MenuItem {
    private final ItemStack itemStack;
    private final int row;
    private final int slot;
    private final ClickAction clickAction;

    /**
     * Creates a Menuitem
     *
     * @param itemStack   The item
     * @param row         The row
     * @param slot        The slot
     * @param clickAction The click action that was performed.
     */
    public MenuItem(ItemStack itemStack, int row, int slot, ClickAction clickAction) {
        this.itemStack = itemStack;
        this.row = row;
        this.slot = slot;
        this.clickAction = clickAction;
    }

    /**
     * Creates a MenuItem from an ItemStack
     *
     * @param itemStack The ItemStack.
     * @return The MenuItem created.
     */
    public static MenuItem of(ItemStack itemStack) {
        return new MenuItem(itemStack, 1, 1, (menuItem, clickType) -> {
        });
    }

    /**
     * Creates a builder from an ItemStack
     *
     * @param itemStack The ItemStack.
     * @return The Builder created.
     */
    public static Builder builderOf(ItemStack itemStack) {
        return new Builder(new MenuItem(itemStack, 1, 1, (menuItem, clickType) -> {
        }));
    }

    /**
     * Creates an empty builder.
     *
     * @return The Builder created.
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Creates a builder from a MenuItem.
     *
     * @param menuItem The MenuItem.
     * @return The Builder created.
     */
    public static Builder builderOf(MenuItem menuItem) {
        return new Builder(menuItem);
    }

    /**
     * Gets the ItemStack of the MenuItem.
     *
     * @return The ItemStack of the MenuItem.
     */
    public ItemStack getItemStack() {
        return this.itemStack;
    }

    /**
     * Gets the row of the MenuItem.
     *
     * @return An integer of the row of the menu item.
     */
    public int getRow() {
        return this.row;
    }

    /**
     * Gets the slot of the MenuItem.
     *
     * @return An integer of the slot of the menu item.
     */
    public int getSlot() {
        return this.slot;
    }

    /**
     * Gets the type of click performed.
     *
     * @return The ClickAction performed when the item is clicked..
     */
    public ClickAction getClickAction() {
        return this.clickAction;
    }

    public static class Builder {
        private ItemStack itemStack;
        private int slot;
        private int row;
        private ClickAction clickAction;

        /**
         * Creates a new menu item builder with no initial values.
         */
        public Builder() {
        }

        /**
         * Creates a menu item builder from an existing menu item.
         *
         * @param menuItem The menu item to create the builder from.
         */
        public Builder(MenuItem menuItem) {
            this.itemStack = menuItem.getItemStack();
            this.slot = menuItem.getSlot();
            this.row = menuItem.getRow();
            this.clickAction = menuItem.getClickAction();
        }

        /**
         * Sets the item using a SpigotItem Builder.
         *
         * @param builder The item builder
         * @return The menu item builder.
         */
        public Builder item(SpigotItem.Builder builder) {
            this.itemStack = builder.build();
            return this;
        }

        /**
         * Sets the item from a configured item.
         *
         * @param config The config where the path to the SpigotItem is located.
         * @param path   The path inside the configuration file where the SpigotItem is located.
         * @return The menu item builder.
         */
        public Builder item(Config config, String path) {
            this.itemStack = SpigotItem.toItem(config, path);
            return this;
        }

        /**
         * Sets the item from a configured item.
         *
         * @param config  The config where the path to the SpigotItem is located.
         * @param path    The path inside the configuration file where the SpigotItem is located.
         * @param replace The replacer for what text to replace.
         * @return The menu item builder.
         */
        public Builder item(Config config, String path, Replace replace) {
            this.itemStack = SpigotItem.toItem(config, path, replace);
            return this;
        }

        /**
         * Sets the slot of the menu item.
         *
         * @param slot The slot to place the item in.
         * @return The menu item builder.
         */
        public Builder slot(int slot) {
            this.slot = slot;
            return this;
        }

        /**
         * Sets the row of the menu item.
         *
         * @param row The row to place the item in.
         * @return The menu item builder.
         */
        public Builder row(int row) {
            this.row = row;
            return this;
        }

        /**
         * Sets the slot and row of the menu item using a raw number.
         *
         * @param slot The slot to place the item in (e.g 26).
         * @return The menu item builder.
         */
        public Builder rawSlot(int slot) {
            this.row = slot / 9 + 1;
            this.slot = -9 * this.row + 10 + slot;
            return this;
        }

        /**
         * Sets the slot and row of the menu item.
         *
         * @param slot The slot to place the item in.
         * @param row  The row to place the item in.
         * @return The menu item builder.
         */
        public Builder grid(int slot, int row) {
            this.slot = slot;
            this.row = row;
            return this;
        }

        /**
         * Sets the ClickAction of the MenuItem
         *
         * @param clickAction The action to perform on click.
         * @return The menu item builder.
         */
        public Builder onClick(ClickAction clickAction) {
            this.clickAction = clickAction;
            return this;
        }

        /**
         * Builds the MenuItem using all previous values into a MenuItem.
         *
         * @return The MenuItem built.
         */
        public MenuItem build() {
            return new MenuItem(this.itemStack, this.row, this.slot, this.clickAction);
        }

        public void buildTo(Menu menu) {
            menu.item(this.build());
        }
    }
}
