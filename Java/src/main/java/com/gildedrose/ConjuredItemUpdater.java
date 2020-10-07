package com.gildedrose;

public class ConjuredItemUpdater implements ItemUpdater {

    @Override
    public void updateItem(Item item) {
        if (isExpired(item)) {
            lowerQualityBy(item, 4);
        } else {
            lowerQualityBy(item, 2);
        }
        item.sellIn--;
    }

}
