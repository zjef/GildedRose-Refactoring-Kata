package com.gildedrose;

public class AgedBrieUpdater implements ItemUpdater {

    private static final String AGED_BRIE = "Aged Brie";

    @Override
    public void updateItem(Item item) {
        if (isExpired(item)) {
            increaseQualityBy(item, 2);
        } else {
            increaseQualityBy(item, 1);
        }
        item.sellIn--;
    }

    @Override
    public boolean updates(Item item) {
        return AGED_BRIE.equals(item.name);
    }
}
