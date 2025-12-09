package org.example.business.itemOffer;

public class BuyOneGetOneFreeOffer implements Offer {

    public int applyOffer(int quantity) {
        return (quantity / 2) + (quantity % 2);
    }
}
