package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StandardItemUpdaterTest {

    public static final String STANDARD_ITEM = "Standard Item";

    @Test
    public void updateQualityReducesSellInByOne() {
        Item[] items = createStandardItemSingleton(10, 10);
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    public void updateQualityReducesQualityByOne() {
        Item[] items = createStandardItemSingleton(10, 10);
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(9, app.items[0].quality);
    }

    @Test
    public void qualityIsReducedByTwoIfSellInIsNegative() {
        Item[] items = createStandardItemSingleton(-5, 10);
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(8, app.items[0].quality);
    }

    @Test
    public void qualityIsReducedByTwoIfSellInIsZero() {
        Item[] items = createStandardItemSingleton(0, 10);
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(8, app.items[0].quality);
    }

    private Item[] createStandardItemSingleton(Integer sellIn, Integer quality) {
        return new Item[]{new Item(STANDARD_ITEM, sellIn, quality)};
    }
}