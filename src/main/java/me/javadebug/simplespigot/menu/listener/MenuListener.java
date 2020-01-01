package me.javadebug.simplespigot.menu.listener;

import me.javadebug.simplespigot.menu.Menu;
import me.javadebug.simplespigot.menu.item.MenuItem;
import me.javadebug.simplespigot.menu.item.click.ClickAction;
import me.javadebug.simplespigot.menu.item.click.ClickType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

public class MenuListener implements Listener {

    @EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
    public void onInventoryClick(InventoryClickEvent event) {
        Inventory inventory = event.getInventory();
        InventoryAction action = event.getAction();

        if (inventory.getHolder() instanceof Menu) {
            Menu menu = (Menu) inventory.getHolder();
            event.setCancelled(true);

            int rawSlot = event.getRawSlot();
            if (rawSlot < inventory.getSize() && !action.equals(InventoryAction.NOTHING)) {
                MenuItem menuItem = menu.getMenuItem(rawSlot);
                if (menuItem == null) {
                    return;
                }
                ClickAction clickAction = menuItem.getClickAction();
                if (clickAction == null) {
                    return;
                }
                clickAction.onClick(menuItem, ClickType.parse(action));
            }
        }
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void onInventoryClose(InventoryCloseEvent event) {
        Inventory inventory = event.getInventory();

        if (inventory.getHolder() instanceof Menu) {
            Menu menu = (Menu) inventory.getHolder();
            Runnable closeAction = menu.getCloseAction();
            if (closeAction == null) {
                return;
            }
            closeAction.run();
        }
    }
}