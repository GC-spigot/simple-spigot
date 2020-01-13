package me.javadebug.simplespigot.json;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class Token<T> {

    public Type type() {
        return new TypeToken<T>(){}.getType();
    }
}
