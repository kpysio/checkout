package org.example.model;

import java.util.HashMap;
import java.util.Map;

public class ItemMaster {
    private final Map<String, Item> items = new HashMap<String, Item>();

    public void registerItem(String name, Item item) {
        items.put(name.toLowerCase(), item);
    }

    public Item getItem(String name) {
        return items.get(name.toLowerCase());
    }
}
