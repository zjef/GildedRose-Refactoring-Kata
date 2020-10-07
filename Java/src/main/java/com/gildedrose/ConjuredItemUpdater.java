package com.gildedrose;

public class ConjuredItemUpdater implements ItemUpdater{

    @Override
    public void updateItem(Item item) {
        if (canLowerQuality(item)) {
            item.quality -= 2;
            if (isExpired(item) && canLowerQuality(item)) {
                item.quality -= 2;
            }
            if(item.quality < 0) {
                item.quality = 0;
            }
        }
        item.sellIn--;
    }

}
