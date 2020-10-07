package com.gildedrose;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

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
        return new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality)};
    }

    private Item[] createSulfurasSingleton(Integer sellIn, Integer quality) {
        return new Item[]{new Item("Sulfuras, Hand of Ragnaros", sellIn, quality)};
    }

    private Item[] createAgedBrieSingleton(Integer sellIn, Integer quality) {
        return new Item[]{new Item("Aged Brie", sellIn, quality)};
    }


    private Item[] createStandardItemSingleton(Integer sellIn, Integer quality) {
        return new Item[]{new Item("Standard Item", sellIn, quality)};
    }
}
