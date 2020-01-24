package me.javadebug.simplespigot.text.json;

import org.apache.commons.lang.Validate;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

public class ArrayWrapper<E> {
    private E[] elements;

    public ArrayWrapper(E... elements) {
        this.setArray(elements);
    }

    public E[] getArray() {
        return this.elements;
    }

    public void setArray(E[] array) {
        Validate.notNull(array, "The array must not be null.");
        this.elements = array;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof ArrayWrapper)) {
            return false;
        }
        return Arrays.equals(this.elements, ((ArrayWrapper) other).elements);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(this.elements);
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] toArray(Iterable<? extends T> list, Class<T> c) {
        int size = -1;
        if (list instanceof Collection<?>) {
            Collection<?> coll = (Collection<?>) list;
            size = coll.size();
        }


        if (size < 0) {
            size = 0;
            for (@SuppressWarnings("unused") T element : list) {
                size++;
            }
        }

        T[] result = (T[]) Array.newInstance(c, size);
        int i = 0;
        for (T element : list) {
            result[i++] = element;
        }
        return result;
    }
}