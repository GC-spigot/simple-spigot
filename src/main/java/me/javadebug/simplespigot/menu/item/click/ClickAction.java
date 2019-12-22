package me.javadebug.simplespigot.menu.item.click;

import me.javadebug.simplespigot.menu.item.MenuItem;

public interface ClickAction {

    void onClick(MenuItem menuItem, ClickType clickType);
}
