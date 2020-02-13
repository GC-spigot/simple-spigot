package me.hyfe.simplespigot.nbt;

import me.hyfe.simplespigot.nbt.enums.NbtType;
import me.hyfe.simplespigot.nbt.enums.ReflectionMethod;
import me.hyfe.simplespigot.nbt.type.NbtItem;
import me.hyfe.simplespigot.nbt.type.NbtStringList;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;
import java.util.Set;

public class NbtCompound {
    private String name;
    private NbtCompound parent;

    protected NbtCompound(NbtCompound owner, String name) {
        this.name = name;
        this.parent = owner;
    }

    protected void saveCompound() {
        if (Objects.nonNull(this.parent)) {
            this.parent.saveCompound();
        }
    }

    public String getName() {
        return this.name;
    }

    public Object getCompound() {
        return this.parent.getCompound();
    }

    protected void setCompound(Object compound) {
        this.parent.setCompound(compound);
    }

    public NbtCompound getParent() {
        return this.parent;
    }

    public void mergeCompound(NbtCompound comp) {
        NbtReflector.mergeOtherNbtCompound(this, comp);
        this.saveCompound();
    }

    public void setString(String key, String value) {
        NbtReflector.setData(this, ReflectionMethod.COMPOUND_SET_STRING, key, value);
        this.saveCompound();
    }

    public String getString(String key) {
        return (String) NbtReflector.getData(this, ReflectionMethod.COMPOUND_GET_STRING, key);
    }

    protected String getContent(String key) {
        return NbtReflector.getContent(this, key);
    }

    public void setInteger(String key, Integer value) {
        NbtReflector.setData(this, ReflectionMethod.COMPOUND_SET_INT, key, value);
        this.saveCompound();
    }

    public Integer getInteger(String key) {
        return (Integer) NbtReflector.getData(this, ReflectionMethod.COMPOUND_GET_INT, key);
    }

    public void setDouble(String key, Double value) {
        NbtReflector.setData(this, ReflectionMethod.COMPOUND_SET_DOUBLE, key, value);
        this.saveCompound();
    }

    public Double getDouble(String key) {
        return (Double) NbtReflector.getData(this, ReflectionMethod.COMPOUND_GET_DOUBLE, key);
    }

    public void setByte(String key, Byte value) {
        NbtReflector.setData(this, ReflectionMethod.COMPOUND_SET_BYTE, key, value);
        this.saveCompound();
    }

    public Byte getByte(String key) {
        return (Byte) NbtReflector.getData(this, ReflectionMethod.COMPOUND_GET_BYTE, key);
    }

    public void setShort(String key, Short value) {
        NbtReflector.setData(this, ReflectionMethod.COMPOUND_SET_SHORT, key, value);
        this.saveCompound();
    }

    public Short getShort(String key) {
        return (Short) NbtReflector.getData(this, ReflectionMethod.COMPOUND_GET_SHORT, key);
    }

    public void setLong(String key, Long value) {
        NbtReflector.setData(this, ReflectionMethod.COMPOUND_SET_LONG, key, value);
        this.saveCompound();
    }

    public Long getLong(String key) {
        return (Long) NbtReflector.getData(this, ReflectionMethod.COMPOUND_GET_LONG, key);
    }

    public void setFloat(String key, Float value) {
        NbtReflector.setData(this, ReflectionMethod.COMPOUND_SET_FLOAT, key, value);
        saveCompound();
    }

    public Float getFloat(String key) {
        return (Float) NbtReflector.getData(this, ReflectionMethod.COMPOUND_GET_FLOAT, key);
    }

    public void setByteArray(String key, byte[] value) {
        NbtReflector.setData(this, ReflectionMethod.COMPOUND_SET_BYTEARRAY, key, value);
        this.saveCompound();
    }

    public byte[] getByteArray(String key) {
        return (byte[]) NbtReflector.getData(this, ReflectionMethod.COMPOUND_GET_BYTEARRAY, key);
    }

    public void setIntArray(String key, int[] value) {
        NbtReflector.setData(this, ReflectionMethod.COMPOUND_SET_INTARRAY, key, value);
        this.saveCompound();
    }

    public int[] getIntArray(String key) {
        return (int[]) NbtReflector.getData(this, ReflectionMethod.COMPOUND_GET_INTARRAY, key);
    }

    public void setBoolean(String key, Boolean value) {
        NbtReflector.setData(this, ReflectionMethod.COMPOUND_SET_BOOLEAN, key, value);
        this.saveCompound();
    }

    public void set(String key, Object val) {
        NbtReflector.set(this, key, val);
        this.saveCompound();
    }

    public Boolean getBoolean(String key) {
        return (Boolean) NbtReflector.getData(this, ReflectionMethod.COMPOUND_GET_BOOLEAN, key);
    }

    public void setObject(String key, Object value) {
        NbtReflector.setObject(this, key, value);
        this.saveCompound();
    }

    public <T> T getObject(String key, Class<T> type) {
        return NbtReflector.getObject(this, key, type);
    }

    public void setItemStack(String key, ItemStack item) {
        this.removeKey(key);
        this.addCompound(key).mergeCompound(NbtItem.convertItemToNbt(item));
    }

    public ItemStack getItemStack(String key) {
        return NbtItem.convertNbtToItem(this.getCompound(key));
    }

    public boolean hasKey(String key) {
        Boolean bool = (Boolean) NbtReflector.getData(this, ReflectionMethod.COMPOUND_HAS_KEY, key);
        return bool == null ? false : bool;
    }

    public void removeKey(String key) {
        NbtReflector.remove(this, key);
        this.saveCompound();
    }

    public Set<String> getKeys() {
        return NbtReflector.getKeys(this);
    }

    public NbtCompound addCompound(String name) {
        if (this.getType(name).equals(NbtType.NBTTagCompound)) {
            return this.getCompound(name);
        }
        NbtReflector.addNbtTagCompound(this, name);
        NbtCompound compound = this.getCompound(name);
        this.saveCompound();
        return compound;
    }

    public NbtCompound getCompound(String name) {
        if (!this.getType(name).equals(NbtType.NBTTagCompound)) {
            return null;
        }
        NbtCompound next = new NbtCompound(this, name);
        if (NbtReflector.validateCompound(next)) {
            return next;
        }
        return null;
    }

    public NbtStringList getStringList(String name) {
        NbtStringList list = NbtReflector.getList(this, name);
        this.saveCompound();
        return list;
    }

    public NbtType getType(String name) {
        Object object = NbtReflector.getData(this, ReflectionMethod.COMPOUND_GET_TYPE, name);
        return object == null ? null : NbtType.parse((byte) object);
    }
}