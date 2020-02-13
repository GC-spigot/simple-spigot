package me.hyfe.simplespigot.menu.item.click;

import org.bukkit.event.inventory.InventoryAction;

public enum ClickType {

    LEFT,
    SHIFT_LEFT,
    RIGHT,
    DROP,
    MIDDLE_MB,
    OTHER;

    public static ClickType parse(InventoryAction inventoryAction) {
        switch (inventoryAction) {
            case PICKUP_ALL:
            case PLACE_ALL:
            case PLACE_SOME:
            case SWAP_WITH_CURSOR: {
                return ClickType.LEFT;
            }
            case PICKUP_HALF:
            case PLACE_ONE: {
                return ClickType.RIGHT;
            }
            case MOVE_TO_OTHER_INVENTORY: {
                return ClickType.SHIFT_LEFT;
            }
            case DROP_ALL_CURSOR:
            case DROP_ALL_SLOT:
            case DROP_ONE_CURSOR:
            case DROP_ONE_SLOT: {
                return ClickType.DROP;
            }
            case CLONE_STACK: {
                return ClickType.MIDDLE_MB;
            }

            default: {
                return ClickType.OTHER;
            }
        }
    }
}