package org.example.business;

import org.example.model.Item;

import java.util.Map;

public class CheckoutResult {
    public final int finalTotal;
    public final int originalTotal;
    public final int totalSavings;
    public final Map<Item, Integer> quantities;
    public final Map<Item, Integer> savingsPerItem;

    public CheckoutResult(int finalTotal, int originalTotal, int totalSavings,
                          Map<Item, Integer> quantities,
                          Map<Item, Integer> savingsPerItem) {
        this.finalTotal = finalTotal;
        this.originalTotal = originalTotal;
        this.totalSavings = totalSavings;
        this.quantities = quantities;
        this.savingsPerItem = savingsPerItem;
    }
}
