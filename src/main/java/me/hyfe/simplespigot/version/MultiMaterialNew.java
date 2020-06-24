package me.hyfe.simplespigot.version;

import com.google.common.collect.Sets;

import java.util.Set;

public enum  MultiMaterialNew {

    WHEAT(Entry.of("CROPS", 1, 2, 3, 4, 5, 6, 7), Entry.of("WHEAT"));

    private final Set<Entry> entries;

    MultiMaterialNew(Entry... entries) {
        this.entries = Sets.newHashSet(entries);
    }

    public static MultiMaterialNew parseString(String string) {
        return null;
    }

    public static MultiMaterialNew parse(String name, int data) {
        if (data > 0) {
            return find(name, data);
        }
        try {
            return valueOf(name);
        } catch (Exception ex) {
            return find(name, data);
        }
    }

    private static MultiMaterialNew find(String name, int data) {
        for (MultiMaterialNew multiMaterial : values()) {
            for (Entry entry : multiMaterial.entries) {
                if (entry.matches(name, data)) {
                    return multiMaterial;
                }
            }
        }
        return null;
    }

    public static class Entry {
        private final String name;
        private final Set<Integer> data;

        public Entry(String name, Set<Integer> data) {
            this.name = name;
            this.data = data;
        }

        public static Entry of(String name, Integer... datas) {
            return new Entry(name, Sets.newHashSet(datas));
        }

        public static Entry of(String name) {
            return new Entry(name, Sets.newHashSet(0));
        }

        public boolean matches(String name, int data) {
            return this.name.equalsIgnoreCase(name) && this.data.contains(data);
        }
    }
}
