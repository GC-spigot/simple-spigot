package me.javadebug.simplespigot.menu;

import com.google.common.collect.Maps;
import me.javadebug.simplespigot.menu.item.MenuItem;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public abstract class Menu implements InventoryHolder {
    protected final Player player;
    private Inventory inventory;
    private MenuState menuState;
    private Runnable closeAction;
    private Map<Integer, MenuItem> menuItems = Maps.newHashMap();
    private BukkitTask updater;

    private final String title;
    private final int rows;

    public Menu(Player player, String title, int rows) {
        this.player = player;
        this.menuState = MenuState.RAW;
        this.title = title;
        this.rows = rows;
    }

    public abstract void redraw();

    @Override
    public Inventory getInventory() {
        return this.inventory;
    }

    public void show() {
        if (this.menuState.isRaw()) {
            this.inventory = Bukkit.createInventory(this, this.rows * 9, this.title);
            this.redraw();
            this.menuState = MenuState.ACTIVE;
        }
        this.player.openInventory(this.inventory);
    }

    public void close() {
        this.player.closeInventory();
    }

    public MenuItem getMenuItem(int rawSlot) {
        return this.menuItems.get(rawSlot);
    }

    public Runnable getCloseAction() {
        return this.closeAction;
    }

    public void setCloseAction(Runnable closeAction) {
        this.closeAction = closeAction;
    }

    public String getTitle() {
        return this.title;
    }

    public int getRows() {
        return this.rows;
    }

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

    public void flush() {
        for (int slot : this.menuItems.keySet()) {
           this.inventory.setItem(slot, null);
        }
        this.menuItems.clear();
    }

    public void flush(int x, int y) {
        this.flush(this.gridToSlot(x, y));
    }

    public void flush(int slot) {
        this.menuItems.computeIfPresent(slot, (key, value) -> {
            this.menuItems.remove(slot);
            this.inventory.setItem(slot, null);
            return value;
        });
    }

    public void enduringRun(Runnable runnable) {
        if (this.menuState.isRaw()) {
            runnable.run();
        }
    }

    public <T> T enduringSupply(Supplier<T> supplier) {
        if (this.menuState.isRaw()) {
            return supplier.get();
        }
        return null;
    }

    public void item(MenuItem menuItem) {
        int slot = this.gridToSlot(menuItem.getSlot(), menuItem.getRow());
        this.menuItems.put(slot, menuItem);
        this.inventory.setItem(slot, menuItem.getItemStack());
    }

    public void item(UnaryOperator<MenuItem.Builder> builder) {
        this.item(builder.apply(MenuItem.builder()).build());
    }

    public void items(UnaryOperator<MenuItem.Builder>... builders) {
        for (UnaryOperator<MenuItem.Builder> builder : builders) {
            this.item(builder);
        }
    }

    public Optional<Integer> firstEmpty() {
        int firstEmpty = this.inventory.firstEmpty();
        return firstEmpty < 0 ? Optional.empty() : Optional.of(firstEmpty);
    }

    private int gridToSlot(int x, int y) {
        return 9 * (y - 1) + (x - 1);
    }

    private enum MenuState {
        RAW, ACTIVE;

        public boolean isRaw() {
            return this.equals(RAW);
        }

        public boolean isActive() {
            return this.equals(ACTIVE);
        }
    }
}
