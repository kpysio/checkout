package org.example.business;

import org.example.business.combineOffer.CombineOffer;
import org.example.business.itemOffer.Offer;
import org.example.model.Item;
import org.example.model.PriceMaster;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OfferEngine {

    //OfferEngine now supports BOTH offer types
    private final Map<Item, Offer> offers = new HashMap<Item, Offer>();
    private final List<CombineOffer> combineOffers = new ArrayList<>();

    public void registerOffer(Item item, Offer offer) {
        offers.put(item, offer);
    }

    public void registerCombineOffer(CombineOffer combineOffer){
        combineOffers.add(combineOffer);
    }

    public int applyItemOffer(Item item, int quantity) {
        Offer offer = offers.get(item);
        if (offer == null) return quantity;
        return offer.applyOffer(quantity);
    }

    public int calculateCombineOffer(Map<Item, Integer> quantities, PriceMaster pm){
        return combineOffers.stream()
                .mapToInt(offer -> offer.apply(quantities,pm).savings)
                .sum();
    }
}
