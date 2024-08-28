package com.magasin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MagasinTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 5, 10) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(9, app.items[0].quality);
    }

    @Test
    void fooSellInZero() {
        Item[] items = new Item[] { new Item("foo", 0, 10) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
    }

    /////////////////////////////////////////////////////////////

    @Test
    void comte() {
        Item[] items = new Item[] { new Item("Comté", 5, 10) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals("Comté", app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
    }

    @Test
    void comteWithZeroSellIn() {
        Item[] items = new Item[] { new Item("Comté", 0, 10) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals("Comté", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
    }

    @Test
    void comteQualityMoreThanFifty() {
        Item[] items = new Item[] { new Item("Comté", 5, 50) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals("Comté", app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

//////////////////////////////////////////////////////////////////

    @Test
    void Kryptonite() {
        Item[] items = new Item[] { new Item("Kryptonite", 50, 80) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals("Kryptonite", app.items[0].name);
        assertEquals(50, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void KryptoniteWithHighQuality() {
        Item[] items = new Item[] { new Item("Kryptonite", 0, 150) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals("Kryptonite", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

/////////////////////////////////////////////////////////////

    @Test
    void passVipConcertLessThanTenDays(){
        Item[] items = new Item[] { new Item("Pass VIP Concert", 8, 10) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals("Pass VIP Concert", app.items[0].name);
        assertEquals(7, app.items[0].sellIn);
        assertEquals(12, app.items[0].quality);
    }
    @Test
    void passVipConcertLessThanThreeDays(){
        Item[] items = new Item[] { new Item("Pass VIP Concert", 3, 10) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals("Pass VIP Concert", app.items[0].name);
        assertEquals(2, app.items[0].sellIn);
        assertEquals(13, app.items[0].quality);
    }

    @Test
    void passVipConcertZeroDay(){
        Item[] items = new Item[] { new Item("Pass VIP Concert", 0, 10) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals("Pass VIP Concert", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void passQualityMoreThanFifty(){
        Item[] items = new Item[] { new Item("Pass VIP Concert", 8, 50) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals("Pass VIP Concert", app.items[0].name);
        assertEquals(7, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }
}
