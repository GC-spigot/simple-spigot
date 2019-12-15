package me.javadebug.simplespigot.service;

import lombok.SneakyThrows;

public class ClassReflector<T> {
    private Class<T> clazz;
    private Class<?>[] parameterTypes;

    public ClassReflector(Class<T> clazz) {
        this.clazz = clazz;
        this.parameterTypes = null;
    }

    public ClassReflector<T> constructor(Class<?>... parameterTypes) {
        this.parameterTypes = parameterTypes;
        return this;
    }

    @SneakyThrows
    public T fillParameters(Object... args) {
        return this.clazz.getConstructor(this.parameterTypes).newInstance(args);
    }
}
