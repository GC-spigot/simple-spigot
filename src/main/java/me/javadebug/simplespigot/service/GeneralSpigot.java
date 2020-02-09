package me.javadebug.simplespigot.service;

import com.google.common.collect.Sets;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;
import java.util.Map;

public class GeneralSpigot {

    public static void giveItem(Player player, Collection<ItemStack> collection) {
        Map<Integer, ItemStack> result = player.getInventory().addItem(collection.toArray(new ItemStack[0]));
        if (!result.isEmpty()) {
            Location location = player.getLocation();
            World world = location.getWorld();
            for (Map.Entry<Integer, ItemStack> entry : result.entrySet()) {
                world.dropItemNaturally(location, entry.getValue());
            }
        }
    }

    public static void giveItem(Player player, ItemStack itemStack) {
        giveItem(player, Sets.newHashSet(itemStack));
    }
}
