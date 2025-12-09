package org.example.shop;

import org.example.business.OfferEngine;
import org.example.model.Item;
import org.example.model.ItemMaster;
import org.example.model.PriceMaster;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Checkout {

    private final ItemMaster itemMaster;
    private final PriceMaster priceMaster;
    private final OfferEngine offerEngine;


    public Checkout(ItemMaster im, PriceMaster pm, OfferEngine oe) {
        this.itemMaster = im;
        this.priceMaster = pm;
        this.offerEngine = oe;
    }

    public int calculateTotal(List<String> scannedItems) {

        // Count by item
        Map<Item, Long> counts = scannedItems
                .stream()
                .map(itemMaster::getItem)
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));

        Map<Item, Integer> intCounts = counts.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().intValue()));


        int total = 0;

        for (Map.Entry<Item, Long> entry : counts.entrySet()) {
            Item item = entry.getKey();
            int quantity = entry.getValue().intValue();

            int discountedQty = offerEngine.applyItemOffer(item, quantity);
            int price = priceMaster.getPrice(item);

            total += discountedQty * price;
        }

        // combine Saving

        int calculateCombineOffer = offerEngine.calculateCombineOffer(intCounts, priceMaster);

        int finalTotal = total - calculateCombineOffer;

        return finalTotal;
    }

    public static String formatPrice(int pence) {
        return String.format("£%.2f", pence / 100.0);
    }
}
