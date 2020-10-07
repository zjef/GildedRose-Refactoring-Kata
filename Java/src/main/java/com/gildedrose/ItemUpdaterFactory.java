package com.gildedrose;

public class ItemUpdaterFactory {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    public static ItemUpdater getUpdater(Item item) {
        if (AGED_BRIE.equals(item.name)) {
            return new AgedBrieUpdater();
        }
        if (BACKSTAGE_PASSES.equals(item.name)) {
            return new BackstagePassesUpdater();
        }
        if (SULFURAS.equals(item.name)) {
            return new LegendaryItemUpdater();
        }
        return new StandardItemUpdater();
    }
}
