package com.gildedrose;

public class AgedBrieUpdater implements ItemUpdater {

    @Override
    public void updateItem(Item item) {
        if (canIncreaseQuality(item)) {
            item.quality++;
            if (isExpired(item) && canIncreaseQuality(item)) {
                item.quality++;
            }
        }
        item.sellIn--;
    }
}
