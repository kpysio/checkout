package org.example.model;

import org.example.business.Offer;
import org.example.business.ThreeForTwoOffer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ThreeForTwoOfferTest {

    @Test
    void testThreeForTwoExact() {
        Offer offer = new ThreeForTwoOffer();
        assertEquals(2, offer.applyOffer(3));
    }

    @Test
    void testFourItems() {
        Offer offer = new ThreeForTwoOffer();
        assertEquals(3, offer.applyOffer(4));
    }

    @Test
    void testSixItems() {
        Offer offer = new ThreeForTwoOffer();
        assertEquals(4, offer.applyOffer(6));
    }

}
