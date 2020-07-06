package me.hyfe.simplespigot.json;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class TypeTokens {

    public static <T> Type findType() {
        return new TypeToken<T>() {
        }.getType();
    }
}
