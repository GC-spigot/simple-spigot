package me.hyfe.simplespigot.menu.item.click;

import me.hyfe.simplespigot.menu.item.MenuItem;

public interface ClickAction {

    /**
     * The code to run when an item is clicked.
     *
     * @param menuItem  The menu item that is clicked.
     * @param clickType The type of click, e.g drop or right_click.
     */

    void onClick(MenuItem menuItem, ClickType clickType);
}
