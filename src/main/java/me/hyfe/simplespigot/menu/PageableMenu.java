package me.hyfe.simplespigot.menu;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import me.hyfe.simplespigot.menu.item.MenuItem;
import me.hyfe.simplespigot.service.tuple.ImmutablePair;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class PageableMenu<T> extends Menu {
    protected int page = 1;
    private List<T> elements;
    private List<Integer> elementSlots;
    private Map<Integer, Set<Integer>> cachedPageIndexes = Maps.newHashMap();

    public PageableMenu(Player player, String title, int rows) {
        super(player, title, rows);
    }

    public abstract MenuItem pageableItem(T object);

    public abstract ImmutablePair<Collection<T>, Collection<Integer>> elementalValues();

    @Override
    public void close() {
        this.player.closeInventory();
        this.cachedPageIndexes.clear();
    }

    public int getPage() {
        return this.page;
    }

    public void drawPageableItems() {
        this.drawPageableItems(() -> {
        });
    }

    public void drawPageableItems(Runnable runBeforeSet) {
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
        for (int slot : this.elementSlots) {
            this.flush(slot);
        }
        runBeforeSet.run();
        int slotIndex = 0;
        for (int index : this.cachedPageIndexes.get(this.page)) {
            this.item(MenuItem.builderOf(this.pageableItem(this.elements.get(index))).rawSlot(this.elementSlots.get(slotIndex)).build());
            slotIndex++;
        }
    }

    public void nextPage(Runnable runnable) {
        if (this.elements.size() < this.elementSlots.size() * this.page + 1) {
            return;
        }
        this.page++;
        runnable.run();
    }

    public void previousPage(Runnable runnable) {
        this.page--;
        runnable.run();
    }

    public void refreshPageableItems() {
        this.elements = Lists.newArrayList(this.elementalValues().getKey());
        this.cachedPageIndexes.clear();
        this.redraw();
    }
}
