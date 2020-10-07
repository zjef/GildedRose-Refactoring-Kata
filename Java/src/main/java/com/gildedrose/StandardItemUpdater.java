package com.gildedrose;

public class StandardItemUpdater implements ItemUpdater {

    @Override
    public void updateItem(Item item) {
        if (canLowerQuality(item)) {
            item.quality--;
            if (isExpired(item) && canLowerQuality(item)) {
                item.quality--;
            }
        }
        item.sellIn--;
    }
}
