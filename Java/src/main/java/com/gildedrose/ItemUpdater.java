package com.gildedrose;

public interface ItemUpdater {

    void updateItem(Item item);

    default boolean isExpired(Item item) {
        return item.sellIn <= 0;
    }

    default void lowerQualityBy(Item item, Integer decrement) {
        item.quality -= decrement;
        if (item.quality < 0) {
            item.quality = 0;
        }
    }

    default void increaseQualityBy(Item item, Integer increment) {
        item.quality += increment;
        if (item.quality > 50) {
            item.quality = 50;
        }
    }
}
