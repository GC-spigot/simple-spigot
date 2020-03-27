package me.hyfe.simplespigot.nbt.enums;

public enum NbtType {
    NBTTagEnd(0),
    NBTTagByte(1),
    NBTTagShort(2),
    NBTTagInt(3),
    NBTTagLong(4),
    NBTTagFloat(5),
    NBTTagDouble(6),
    NBTTagByteArray(7),
    NBTTagIntArray(11),
    NBTTagString(8),
    NBTTagCompound(10);

    private final int id;

    NbtType(int id) {
        this.id = id;
    }

    /**
     * @param id Internal Minecraft id
     * @return Enum representing the id, NBTTagEnd for invalid ids
     */
    public static NbtType parse(int id) {
        for (NbtType type : values()) {
            if (type.getId() == id) {
                return type;
            }
        }
        return NbtType.NBTTagEnd;
    }

    /**
     * @return Id used by Minecraft internally
     */
    public int getId() {
        return id;
    }
}