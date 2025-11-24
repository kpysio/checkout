package org.example.business;

import org.example.model.Item;

import java.util.HashMap;
import java.util.Map;

public class OfferEngine {

    private final Map<Item, Offer> offers = new HashMap<Item, Offer>();

    public void registerOffer(Item item, Offer offer) {
        offers.put(item, offer);
    }

    public int apply(Item item, int quantity) {
        Offer offer = offers.get(item);
        if (offer == null) return quantity;
        return offer.applyOffer(quantity);
    }
}
