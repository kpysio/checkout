package org.example;

import org.example.business.combineOffer.BananaAppleOffer;
import org.example.business.itemOffer.BuyOneGetOneFreeOffer;
import org.example.business.OfferEngine;
import org.example.business.itemOffer.ThreeForTwoOffer;
import org.example.model.Item;
import org.example.model.ItemMaster;
import org.example.model.PriceMaster;
import org.example.shop.Checkout;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> items = Arrays.asList("Apple", "Apple", "Orange", "Apple", "Banana", "Banana");
        int total1 = RunBuyOneGetOneFree(items);
        // should print £1.45
        System.out.println(Checkout.formatPrice(total1));

        List<String> appleBananaItems = Arrays.asList("Apple", "Apple", "Banana", "Banana");
        int total2 = RunAppleBananaCheapestFree(appleBananaItems);
        // should print £1.20, banana is free
        System.out.println(Checkout.formatPrice(total2));
    }

    private static int RunBuyOneGetOneFree(List<String> items) {
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

        // Prices
        priceMaster.setPrice(apple, 60);
        priceMaster.setPrice(orange, 25);
        priceMaster.setPrice(banana, 20);

        // Offers
        offerEngine.registerOffer(apple, new BuyOneGetOneFreeOffer());
        offerEngine.registerOffer(orange, new ThreeForTwoOffer());
        offerEngine.registerOffer(banana, new BuyOneGetOneFreeOffer());
        offerEngine.registerCombineOffer( new BananaAppleOffer(apple, banana));

        // Checkout
        Checkout checkout = new Checkout(itemMaster, priceMaster, offerEngine);


        int total = checkout.calculateTotal(items);
        return total;
    }

    private static int RunAppleBananaCheapestFree(List<String> items) {
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

        // Prices
        priceMaster.setPrice(apple, 60);
        priceMaster.setPrice(orange, 25);
        priceMaster.setPrice(banana, 20);

        // Offers
        offerEngine.registerCombineOffer( new BananaAppleOffer(apple, banana));

        // Checkout
        Checkout checkout = new Checkout(itemMaster, priceMaster, offerEngine);

        int total = checkout.calculateTotal(items);

        return total;
    }
}
