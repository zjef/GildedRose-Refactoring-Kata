package com.gildedrose;

public class BasicItem extends IdentifiedItem {

    BasicItem(Item item) {
        super(item);
    }

    @Override
    public void updateItem() {
        if (canLowerQuality(item)) {
            item.quality--;
            if (isExpired(item) && canLowerQuality(item)) {
                item.quality--;
            }
        }
        item.sellIn--;
    }
}
