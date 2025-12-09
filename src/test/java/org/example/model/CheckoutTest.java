package org.example.model;

import org.example.business.itemOffer.BuyOneGetOneFreeOffer;
import org.example.business.OfferEngine;
import org.example.business.itemOffer.ThreeForTwoOffer;
import org.example.shop.Checkout;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class CheckoutTest {

    @Test
    void testCheckoutWithOffers() {
        // Masters
        ItemMaster itemMaster = new ItemMaster();
        PriceMaster priceMaster = new PriceMaster();
        OfferEngine offerEngine = new OfferEngine();

        // Items
        Item apple = new Item("Apple");
        Item orange = new Item("Orange");
        Item banana = new Item("Banana");

        itemMaster.registerItem("Apple", apple);
        itemMaster.registerItem("Orange", orange);
        itemMaster.registerItem("Banana", banana);

        priceMaster.setPrice(apple, 60);
        priceMaster.setPrice(orange, 25);
        priceMaster.setPrice(banana, 40);

        offerEngine.registerOffer(apple, new BuyOneGetOneFreeOffer());
        offerEngine.registerOffer(orange, new ThreeForTwoOffer());

        Checkout checkout = new Checkout(itemMaster, priceMaster, offerEngine);

        List<String> basket = Arrays.asList("Apple", "Apple", "Orange", "Orange", "Orange", "Banana", "Banana");

        int calculateTotal = checkout.calculateTotal(basket);

        assertEquals(1 * 60 + 2 * 25 + 2 * 40, calculateTotal); // discounted total

    }
}
