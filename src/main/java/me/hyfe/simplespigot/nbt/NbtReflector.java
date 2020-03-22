package me.hyfe.simplespigot.nbt;

import com.google.gson.Gson;
import lombok.SneakyThrows;
import me.hyfe.simplespigot.nbt.enums.ClassWrapper;
import me.hyfe.simplespigot.nbt.enums.ObjectCreator;
import me.hyfe.simplespigot.nbt.enums.ReflectionMethod;
import me.hyfe.simplespigot.nbt.type.NbtContainer;
import me.hyfe.simplespigot.nbt.type.NbtStringList;
import me.hyfe.simplespigot.version.ServerVersion;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.Set;

public class NbtReflector {

    public static Object readNbtFile(FileInputStream stream) {
        return ReflectionMethod.NBTFILE_READ.run(null, stream);
    }

    public static Object saveNbtFile(Object nbt, FileOutputStream stream) {
        return ReflectionMethod.NBTFILE_WRITE.run(null, nbt, stream);
    }

    public static Object getItemRootNbtTagCompound(Object nmsItem) {
        Object answer = ReflectionMethod.NMSITEM_GETTAG.run(nmsItem);
        return answer != null ? answer : ObjectCreator.NMS_NBTTAGCOMPOUND.getInstance();
    }

    public static Object convertNbtCompoundToNmsItem(NbtCompound nbtCompound) {
        Object nmsComp = getToCompound(nbtCompound.getCompound(), nbtCompound);
        if (ServerVersion.getVersion().getVersionId() >= ServerVersion.MC1_11_R1.getVersionId()) {
            return ObjectCreator.NMS_COMPOUNDFROMITEM.getInstance(nmsComp);
        } else {
            return ReflectionMethod.NMSITEM_CREATESTACK.run(null, nmsComp);
        }
    }

    public static NbtContainer convertNmsItemToNbtCompound(Object nmsItem) {
        Object answer = ReflectionMethod.NMSITEM_SAVE.run(nmsItem, ObjectCreator.NMS_NBTTAGCOMPOUND.getInstance());
        return new NbtContainer(answer);
    }

    public static Object getSubNbtTagCompound(Object compound, String name) {
        return (boolean) ReflectionMethod.COMPOUND_HAS_KEY.run(compound, name) ? ReflectionMethod.COMPOUND_GET_COMPOUND.run(compound, name) : null;
    }

    @SneakyThrows
    public static void addNbtTagCompound(NbtCompound compound, String name) {
        if (name == null) {
            remove(compound, name);
            return;
        }
        Object nbttag = compound.getCompound();
        if (nbttag == null) {
            nbttag = ObjectCreator.NMS_NBTTAGCOMPOUND.getInstance();
        }
        if (!validateCompound(compound)) {
            return;
        }
        Object workingTag = getToCompound(nbttag, compound);
        ReflectionMethod.COMPOUND_SET.run(workingTag, name, ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz().newInstance());
        compound.setCompound(nbttag);
    }

    public static boolean validateCompound(NbtCompound comp) {
        Object root = comp.getCompound();
        if (root == null) {
            root = ObjectCreator.NMS_NBTTAGCOMPOUND.getInstance();
        }
        return (getToCompound(root, comp)) != null;
    }

    protected static Object getToCompound(Object nbttag, NbtCompound comp) {
        Deque<String> structure = new ArrayDeque<>();
        while (comp.getParent() != null) {
            structure.add(comp.getName());
            comp = comp.getParent();
        }
        while (!structure.isEmpty()) {
            String target = structure.pollLast();
            nbttag = getSubNbtTagCompound(nbttag, target);
        }
        return nbttag;
    }

    public static void mergeOtherNbtCompound(NbtCompound comp, NbtCompound NbtCompound) {
        Object rootnbttag = comp.getCompound();
        if (rootnbttag == null) {
            rootnbttag = ObjectCreator.NMS_NBTTAGCOMPOUND.getInstance();
        }
        Object workingTag = getToCompound(rootnbttag, comp);
        ReflectionMethod.COMPOUND_MERGE.run(workingTag, NbtCompound.getCompound());
        comp.setCompound(rootnbttag);
    }

    public static String getContent(NbtCompound comp, String key) {
        Object rootnbttag = comp.getCompound();
        if (rootnbttag == null) {
            rootnbttag = ObjectCreator.NMS_NBTTAGCOMPOUND.getInstance();
        }
        Object workingTag = getToCompound(rootnbttag, comp);
        return Objects.requireNonNull(ReflectionMethod.COMPOUND_GET.run(workingTag, key)).toString();
    }

    public static void set(NbtCompound comp, String key, Object val) {
        if (val == null) {
            remove(comp, key);
            return;
        }
        Object rootnbttag = comp.getCompound();
        if (rootnbttag == null) {
            rootnbttag = ObjectCreator.NMS_NBTTAGCOMPOUND.getInstance();
        }
        Object workingTag = getToCompound(rootnbttag, comp);
        ReflectionMethod.COMPOUND_SET.run(workingTag, key, val);
        comp.setCompound(rootnbttag);
    }

    public static NbtStringList getList(NbtCompound comp, String key) {
        Object rootnbttag = comp.getCompound();
        if (rootnbttag == null) {
            rootnbttag = ObjectCreator.NMS_NBTTAGCOMPOUND.getInstance();
        }
        if (!validateCompound(comp))
            return null;
        Object workingTag = getToCompound(rootnbttag, comp);
        return new NbtStringList(comp, key, ReflectionMethod.COMPOUND_GET_LIST.run(workingTag, key, 8));
    }

    public static void setObject(NbtCompound comp, String key, Object value) {
        setData(comp, ReflectionMethod.COMPOUND_SET_STRING, key, new Gson().toJson(value));
    }

    public static <T> T getObject(NbtCompound comp, String key, Class<T> type) {
        String json = (String) getData(comp, ReflectionMethod.COMPOUND_GET_STRING, key);
        if (json == null) {
            return null;
        }
        return new Gson().fromJson(json, type);
    }

    public static void remove(NbtCompound comp, String key) {
        Object rootnbttag = comp.getCompound();
        if (rootnbttag == null) {
            rootnbttag = ObjectCreator.NMS_NBTTAGCOMPOUND.getInstance();
        }
        if (!validateCompound(comp))
            return;
        Object workingTag = getToCompound(rootnbttag, comp);
        ReflectionMethod.COMPOUND_REMOVE_KEY.run(workingTag, key);
        comp.setCompound(rootnbttag);
    }

    @SuppressWarnings("unchecked")
    public static Set<String> getKeys(NbtCompound comp) {
        Object rootnbttag = comp.getCompound();
        if (rootnbttag == null) {
            rootnbttag = ObjectCreator.NMS_NBTTAGCOMPOUND.getInstance();
        }
        Object workingTag = getToCompound(rootnbttag, comp);
        return (Set<String>) ReflectionMethod.COMPOUND_GET_KEYS.run(workingTag);
    }

    public static void setData(NbtCompound comp, ReflectionMethod type, String key, Object data) {
        if (data == null) {
            remove(comp, key);
            return;
        }
        Object rootnbttag = comp.getCompound();
        if (rootnbttag == null) {
            rootnbttag = ObjectCreator.NMS_NBTTAGCOMPOUND.getInstance();
        }
        Object workingTag = getToCompound(rootnbttag, comp);
        type.run(workingTag, key, data);
        comp.setCompound(rootnbttag);
    }

    public static Object getData(NbtCompound comp, ReflectionMethod type, String key) {
        Object rootnbttag = comp.getCompound();
        if (rootnbttag == null) {
            return null;
        }
        Object workingTag = getToCompound(rootnbttag, comp);
        return type.run(workingTag, key);
    }
}