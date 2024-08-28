package com.magasin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MagasinTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
        assertEquals(0, app.items[0].quality);
        assertEquals(0, app.items[0].sellIn);
    }


    @Test
    void comteTest() {
        Item[] items = new Item[] { new Item("Comté", 8, 16)};
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals("Comté", app.items[0].name);
        assertEquals(7, app.items[0].sellIn);
        assertEquals(16,app.items[0].quality);

    }

    @Test
    void comtePerimeTest() {
        Item[] items = new Item[] { new Item("Comté", -2, 16)};
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals("Comté", app.items[0].name);
        assertEquals(-3, app.items[0].sellIn);
        assertEquals(18,app.items[0].quality);

    }

    @Test
    void vipTest() {
        Item[] items = new Item[] { new Item("Pass VIP Concert", 0, 16)};
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals("Pass VIP Concert", app.items[0].name);
        assertEquals(0, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

}
