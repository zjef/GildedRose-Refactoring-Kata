package com.gildedrose;

import java.util.Arrays;

class GildedRose {

    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    Item[] items;

    public GildedRose(Item[] items) {
        validateItems(items);
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemUpdater itemUpdater = ItemUpdaterFactory.getUpdater(item);
            itemUpdater.updateItem(item);
        }
    }

    private void validateItems(Item[] items) {
        for (Item item : items) {
            if (SULFURAS.equals(item.name) && item.quality != 80) {
                throw new IllegalArgumentException("Sulfuras, Hand of Ragnaros its quality should be 80 and not: " + item.quality);
            }
            if (item.quality < 0) {
                throw new IllegalArgumentException("the quality of " + item.name + " must not be negative");
            }
        }
    }
}