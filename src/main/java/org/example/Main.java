package org.example;

import org.example.business.BuyOneGetOneFreeOffer;
import org.example.business.OfferEngine;
import org.example.business.ThreeForTwoOffer;
import org.example.model.Item;
import org.example.model.ItemMaster;
import org.example.model.PriceMaster;
import org.example.shop.Checkout;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Masters
        ItemMaster itemMaster = new ItemMaster();
        PriceMaster priceMaster = new PriceMaster();
        OfferEngine offerEngine = new OfferEngine();

        // Items
        Item apple = new Item("Apple");
        Item orange = new Item("Orange");

        itemMaster.registerItem("Apple", apple);
        itemMaster.registerItem("Orange", orange);

        // Prices
        priceMaster.setPrice(apple, 60);
        priceMaster.setPrice(orange, 25);

        // Offers
        offerEngine.registerOffer(apple, new BuyOneGetOneFreeOffer());
        offerEngine.registerOffer(orange, new ThreeForTwoOffer());

        // Checkout
        Checkout checkout = new Checkout(itemMaster, priceMaster, offerEngine);

        List<String> items = Arrays.asList("Apple", "Apple", "Orange", "Apple");
        int total = checkout.calculateTotal(items);

        System.out.println(Checkout.formatPrice(total)); // should print £1.45
    }
}
