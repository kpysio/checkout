package org.example.model;


import org.example.business.combineOffer.BananaAppleOffer;
import org.example.business.combineOffer.CombineOffer;
import org.example.business.combineOffer.CombineOfferResult;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CombineOfferTest {

    @Test
    void singleAppleAndBanana_cheapestIsFree() {
        Item apple = new Item("Apple");
        Item banana = new Item("Banana");

        PriceMaster pm = new PriceMaster();
        pm.setPrice(apple, 50);
        pm.setPrice(banana, 20);

        CombineOffer offer = new BananaAppleOffer(apple, banana);
        Map<Item, Integer> checkoutQuantities = new HashMap();
        checkoutQuantities.put(apple, 1);
        checkoutQuantities.put(banana, 1);

        CombineOfferResult combineOfferResult = offer.apply(checkoutQuantities, pm);

        assertEquals(20, combineOfferResult.savings, "Banana (20p) should be free");
    }

    @Test
    void oneAppleAndOneBanana_cheapestAppleIsFree() {
        Item apple = new Item("Apple");
        Item banana = new Item("Banana");

        PriceMaster pm = new PriceMaster();
        pm.setPrice(apple, 30);
        pm.setPrice(banana, 80);

        CombineOffer offer = new BananaAppleOffer(apple, banana);
        Map<Item, Integer> checkoutQuantities = new HashMap();
        checkoutQuantities.put(apple, 1);
        checkoutQuantities.put(banana, 1);

        CombineOfferResult combineOfferResult = offer.apply(checkoutQuantities, pm);

        assertEquals(30, combineOfferResult.savings, "Apple should be free (cheapest)");
    }

    @Test
    void noComboItems_noDiscount() {
        Item orange = new Item("Orange");
        Item pear = new Item("Pear");

        PriceMaster pm = new PriceMaster();
        pm.setPrice(orange, 30);
        pm.setPrice(pear, 40);

        CombineOffer offer = new BananaAppleOffer(orange, pear);
        Map<Item, Integer> checkoutQuantities = new HashMap();
        checkoutQuantities.put(orange, 1);
        checkoutQuantities.put(pear, 1);

        CombineOfferResult combineOfferResult = offer.apply(checkoutQuantities, pm);

        assertEquals(0, combineOfferResult.savings, "No apples/bananas → no combo discount");
    }
}