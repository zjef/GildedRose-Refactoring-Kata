package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BackstagePassesUpdaterTest {

    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    @Test
    public void BackstagePassesQualityIncreasedByOneIfSellInIsAbove10() {
        Item[] items = createBackstagePassSingleton(15, 10);
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(11, app.items[0].quality);

        app.updateQuality();

        assertEquals(12, app.items[0].quality);
    }

    @Test
    public void backstagePassesQualityIncreasesByThreeIfSellInIsLowerThanOrEqualToFive() {
        Item[] items = createBackstagePassSingleton(5, 10);
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(13, app.items[0].quality);

        app.updateQuality();

        assertEquals(16, app.items[0].quality);
    }

    @Test
    public void backstagePassesQualityIncreasesByThreeIfSellInIsLowerThanOrEqualToTen() {
        Item[] items = createBackstagePassSingleton(10, 10);
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(12, app.items[0].quality);

        app.updateQuality();

        assertEquals(14, app.items[0].quality);
    }

    @Test
    public void backstagePassesQualityIsZeroIfSellInIsNegative() {
        Item[] items = createBackstagePassSingleton(1, 10);
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(13, app.items[0].quality);

        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }

    private Item[] createBackstagePassSingleton(Integer sellIn, Integer quality) {
        return new Item[]{new Item(BACKSTAGE_PASSES, sellIn, quality)};
    }
}