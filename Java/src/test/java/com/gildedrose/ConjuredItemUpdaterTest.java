package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConjuredItemUpdaterTest {

    public static final String CONJURED_ITEM = "Conjured Mana Cake";

    @Test
    public void updateReducesSellInByOne() {
        Item[] items = createStandardItemSingleton(10, 10);
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    public void updateReducesQualityByTwo() {
        Item[] items = createStandardItemSingleton(10, 10);
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(8, app.items[0].quality);
    }

    @Test
    public void whenItemIsExpiredQualityIsReducedByFour() {
        Item[] items = createStandardItemSingleton(-10, 10);
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(6, app.items[0].quality);
    }

    @Test
    public void updateReducesQualityToAMinimumOZero() {
        Item[] items = createStandardItemSingleton(10, 1);
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }

    private Item[] createStandardItemSingleton(Integer sellIn, Integer quality) {
        return new Item[]{new Item(CONJURED_ITEM, sellIn, quality)};
    }
}