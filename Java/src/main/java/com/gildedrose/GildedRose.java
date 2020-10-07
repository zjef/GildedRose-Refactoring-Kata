package com.gildedrose;

class GildedRose {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    Item[] items;

    public GildedRose(Item[] items) {
        for (Item item : items) {
            if (SULFURAS.equals(item.name) && item.quality != 80) {
                throw new IllegalArgumentException("Sulfuras, Hand of Ragnaros its quality should be 80 and not: " + item.quality);
            }
            if (item.quality < 0) {
                throw new IllegalArgumentException("the quality of " + item.name + " must not be negative");
            }
        }
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemType itemType = determineItemType(item);

            switch (itemType) {
                case AGED_BRIE -> updateAgedBrie(item);
                case BACKSTAGE_PASSES -> updateBackstagePasses(item);
                case SULFURAS -> {
                }
                case STANDARD_ITEM -> updateStandardItem(item);
            }
        }
    }

    private ItemType determineItemType(Item item) {
        if (AGED_BRIE.equals(item.name)) {
            return ItemType.AGED_BRIE;
        }
        if (BACKSTAGE_PASSES.equals(item.name)) {
            return ItemType.BACKSTAGE_PASSES;
        }
        if (SULFURAS.equals(item.name)) {
            return ItemType.SULFURAS;
        }
        return ItemType.STANDARD_ITEM;
    }

    private void updateStandardItem(Item item) {
        if (canLowerQuality(item)) {
            item.quality--;
            if (isExpired(item) && canLowerQuality(item)) {
                item.quality--;
            }
        }
        item.sellIn--;
    }

    private void updateBackstagePasses(Item item) {
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

    private void updateAgedBrie(Item item) {
        if (canIncreaseQuality(item)) {
            item.quality++;
            if (isExpired(item) && canIncreaseQuality(item)) {
                item.quality++;
            }
        }
        item.sellIn--;
    }

    private boolean expiresInDaysOrLess(Item item, Integer days) {
        return item.sellIn <= days;
    }

    private boolean isExpired(Item item) {
        return item.sellIn <= 0;
    }

    private boolean canLowerQuality(Item item) {
        return item.quality > 0;
    }

    private boolean canIncreaseQuality(Item item) {
        return item.quality < 50;
    }
}