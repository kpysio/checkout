package org.example.model;

import org.example.business.OfferEngine;
import org.example.business.itemOffer.ThreeForTwoOffer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OfferEngineTest {

    @Test
    void testOfferApplied() {
        Item orange = new Item("Orange");
        OfferEngine engine = new OfferEngine();

        engine.registerOffer(orange, new ThreeForTwoOffer());

        assertEquals(2, engine.applyItemOffer(orange, 3));
    }

    @Test
    void testNoOffer() {
        Item banana = new Item("Banana");
        OfferEngine engine = new OfferEngine();

        assertEquals(5, engine.applyItemOffer(banana, 5)); // No offer → unchanged
    }
}
