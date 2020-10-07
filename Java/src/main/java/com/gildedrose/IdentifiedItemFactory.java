package com.gildedrose;

public class IdentifiedItemFactory {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    public static IdentifiedItem identify(Item item) {
        if (AGED_BRIE.equals(item.name)) {
            return new AgedBrie(item);
        }
        if (BACKSTAGE_PASSES.equals(item.name)) {
            return new BackstagePasses(item);
        }
        if (SULFURAS.equals(item.name)) {
            return new LegendaryItem(item);
        }
        return new BasicItem(item);
    }
}
