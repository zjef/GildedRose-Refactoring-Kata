package com.gildedrose;

public class StandardItemUpdater implements ItemUpdater {

    @Override
    public void updateItem(Item item) {
            if (isExpired(item)) {
                lowerQualityBy(item, 2);
            } else {
                lowerQualityBy(item, 1);
            }
        item.sellIn--;
    }
}
