package me.hyfe.simplespigot.service.simple.services;

import com.google.common.collect.Sets;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;
import java.util.Map;

public class SpigotService {

    public void giveItem(Player player, Collection<ItemStack> collection) {
        Map<Integer, ItemStack> result = player.getInventory().addItem(collection.toArray(new ItemStack[0]));
        if (result.isEmpty()) {
            return;
        }
        Location location = player.getLocation();
        World world = location.getWorld();
        for (ItemStack itemStack : result.values()) {
            world.dropItemNaturally(location, itemStack);
        }
    }

    public void giveItem(Player player, ItemStack itemStack) {
        giveItem(player, Sets.newHashSet(itemStack));
    }

    public boolean isPluginEnabledByAuthor(String name, String author) {
        if (Bukkit.getPluginManager().isPluginEnabled(name)) {
            return Bukkit.getPluginManager().getPlugin(name).getDescription().getAuthors().contains(author);
        }
        return false;
    }

    // Recommend against this method for now.
    public boolean isPluginEnabled(String name, String mainClassPath) {
        if (Bukkit.getPluginManager().isPluginEnabled(name)) {
            try {
                Class.forName(mainClassPath);
                return true;
            } catch (ClassNotFoundException e) {
                return false;
            }
        }
        return false;
    }
}
