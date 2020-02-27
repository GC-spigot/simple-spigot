package me.hyfe.simplespigot.menu.service;

import com.google.common.base.Splitter;
import com.google.common.collect.Sets;
import me.hyfe.simplespigot.menu.Menu;
import me.hyfe.simplespigot.config.Config;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.*;
import java.util.function.BiFunction;

public class MenuService {

    // x -> Standard slot
    // x...y -> all slots between x and y including x and y
    // x...end -> all slots from x to the end of the inventory including x and the end
    // start...x -> opposite from the one above
    // start...end -> all slots from start to end
    // a, b, c, d, e ,f ,g -> just specify multiple slots
    // empty -> all empty slots
    public static Set<Integer> parseSlots(Menu menu, Config config, String id) {
        return parseSlots(menu, config, "", id);
    }

    public static Set<Integer> parseSlots(Menu menu, Config config, String prefix, String id) {
        Stack<Integer> slots = new Stack<>();
        if (StringUtils.isNumeric(id)) {
            return Sets.newHashSet(Integer.parseInt(id));
        }
        String subParse = config.string(String.format("%s.slots", prefix.concat(id))).replace(" ", "");
        Set<Integer> parsedSlots = parseSlots(menu, subParse);
        if (parsedSlots != null) {
            return parsedSlots;
        }
        List<String> commaSplit = Splitter.on(",").omitEmptyStrings().splitToList(subParse);
        if (commaSplit.size() > 0) {
            for (String toParse : commaSplit) {
                if (StringUtils.isNumeric(toParse)) {
                    slots.add(Integer.parseInt(toParse));
                }
                Set<Integer> wrappedParsedSlots = parseSlots(menu, toParse);
                if (wrappedParsedSlots != null) {
                    slots.addAll(wrappedParsedSlots);
                    System.out.println(Arrays.toString(wrappedParsedSlots.toArray()));
                }
            }
            return Sets.newLinkedHashSet(slots);
        }
        return Sets.newHashSet(slots);
    }

    public static Set<Integer> parseSlots(Menu menu, String toParse) {
        BiFunction<Menu, String, String> converter = (fMenu, entry) -> entry.equalsIgnoreCase("end") || entry.equalsIgnoreCase("start") ? Integer.toString(entry.equalsIgnoreCase("end") ? menu.getRows() * 9 - 1 : 0) : entry;
        BiFunction<Menu, Integer, Integer> slotLimiter = (fMenu, slot) -> slot < 0 ? 0 : Math.min(slot, menu.getRows() * 9 - 1);
        Set<Integer> slots = Sets.newLinkedHashSet();
        if (toParse.replace(" ", "").equalsIgnoreCase("fill")) {
            for (int slot = 0; slot < menu.getInventory().getSize(); slot++) {
                ItemStack itemStack = menu.getInventory().getItem(slot);
                if (itemStack == null || itemStack.getType().equals(Material.AIR)) {
                    slots.add(slot);
                }
            }
            return slots;
        }
        List<String> dotSplit = Splitter.on("...").omitEmptyStrings().splitToList(toParse);
        if (dotSplit.size() == 2) {
            String x = converter.apply(menu, dotSplit.get(0));
            String y = converter.apply(menu, dotSplit.get(1));
            if (StringUtils.isNumeric(x) && StringUtils.isNumeric(y)) {
                for (int slot = slotLimiter.apply(menu, Integer.parseInt(x)); slot <= slotLimiter.apply(menu, Integer.parseInt(y)); slot++) {
                    slots.add(slot);
                }
                return slots;
            }
        }
        return null;
    }
}
