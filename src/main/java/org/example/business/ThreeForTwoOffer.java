package org.example.business;

import org.example.business.Offer;

public class ThreeForTwoOffer implements Offer {

    public int applyOffer(int quantity) {
        return (quantity / 3) * 2 + (quantity % 3);
    }
}
