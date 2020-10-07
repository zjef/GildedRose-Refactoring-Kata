package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GildedRoseTest {

    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String AGED_BRIE = "Aged Brie";
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
    public void qualityIsReducedByTwoIfSellInIsNegative(){
        Item[] items = createStandardItemSingleton(-5, 10);
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(8, app.items[0].quality);
    }

    @Test
    public void qualityIsReducedByTwoIfSellInIsZero(){
        Item[] items = createStandardItemSingleton(0, 10);
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(8, app.items[0].quality);
    }

    @Test
    public void qualityCanNotBeNegative() {
        Item[] items = createStandardItemSingleton(10, 0);
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void agedBrieIncreasesInQuality() {
        Item[] items = createAgedBrieSingleton(10, 10);
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(11, app.items[0].quality);
    }

    @Test
    public void qualityDoesNotIncreaseAboveFifty() {
        Item[] items = createAgedBrieSingleton(10, 50);
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void sulfurasHasAQualityOfEighty() {
        Item[] items = createSulfurasSingleton(10, 10);

        assertThrows(IllegalArgumentException.class, () -> new GildedRose(items));
    }

    @Test
    public void sulfurasDoesNoDecreaseInQuality() {
        Item[] items = createSulfurasSingleton(10, 80);
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(80, app.items[0].quality);
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

    private Item[] createSulfurasSingleton(Integer sellIn, Integer quality) {
        return new Item[]{new Item(SULFURAS, sellIn, quality)};
    }

    private Item[] createAgedBrieSingleton(Integer sellIn, Integer quality) {
        return new Item[]{new Item(AGED_BRIE, sellIn, quality)};
    }


    private Item[] createStandardItemSingleton(Integer sellIn, Integer quality) {
        return new Item[]{new Item(STANDARD_ITEM, sellIn, quality)};
    }
}
