package com.gildedrose;

public class BackstagePassesUpdater implements ItemUpdater {

    @Override
    public void updateItem(Item item) {
        if (!isExpired(item)) {
            if (canIncreaseQuality(item)) {
                item.quality++;
                if (expiresInDaysOrLess(item, 10) && canIncreaseQuality(item)) {
                    item.quality++;
                }
                if (expiresInDaysOrLess(item, 5) && canIncreaseQuality(item)) {
                    item.quality++;
                }
            }
        } else {
            item.quality = 0;
        }
        item.sellIn--;
    }
}
