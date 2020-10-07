package com.gildedrose;

public class AgedBrieUpdater implements ItemUpdater {

    @Override
    public void updateItem(Item item) {
        if (isExpired(item)) {
            increaseQualityBy(item, 2);
        } else {
            increaseQualityBy(item, 1);
        }
        item.sellIn--;
    }
}
