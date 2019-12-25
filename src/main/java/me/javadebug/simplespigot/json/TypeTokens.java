package me.javadebug.simplespigot.json;

import java.lang.reflect.Type;

public class TypeTokens {

    public static <T> Type toType() {
        return new com.google.gson.reflect.TypeToken<T>(){}.getType();
    }
}
