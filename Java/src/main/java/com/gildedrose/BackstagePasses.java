package com.gildedrose;

public class BackstagePasses extends IdentifiedItem{

    BackstagePasses(Item item) {
        super(item);
    }

    @Override
    public void updateItem() {
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
