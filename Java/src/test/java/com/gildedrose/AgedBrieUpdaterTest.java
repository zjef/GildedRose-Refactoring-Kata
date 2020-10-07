package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AgedBrieUpdaterTest {

    public static final String AGED_BRIE = "Aged Brie";

    @Test
    public void agedBrieIncreasesInQuality() {
        Item[] items = createAgedBrieSingleton(10, 10);
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(11, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    public void agedBrieIncreasesInQualityByTwoWhenSellInIsLowerThanOrEqualToZero() {
        Item[] items = createAgedBrieSingleton(1, 10);
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(11, app.items[0].quality);
        assertEquals(0, app.items[0].sellIn);

        app.updateQuality();

        assertEquals(13, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    public void qualityDoesNotIncreaseAboveFifty() {
        Item[] items = createAgedBrieSingleton(10, 49);
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(50, app.items[0].quality);

        app.updateQuality();

        assertEquals(50, app.items[0].quality);
    }

    private Item[] createAgedBrieSingleton(Integer sellIn, Integer quality) {
        return new Item[]{new Item(AGED_BRIE, sellIn, quality)};
    }

}