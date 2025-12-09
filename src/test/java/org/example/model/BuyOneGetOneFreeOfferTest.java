package org.example.model;

import org.example.business.itemOffer.BuyOneGetOneFreeOffer;
import org.example.business.itemOffer.Offer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BuyOneGetOneFreeOfferTest {

    @Test
    void testBOGOOfferOddNumber() {
        Offer offer = new BuyOneGetOneFreeOffer();
        assertEquals(2, offer.applyOffer(3)); // Pay for 2 of 3
    }

    @Test
    void testBOGOOfferEvenNumber() {
        Offer offer = new BuyOneGetOneFreeOffer();
        assertEquals(2, offer.applyOffer(4)); // Pay for 2 of 4
    }

}
