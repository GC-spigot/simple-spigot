package me.hyfe.simplespigot.menu;

import com.google.common.collect.Maps;
import me.hyfe.simplespigot.menu.item.MenuItem;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public abstract class Menu implements InventoryHolder {
    protected final Player player;
    private String title;
    private int rows;
    private Inventory inventory;
    private MenuState menuState;
    private Runnable closeAction;
    private Map<Integer, MenuItem> menuItems = Maps.newHashMap();
    private BukkitTask updater;

    /**
     * Creates a new instance of a Menu
     *
     * @param player The player that the menu will be used for.
     * @param title  The title of the menu.
     * @param rows   The amount of rows in the menu.
     */
    public Menu(Player player, String title, int rows) {
        this.player = player;
        this.menuState = MenuState.RAW;
        this.title = title;
        this.rows = rows;
    }

    /**
     * Draws the items in the menu.
     */
    public abstract void redraw();

    /**
     * Gets the Inventory.
     *
     * @return The Inventory.
     */
    @Override
    public Inventory getInventory() {
        return this.inventory;
    }

    /**
     * Shows the menu for the player.
     */
    public void show() {
        if (this.menuState.isRaw()) {
            this.inventory = Bukkit.createInventory(this, this.rows * 9, this.title);
            this.redraw();
            this.menuState = MenuState.ACTIVE;
        }
        this.player.openInventory(this.inventory);
    }

    /**
     * Closes the player's currently open menu.
     */
    public void close() {
        this.player.closeInventory();
    }

    /**
     * Set the title before the inventory is created
     *
     * @param title the title
     */
    public void preTitle(String title) {
        this.title = title;
    }

    /**
     * Set the rows before the inventory is created
     *
     * @param rows the rows
     */
    public void preRows(int rows) {
        this.rows = rows;
    }

    /**
     * Gets a menu item in a slot.
     *
     * @param rawSlot The raw integer slot (e.g 32) to get the menu item from.
     * @return The MenuItem in the slot.
     */
    public MenuItem getMenuItem(int rawSlot) {
        return this.menuItems.get(rawSlot);
    }

    /**
     * Gets the action run on close.
     *
     * @return A Runnable of what is run on close.
     */
    public Runnable getCloseAction() {
        return this.closeAction;
    }

    /**
     * Sets the Runnable of what is run on close.
     *
     * @param closeAction The Runnable to be run when the menu is closed.
     */
    public void setCloseAction(Runnable closeAction) {
        this.closeAction = closeAction;
    }

    /**
     * @return The title of the menu.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Sets the title of the menu.
     * This should only be used before the menu is shown to the player (show method called)
     *
     * @param title The title of the menu
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return The rows in the menu.
     */
    public int getRows() {
        return this.rows;
    }

    /**
     * Gets the state of the menu (active, raw, etc..)
     *
     * @return The MenuState of the menu.
     */
    public MenuState getMenuState() {
        return this.menuState;
    }

    /**
     * Refreshes / updates the menu at a specific interval.
     *
     * @param plugin   The plugin main class.
     * @param interval The tick interval to refresh the menu at.
     */
    // TODO optimize
    public void addUpdater(Plugin plugin, int interval) {
        this.updater = Bukkit.getScheduler().runTaskTimer(plugin, () -> {
            if (this.inventory.getHolder() != null && this.inventory.getHolder().equals(this.player.getOpenInventory().getTopInventory().getHolder())) {
                this.redraw();
            } else {
                this.updater.cancel();
            }
        }, 0, interval);
    }

    /**
     * Removes the items in every slot of the inventory.
     */
    public void flush() {
        for (int slot : this.menuItems.keySet()) {
            this.inventory.setItem(slot, null);
        }
        this.menuItems.clear();
    }

    /**
     * Removes the item in the specified row and slot.
     *
     * @param slot The slot of the item.
     * @param row  The row of the item.
     */
    public void flush(int slot, int row) {
        this.flush(this.gridToSlot(slot, row));
    }

    /**
     * Removes the item in a slot.
     *
     * @param slot The slot to remove the item from.
     */
    public void flush(int slot) {
        if (!this.menuItems.containsKey(slot)) {
            return;
        }
        this.menuItems.remove(slot);
        this.inventory.setItem(slot, null);
    }

    /**
     * Runs the code if the menu is in a raw state.
     *
     * @param runnable
     */
    public void enduringRun(Runnable runnable) {
        if (this.menuState.isRaw()) {
            runnable.run();
        }
    }

    /**
     * Returns the supplier if the menu is in a raw state.
     *
     * @param supplier The supplier to run.
     * @param <T>      The type.
     * @return The requested value.
     */
    public <T> T enduringSupply(Supplier<T> supplier) {
        if (this.menuState.isRaw()) {
            return supplier.get();
        }
        return null;
    }

    /**
     * Sets a slot to the specified menu item.
     *
     * @param menuItem The MenuItem to set in the GUI.
     */
    public void item(MenuItem menuItem) {
        int slot = this.gridToSlot(menuItem.getSlot(), menuItem.getRow());
        this.menuItems.put(slot, menuItem);
        this.inventory.setItem(slot, menuItem.getItemStack());
    }

    /**
     * Gets the first empty slot in the menu.
     *
     * @return An Optional of the first empty slot in the GUI.
     */
    public Optional<Integer> firstEmpty() {
        int firstEmpty = this.inventory.firstEmpty();
        return firstEmpty < 0 ? Optional.empty() : Optional.of(firstEmpty);
    }

    /**
     * Iterates through all empty slots
     *
     * @param rawSlot The slot consumer
     */
    public void loopEmptyRawSlots(Consumer<Integer> rawSlot) {
        while (this.firstEmpty().isPresent()) {
            rawSlot.accept(this.firstEmpty().get());
        }
    }

    /**
     * Converts a row and slot to a raw slot.
     *
     * @param row  The row.
     * @param slot The slot.
     * @return The raw slot (e.g 22)
     */
    private int gridToSlot(int row, int slot) {
        return 9 * (slot - 1) + (row - 1);
    }

    public enum MenuState {
        RAW, ACTIVE;

        /**
         * @return Whether the menu is raw.
         */
        public boolean isRaw() {
            return this.equals(RAW);
        }

        /**
         * @return Whether the menu is active.
         */
        public boolean isActive() {
            return this.equals(ACTIVE);
        }
    }
}
