package com.gildedrose;

public interface ItemUpdater {

     void updateItem(Item item);

    default boolean expiresInDaysOrLess(Item item, Integer days) {
        return item.sellIn <= days;
    }

    default boolean isExpired(Item item) {
        return item.sellIn <= 0;
    }

    default boolean canLowerQuality(Item item) {
        return item.quality > 0;
    }

    default boolean canIncreaseQuality(Item item) {
        return item.quality < 50;
    }
}
