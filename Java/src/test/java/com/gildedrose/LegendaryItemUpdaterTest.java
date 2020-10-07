package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LegendaryItemUpdaterTest {

    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

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

    private Item[] createSulfurasSingleton(Integer sellIn, Integer quality) {
        return new Item[]{new Item(SULFURAS, sellIn, quality)};
    }
}