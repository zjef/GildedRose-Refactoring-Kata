package com.gildedrose;

public abstract class IdentifiedItem {

    Item item;

    IdentifiedItem(final Item item) {
        this.item = item;
    }

    public abstract void updateItem();

    boolean expiresInDaysOrLess(Item item, Integer days) {
        return item.sellIn <= days;
    }

    boolean isExpired(Item item) {
        return item.sellIn <= 0;
    }

    boolean canLowerQuality(Item item) {
        return item.quality > 0;
    }

    boolean canIncreaseQuality(Item item) {
        return item.quality < 50;
    }
}
