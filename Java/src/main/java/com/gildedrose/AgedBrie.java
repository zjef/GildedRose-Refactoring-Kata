package com.gildedrose;

public class AgedBrie extends IdentifiedItem {

    AgedBrie(Item item) {
        super(item);
    }

    @Override
    public void updateItem() {
        if (canIncreaseQuality(item)) {
            item.quality++;
            if (isExpired(item) && canIncreaseQuality(item)) {
                item.quality++;
            }
        }
        item.sellIn--;
    }
}
