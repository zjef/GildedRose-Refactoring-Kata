package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class GildedRoseTest {

    public static final String STANDARD_ITEM = "Standard Item";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    @Test
    public void sulfurasHasAQualityOfEighty() {
        Item[] items = createSulfurasSingleton(10, 10);

        assertThrows(IllegalArgumentException.class, () -> new GildedRose(items));
    }

    @Test
    public void qualityCanNotBeNegative() {
        Item[] items = createStandardItemSingleton(10, -5);

        assertThrows(IllegalArgumentException.class, () -> new GildedRose(items));
    }

    private Item[] createStandardItemSingleton(Integer sellIn, Integer quality) {
        return new Item[]{new Item(STANDARD_ITEM, sellIn, quality)};
    }

    private Item[] createSulfurasSingleton(Integer sellIn, Integer quality) {
        return new Item[]{new Item(SULFURAS, sellIn, quality)};
    }
}
