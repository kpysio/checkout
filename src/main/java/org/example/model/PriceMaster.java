package org.example.model;

import java.util.HashMap;
import java.util.Map;

public class PriceMaster {
    private final Map<Item, Integer> prices = new HashMap<Item, Integer>();

    public void setPrice(Item item, int priceInPence) {
        prices.put(item, priceInPence);
    }

    public int getPrice(Item item) {
        return prices.get(item);
    }
}
