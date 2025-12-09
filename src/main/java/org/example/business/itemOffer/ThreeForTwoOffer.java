package org.example.business.itemOffer;

import org.example.business.itemOffer.Offer;

public class ThreeForTwoOffer implements Offer {

    public int applyOffer(int quantity) {
        return (quantity / 3) * 2 + (quantity % 3);
    }
}
