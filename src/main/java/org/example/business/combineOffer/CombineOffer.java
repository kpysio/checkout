package org.example.business.combineOffer;

import org.example.model.Item;
import org.example.model.PriceMaster;

import java.util.Map;

public interface CombineOffer {
    CombineOfferResult apply(Map<Item, Integer> quantities, PriceMaster pm);
}
