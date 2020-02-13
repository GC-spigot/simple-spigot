package me.hyfe.simplespigot.pipeline;

public interface Step<T, R> {

    R process(T type);
}
