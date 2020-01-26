package me.javadebug.simplespigot.menu;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import me.javadebug.simplespigot.menu.item.MenuItem;
import me.javadebug.simplespigot.service.MutablePair;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class PageableMenu<T> extends Menu {
    private List<T> elements;
    private List<Integer> elementSlots;
    private Map<Integer, Set<Integer>> cachedPageIndexes = Maps.newHashMap();

    protected int page = 1;

    public PageableMenu(Player player, String title, int rows) {
        super(player, title, rows);
    }

    public abstract MenuItem pageableItem(T object);

    public abstract MutablePair<Collection<T>, Collection<Integer>> elementalValues();

    @Override
    public void close() {
        this.player.closeInventory();
        this.cachedPageIndexes.clear();
    }

    public int getPage() {
        return this.page;
    }

    public void drawPageableItems() {
        if (this.elements == null || this.elementSlots == null) {
            this.elements = Lists.newArrayList(this.elementalValues().getKey());
            this.elementSlots = Lists.newArrayList(this.elementalValues().getValue());
        }
        this.cachedPageIndexes.computeIfAbsent(this.page, key -> {
            int slotAmount = this.elementSlots.size();
            Set<Integer> indexes = Sets.newLinkedHashSetWithExpectedSize(slotAmount);
            for (int slot = 0; slot < slotAmount; slot++) {
                int index = (this.page - 1) * slotAmount + slot;
                if (index < this.elements.size()) {
                    indexes.add(index);
                }
            }
            return indexes;
        });
        int slotIndex = 0;
        for (int index : this.cachedPageIndexes.get(this.page)) {
            this.item(MenuItem.builderOf(this.pageableItem(this.elements.get(index))).rawSlot(this.elementSlots.get(slotIndex)).build());
            slotIndex++;
        }
    }

    public void nextPage(Runnable runnable) {
        if (this.page * this.elementSlots.size() >= this.elements.size()) {
            return;
        }
        this.page++;
        runnable.run();
    }

    public void previousPage(Runnable runnable) {
        this.page--;
        runnable.run();
    }
}
