package org.example.business.combineOffer;

import org.example.model.Item;
import org.example.model.PriceMaster;

import java.util.Map;

public class BananaAppleOffer implements CombineOffer {

    private Item apple;
    private Item banana;

    public BananaAppleOffer(Item apple, Item banana){
        if(apple.getName().equalsIgnoreCase("apple") && banana.getName().equalsIgnoreCase("banana")) {
            this.apple = apple;
            this.banana = banana;
        }
    }

    @Override
    public CombineOfferResult apply(Map<Item, Integer> quantities, PriceMaster pm) {

        Integer appleQuantities = quantities.getOrDefault(apple,0);
        Integer bananaQuantities = quantities.getOrDefault(banana,0);

        if(appleQuantities ==0 || bananaQuantities==0){
         return new CombineOfferResult(0);
        }

        // Find the minimum item quantity
        int minQuantities = Math.min(appleQuantities, bananaQuantities);
        // Find the cheapest price
        int bananaPrice = pm.getPrice(banana);
        int applePrice = pm.getPrice(apple);
        int cheapPrice = Math.min(applePrice, bananaPrice);

        int saving = minQuantities * cheapPrice;

        return new CombineOfferResult(saving);
    }
}
