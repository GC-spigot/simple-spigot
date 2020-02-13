package me.hyfe.simplespigot.menu.item.click;

import me.hyfe.simplespigot.menu.item.MenuItem;

public interface ClickAction {

    void onClick(MenuItem menuItem, ClickType clickType);
}
