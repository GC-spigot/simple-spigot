package me.hyfe.simplespigot.nbt.type;

import lombok.SneakyThrows;
import me.hyfe.simplespigot.nbt.NbtCompound;
import me.hyfe.simplespigot.nbt.enums.ClassWrapper;
import me.hyfe.simplespigot.nbt.enums.ReflectionMethod;
import me.hyfe.simplespigot.version.ServerVersion;

import java.lang.reflect.Constructor;
import java.util.*;

public class NbtStringList implements List<String> {
    private final String name;
    private final NbtCompound parent;
    protected final Object list;

    public NbtStringList(NbtCompound owner, String name, Object list) {
        parent = owner;
        this.name = name;
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public NbtCompound getParent() {
        return parent;
    }

    protected void save() {
        parent.set(this.name, this.list);
    }

    @Override
    public String get(int index) {
        return (String) ReflectionMethod.LIST_GET_STRING.run(this.list, index);
    }

    @SneakyThrows
    protected Object asTag(String object) {
        Constructor<?> constructor = ClassWrapper.NMS_NBTTAGSTRING.getClazz().getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        return constructor.newInstance(object);
    }

    @Override
    public boolean add(String element) {
        if (ServerVersion.getVersion().getVersionId() >= ServerVersion.MC1_14_R1.getVersionId()) {
            ReflectionMethod.LIST_ADD.run(list, size(), asTag(element));
        } else {
            ReflectionMethod.LEGACY_LIST_ADD.run(list, asTag(element));
        }
        this.save();
        return true;
    }

    @Override
    public void add(int index, String element) {
        if (ServerVersion.getVersion().getVersionId() >= ServerVersion.MC1_14_R1.getVersionId()) {
            ReflectionMethod.LIST_ADD.run(this.list, index, asTag(element));
        } else {
            ReflectionMethod.LEGACY_LIST_ADD.run(this.list, asTag(element));
        }
        this.save();
    }

    @Override
    public String set(int index, String element) {
        String previous = this.get(index);
        ReflectionMethod.LIST_SET.run(this.list, index, asTag(element));
        this.save();
        return previous;
    }

    public String remove(int i) {
        String previous = this.get(i);
        ReflectionMethod.LIST_REMOVE_KEY.run(this.list, i);
        this.save();
        return previous;
    }

    public int size() {
        return (int) ReflectionMethod.LIST_SIZE.run(this.list);
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public void clear() {
        while (!this.isEmpty()) {
            this.remove(0);
        }
    }

    @Override
    public boolean contains(Object object) {
        for (int i = 0; i < this.size(); i++) {
            if (object.equals(this.get(i)))
                return true;
        }
        return false;
    }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < this.size(); i++) {
            if (object.equals(this.get(i)))
                return i;
        }
        return -1;
    }

    @Override
    public boolean addAll(Collection<? extends String> collection) {
        int size = this.size();
        for (String string : collection) {
            add(string);
        }
        return size != this.size();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> collection) {
        int size = this.size();
        for (String string : collection) {
            this.add(index++, string);
        }
        return size != this.size();
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        for (Object element : collection) {
            if (!this.contains(element))
                return false;
        }
        return true;
    }

    @Override
    public int lastIndexOf(Object object) {
        int index = -1;
        for (int i = 0; i < this.size(); i++) {
            if (object.equals(this.get(i)))
                index = i;
        }
        return index;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        int size = this.size();
        for (Object element : collection) {
            this.remove(element);
        }
        return size != this.size();
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        int size = this.size();
        for (Object element : collection) {
            for (int i = 0; i < this.size(); i++) {
                if (!element.equals(this.get(i))) {
                    this.remove(i--);
                }
            }
        }
        return size != this.size();
    }

    @Override
    public boolean remove(Object o) {
        int size = this.size();
        int id;
        while ((id = this.indexOf(o)) != -1) {
            this.remove(id);
        }
        return size != this.size();
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = -1;

            @Override
            public boolean hasNext() {
                return size() > this.index + 1;
            }

            @Override
            public String next() {
                if (!this.hasNext())
                    throw new NoSuchElementException();
                return get(++this.index);
            }
        };
    }

    @Override
    public ListIterator<String> listIterator() {
        return listIterator(0);
    }

    @Override
    public ListIterator<String> listIterator(int startIndex) {
        NbtStringList list = this;
        return new ListIterator<String>() {
            int index = startIndex - 1;

            @Override
            public void add(String e) {
                list.add(index, e);
            }

            @Override
            public boolean hasNext() {
                return size() > index + 1;
            }

            @Override
            public boolean hasPrevious() {
                return index >= 0 && index <= size();
            }

            @Override
            public String next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                return get(++index);
            }

            @Override
            public int nextIndex() {
                return index + 1;
            }

            @Override
            public String previous() {
                if (!hasPrevious())
                    throw new NoSuchElementException("Id: " + (index - 1));
                return get(index--);
            }

            @Override
            public int previousIndex() {
                return index - 1;
            }

            @Override
            public void remove() {
                list.remove(index);
            }

            @Override
            public void set(String e) {
                list.set(index, e);
            }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[this.size()];
        for (int i = 0; i < this.size(); i++) {
            array[i] = this.get(i);
        }
        return array;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <E> E[] toArray(E[] a) {
        E[] ar = Arrays.copyOf(a, size());
        Arrays.fill(ar, null);
        Class<?> arrayclass = a.getClass().getComponentType();
        for (int i = 0; i < size(); i++) {
            String obj = get(i);
            if (arrayclass.isInstance(obj)) {
                ar[i] = (E) get(i);
            } else {
                throw new ArrayStoreException("The array does not match the objects stored in the List.");
            }
        }
        return ar;
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = fromIndex; i < toIndex; i++)
            list.add(get(i));
        return list;
    }

    @Override
    public String toString() {
        return list.toString();
    }
}