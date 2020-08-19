package me.hyfe.simplespigot.text;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.Objects;
import java.util.function.UnaryOperator;

public class Replacer {
    private final Map<String, Object> variables = Maps.newHashMap();

    public static String to(String string, UnaryOperator<Replacer> replacer) {
        return replacer.apply(new Replacer()).applyTo(string);
    }

    public static Replacer of(Map<String, String> placeholderValues) {
        Replacer replacer = new Replacer();
        for (Map.Entry<String, String> entry : placeholderValues.entrySet()) {
            replacer.set(entry.getKey(), entry.getValue());
        }
        return replacer;
    }

    public Replacer set(String variable, Object value) {
        this.variables.put("%" + variable + "%", value);
        return this;
    }

    public String applyTo(String string) {
        String result = string;
        for (Map.Entry<String, Object> entry : this.variables.entrySet()) {
            result = result.replace(entry.getKey(), Objects.toString(entry.getValue()));
        }
        return result;
    }
}