package me.hyfe.simplespigot.nbt.type;

import me.hyfe.simplespigot.nbt.NbtCompound;
import me.hyfe.simplespigot.nbt.NbtReflector;
import me.hyfe.simplespigot.nbt.enums.ReflectionMethod;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class NbtItem extends NbtCompound {
    private ItemStack itemStack;

    public NbtItem(ItemStack itemStack) {
        super(null, null);
        this.itemStack = itemStack.clone();
    }

    @Override
    public Object getCompound() {
        return NbtReflector.getItemRootNbtTagCompound(ReflectionMethod.ITEMSTACK_NMSCOPY.run(null, this.itemStack));
    }

    @Override
    protected void setCompound(Object compound) {
        Object stack = ReflectionMethod.ITEMSTACK_NMSCOPY.run(null, this.itemStack);
        ReflectionMethod.ITEMSTACK_SET_TAG.run(stack, compound);
        this.itemStack = (ItemStack) ReflectionMethod.ITEMSTACK_BUKKITMIRROR.run(null, stack);
    }

    public ItemStack getItem() {
        return this.itemStack;
    }

    public boolean hasNBTData() {
        return Objects.nonNull(this.getCompound());
    }

    public static NbtContainer convertItemToNbt(ItemStack item) {
        return NbtReflector.convertNmsItemToNbtCompound(ReflectionMethod.ITEMSTACK_NMSCOPY.run(null, item));
    }

    public static ItemStack convertNbtToItem(NbtCompound compound) {
        return (ItemStack) ReflectionMethod.ITEMSTACK_BUKKITMIRROR.run(null, NbtReflector.convertNbtCompoundToNmsItem(compound));
    }
}