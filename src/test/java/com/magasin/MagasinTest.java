package com.magasin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class MagasinTest {


    @ParameterizedTest
    @CsvSource({
            "foo, 5, 10, 4, 9",   // Cas 1 : sellIn 5 -> 4, quality 10 -> 9
            "foo, 0, 10, -1, 8",   // Cas 2 : sellIn 3 -> 2, quality 7 -> 6
            "foo, 0, 0, -1, 0",   // Cas 3 : sellIn 0 -> -1, quality reste 0
    })

    void testFoo(String name, int initialSellIn, int initialQuality, int expectedSellIn, int expectedQuality) {
        Item[] items = new Item[] {new Item(name, initialSellIn, initialQuality)};
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(name, app.items[0].name);
        assertEquals(expectedSellIn, app.items[0].sellIn);
        assertEquals(expectedQuality, app.items[0].quality);
    }

//    @Test
//    void foo() {
//        Item[] items = new Item[] { new Item("foo", 5, 10) };
//        Magasin app = new Magasin(items);
//        app.updateQuality();
//        assertEquals("foo", app.items[0].name);
//        assertEquals(4, app.items[0].sellIn);
//        assertEquals(9, app.items[0].quality);
//    }
//
//    @Test
//    void fooSellInZero() {
//        Item[] items = new Item[] { new Item("foo", 0, 10) };
//        Magasin app = new Magasin(items);
//        app.updateQuality();
//        assertEquals("foo", app.items[0].name);
//        assertEquals(-1, app.items[0].sellIn);
//        assertEquals(8, app.items[0].quality);
//    }

    /////////////////////////////////////////////////////////////


    @ParameterizedTest
    @CsvSource({
            "Comté, 5, 10, 4, 11",
            "Comté, 0, 10, -1, 12",
            "Comté, 5, 50, 4, 50",
    })

    void testComte(String name, int initialSellIn, int initialQuality, int expectedSellIn, int expectedQuality) {
        Item[] items = new Item[] {new Item(name, initialSellIn, initialQuality)};
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(name, app.items[0].name);
        assertEquals(expectedSellIn, app.items[0].sellIn);
        assertEquals(expectedQuality, app.items[0].quality);
    }

//    @Test
//    void comte() {
//        Item[] items = new Item[] { new Item("Comté", 5, 10) };
//        Magasin app = new Magasin(items);
//        app.updateQuality();
//        assertEquals("Comté", app.items[0].name);
//        assertEquals(4, app.items[0].sellIn);
//        assertEquals(11, app.items[0].quality);
//    }
//
//    @Test
//    void comteWithZeroSellIn() {
//        Item[] items = new Item[] { new Item("Comté", 0, 10) };
//        Magasin app = new Magasin(items);
//        app.updateQuality();
//        assertEquals("Comté", app.items[0].name);
//        assertEquals(-1, app.items[0].sellIn);
//        assertEquals(11, app.items[0].quality);
//    }
//
//    @Test
//    void comteQualityMoreThanFifty() {
//        Item[] items = new Item[] { new Item("Comté", 5, 50) };
//        Magasin app = new Magasin(items);
//        app.updateQuality();
//        assertEquals("Comté", app.items[0].name);
//        assertEquals(4, app.items[0].sellIn);
//        assertEquals(50, app.items[0].quality);
//    }

//////////////////////////////////////////////////////////////////

    @ParameterizedTest
    @CsvSource({
            "Kryptonite, 50, 80, 50, 80",
            "Kryptonite, 0, 150, 0, 80",  //FAILED
    })

    void testKryptonite(String name, int initialSellIn, int initialQuality, int expectedSellIn, int expectedQuality) {
        Item[] items = new Item[] {new Item(name, initialSellIn, initialQuality)};
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(name, app.items[0].name);
        assertEquals(expectedSellIn, app.items[0].sellIn);
        assertEquals(expectedQuality, app.items[0].quality);
    }


//    @Test
//    void Kryptonite() {
//        Item[] items = new Item[] { new Item("Kryptonite", 50, 80) };
//        Magasin app = new Magasin(items);
//        app.updateQuality();
//        assertEquals("Kryptonite", app.items[0].name);
//        assertEquals(50, app.items[0].sellIn);
//        assertEquals(80, app.items[0].quality);
//    }
//
//    @Test
//    void KryptoniteWithHighQuality() {
//        Item[] items = new Item[] { new Item("Kryptonite", 0, 150) };
//        Magasin app = new Magasin(items);
//        app.updateQuality();
//        assertEquals("Kryptonite", app.items[0].name);
//        assertEquals(0, app.items[0].sellIn);
//        assertEquals(80, app.items[0].quality);
//    }

/////////////////////////////////////////////////////////////


    @ParameterizedTest
    @CsvSource({
            "Pass VIP Concert, 8, 10, 7, 12",
            "Pass VIP Concert, 3, 10, 2, 13",
            "Pass VIP Concert, 0, 10, -1, 0",
            "Pass VIP Concert, 8, 50, 7, 50",
    })

    void testPassVipConcert(String name, int initialSellIn, int initialQuality, int expectedSellIn, int expectedQuality) {
        Item[] items = new Item[] {new Item(name, initialSellIn, initialQuality)};
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(name, app.items[0].name);
        assertEquals(expectedSellIn, app.items[0].sellIn);
        assertEquals(expectedQuality, app.items[0].quality);
    }


//    @Test
//    void passVipConcertLessThanTenDays(){
//        Item[] items = new Item[] { new Item("Pass VIP Concert", 8, 10) };
//        Magasin app = new Magasin(items);
//        app.updateQuality();
//        assertEquals("Pass VIP Concert", app.items[0].name);
//        assertEquals(7, app.items[0].sellIn);
//        assertEquals(12, app.items[0].quality);
//    }
//    @Test
//    void passVipConcertLessThanThreeDays(){
//        Item[] items = new Item[] { new Item("Pass VIP Concert", 3, 10) };
//        Magasin app = new Magasin(items);
//        app.updateQuality();
//        assertEquals("Pass VIP Concert", app.items[0].name);
//        assertEquals(2, app.items[0].sellIn);
//        assertEquals(13, app.items[0].quality);
//    }
//
//    @Test
//    void passVipConcertZeroDay(){
//        Item[] items = new Item[] { new Item("Pass VIP Concert", 0, 10) };
//        Magasin app = new Magasin(items);
//        app.updateQuality();
//        assertEquals("Pass VIP Concert", app.items[0].name);
//        assertEquals(-1, app.items[0].sellIn);
//        assertEquals(0, app.items[0].quality);
//    }
//
//    @Test
//    void passQualityMoreThanFifty(){
//        Item[] items = new Item[] { new Item("Pass VIP Concert", 8, 50) };
//        Magasin app = new Magasin(items);
//        app.updateQuality();
//        assertEquals("Pass VIP Concert", app.items[0].name);
//        assertEquals(7, app.items[0].sellIn);
//        assertEquals(50, app.items[0].quality);
//    }
}
