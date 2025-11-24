package org.example.business;

public class BuyOneGetOneFreeOffer implements Offer {

    public int applyOffer(int quantity) {
        return (quantity / 2) + (quantity % 2);
    }
}
