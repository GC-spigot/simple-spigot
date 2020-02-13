package me.hyfe.simplespigot.nbt.type;

import me.hyfe.simplespigot.nbt.NbtCompound;
import me.hyfe.simplespigot.nbt.enums.ObjectCreator;
import me.hyfe.simplespigot.nbt.enums.ReflectionMethod;

public class NbtContainer extends NbtCompound {
    private Object nbt;

    public NbtContainer() {
        super(null, null);
        this.nbt = ObjectCreator.NMS_NBTTAGCOMPOUND.getInstance();
    }

    public NbtContainer(Object nbt) {
        super(null, null);
        this.nbt = nbt;
    }

    public NbtContainer(String nbtString) {
        super(null, null);
        this.nbt = ReflectionMethod.PARSE_NBT.run(null, nbtString);
    }

    @Override
    public Object getCompound() {
        return this.nbt;
    }

    @Override
    public void setCompound(Object tag) {
        this.nbt = tag;
    }

}