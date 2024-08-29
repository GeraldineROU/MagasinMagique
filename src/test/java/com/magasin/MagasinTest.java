package com.magasin;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MagasinTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }


    @Test
    void comteTest() {
        Item[] items = new Item[] { new Item("Comté", 8, 16)};
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals("Comté", app.items[0].name);
        assertEquals(7, app.items[0].sellIn);
        assertEquals(17,app.items[0].quality);

    }

    @Test
    void comtePerimeTest() {
        Item[] items = new Item[] { new Item("Comté", -2, 16)};
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals("Comté", app.items[0].name);
        assertEquals(-3, app.items[0].sellIn);
        assertEquals(17,app.items[0].quality);

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

    //////////// Test paramétrés : permet en une seule fonction de vérifier plusieurs cas /////////////


//    @ParameterizedTest
//    @CsvFileSource(files = "src/test/resources/items.csv")
//    void csvSourcedTest(String name, Integer sellIn, Integer quality, String expectedName, Integer expectedSellIn, Integer expectedQuality) {
//
//        ////initialisation du test
//        Item[] items = new Item[] {new Item(name, sellIn, quality)};
//        Magasin shop = new Magasin(items);
//
//        ////execution de la fonction à tester
//        shop.updateQuality();
//
//        ////verification
//        assertEquals(expectedName, shop.items[0].name);
//        assertEquals(expectedSellIn, shop.items[0].sellIn);
//        assertEquals(expectedQuality, shop.items[0].quality);
//    }

    @ParameterizedTest
    @CsvSource({
            "Standard Item,10,20,Standard Item,9,19",
            "Standard Item,0,10,Standard Item,-1,8",
            "Standard Item,-1,10,Standard Item,-2,8",
            "Standard Item,5,0,Standard Item,4,0",
            "Standard Item,5,1,Standard Item,4,0",
            "Standard Item,5,50,Standard Item,4,49",
            "Comté,10,20,Comté,9,21",
            "Comté,0,20,Comté,-1,21",
            "Comté,-1,20,Comté,-2,21",
            "Comté,5,50,Comté,4,50",
            "Comté,5,49,Comté,4,50",
            "Pass VIP Concert,15,20,Pass VIP Concert,14,21",
            "Pass VIP Concert,10,20,Pass VIP Concert,9,22",
            "Pass VIP Concert,5,20,Pass VIP Concert,4,23",
            "Pass VIP Concert,1,20,Pass VIP Concert,0,23",
            "Pass VIP Concert,0,20,Pass VIP Concert,-1,0",
            "Pass VIP Concert,-1,20,Pass VIP Concert,-2,0",
            "Pass VIP Concert,5,50,Pass VIP Concert,4,50",
            "Kryptonite,5,80,Kryptonite,5,80",
            "Kryptonite,-1,80,Kryptonite,-1,80",
            "Kryptonite,0,80,Kryptonite,0,80",
            "Standard Item,0,0,Standard Item,-1,0",
            "Comté,0,50,Comté,-1,50",
            "Pass VIP Concert,0,0,Pass VIP Concert,-1,0",
    })

    void csvSourcedInCodeTest(String name, Integer sellIn, Integer quality, String expectedName, Integer expectedSellIn, Integer expectedQuality) {

        ////initialisation du test
        Item[] items = new Item[] {new Item(name, sellIn, quality)};
        Magasin shop = new Magasin(items);

        ////execution de la fonction à tester
        shop.updateQuality();


        ////verification
        assertEquals(expectedName, shop.items[0].name);
        assertEquals(expectedSellIn, shop.items[0].sellIn);
        assertEquals(expectedQuality, shop.items[0].quality);
    }

    @Test
    void unNouveauJour() {
        // Initialisation du test
        Item[] items = new Item[] {
                new Item("Standard Item", 10, 20),
                new Item("Standard Item", 0, 10),
                new Item("Standard Item", -1, 10),
                new Item("Standard Item", 5, 0),
                new Item("Standard Item", 5, 1),
                new Item("Standard Item", 5, 50),
                new Item("Comté", 10, 20),
                new Item("Comté", 0, 20),
                new Item("Comté", -1, 20),
                new Item("Comté", 5, 50),
                new Item("Comté", 5, 49),
                new Item("Pass VIP Concert", 15, 20),
                new Item("Pass VIP Concert", 10, 20),
                new Item("Pass VIP Concert", 5, 20),
                new Item("Pass VIP Concert", 1, 20),
                new Item("Pass VIP Concert", 0, 20),
                new Item("Pass VIP Concert", -1, 20),
                new Item("Pass VIP Concert", 5, 50),
                new Item("Kryptonite", 5, 80),
                new Item("Kryptonite", -1, 80),
                new Item("Kryptonite", 0, 80),
                new Item("Standard Item", 0, 0),
                new Item("Comté", 0, 50),
                new Item("Pass VIP Concert", 0, 0),
                new Item("Kryptonite", 0, 80)
        };

        Item[] expectedItems = new Item[] {
                new Item("Standard Item", 9, 19),
                new Item("Standard Item", -1, 8),
                new Item("Standard Item", -2, 8),
                new Item("Standard Item", 4, 0),
                new Item("Standard Item", 4, 0),
                new Item("Standard Item", 4, 49),
                new Item("Comté", 9, 21),
                new Item("Comté", -1, 21),
                new Item("Comté", -2, 21),
                new Item("Comté", 4, 50),
                new Item("Comté", 4, 50),
                new Item("Pass VIP Concert", 14, 21),
                new Item("Pass VIP Concert", 9, 22),
                new Item("Pass VIP Concert", 4, 23),
                new Item("Pass VIP Concert", 0, 23),
                new Item("Pass VIP Concert", -1, 0),
                new Item("Pass VIP Concert", -2, 0),
                new Item("Pass VIP Concert", 4, 50),
                new Item("Kryptonite", 5, 80),
                new Item("Kryptonite", -1, 80),
                new Item("Kryptonite", 0, 80),
                new Item("Standard Item", -1, 0),
                new Item("Comté", -1, 50),
                new Item("Pass VIP Concert", -1, 0),
                new Item("Kryptonite", 0, 80)
        };

        Magasin magasin = new Magasin(items);

        // Exécution du code à tester
        magasin.updateQuality();

        // Validation du résultat
        for (int i = 0; i<items.length; i++) {
            assertItemEquals(expectedItems[i], magasin.items[i]);
        }
    }

    private void assertItemEquals(Item expectedItems, Item item) {
        assertEquals(expectedItems.name, item.name);
        assertEquals(expectedItems.sellIn, item.sellIn);
        assertEquals(expectedItems.quality, item.quality);
    }
}
