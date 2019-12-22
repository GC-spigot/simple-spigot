package me.javadebug.simplespigot.menu;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import me.javadebug.simplespigot.menu.item.MenuItem;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.Set;

public abstract class DynamicPageableMenu<T> extends Menu {
    private final T[] elements;
    private final Integer[] elementSlots;
    private Map<Integer, Set<Integer>> cachedPageIndexes = Maps.newHashMap();

    protected int page;

    public DynamicPageableMenu(Player player, String title, int rows, T[] elements, Integer[] elementSlots) {
        super(player, title, rows);
        this.elements = elements;
        this.elementSlots = elementSlots;
    }

    public abstract MenuItem pageableItem(T object);

    @Override
    public void close() {
        this.player.closeInventory();
        this.cachedPageIndexes.clear();
    }

    public void drawPageableItems() {
        this.cachedPageIndexes.computeIfAbsent(this.page, key -> {
            int slotAmount = this.elementSlots.length;
            Set<Integer> indexes = Sets.newHashSetWithExpectedSize(slotAmount);
            for (int slot = 0; slot < slotAmount; slot++) {
                int index = (this.page - 1) * slotAmount + slot;
                if (index < this.elements.length) {
                    indexes.add(index);
                }
            }
            return indexes;
        });
        int slotIndex = 0;
        for (int index : this.cachedPageIndexes.get(this.page)) {
            this.item(MenuItem.builderOf(this.pageableItem(this.elements[index])).rawSlot(this.elementSlots[slotIndex]).compose());
            slotIndex++;
        }
    }

    public void nextPage(Runnable runnable) {
        this.page++;
        runnable.run();
    }

    public void previousPage(Runnable runnable) {
        this.page--;
        runnable.run();
    }
}
