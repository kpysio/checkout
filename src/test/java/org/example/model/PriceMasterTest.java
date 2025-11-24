package org.example.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PriceMasterTest {

    @Test
    void testSetAndGetPrice() {
        Item apple = new Item("Apple");
        PriceMaster pm = new PriceMaster();

        pm.setPrice(apple, 60);

        assertEquals(60, pm.getPrice(apple));
    }
}
