package com.gildedrose;

public class BackstagePassesUpdater implements ItemUpdater {

    @Override
    public void updateItem(Item item) {
        if (isExpired(item)) {
            item.quality = 0;
        } else if (expiresInDaysOrLess(item, 5)) {
            increaseQualityBy(item, 3);
        } else if (expiresInDaysOrLess(item, 10)) {
            increaseQualityBy(item, 2);
        } else {
            increaseQualityBy(item, 1);
        }
        item.sellIn--;
    }

    private boolean expiresInDaysOrLess(Item item, Integer days) {
        return item.sellIn <= days;
    }
}
