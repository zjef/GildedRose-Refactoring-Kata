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

//            if (AGED_BRIE.equals(item.name)) {
//                updateAgedBrie(item);
//            } else if (BACKSTAGE_PASSES.equals(item.name)) {
//                updateBackstagePasses(item);
//            } else {
//                if (!SULFURAS.equals(item.name)) {
//                    updateStandardItem(item);
//                }
//            }


//            if (!item.name.equals(AGED_BRIE)
//                    && !item.name.equals(BACKSTAGE_PASSES)) {
//                if (item.quality > 0) {
//                    if (!item.name.equals(SULFURAS)) {
//                        item.quality = item.quality - 1;
//                    }
//                }
//            } else {
//                if (item.quality < 50) {
//                    item.quality = item.quality + 1;
//
//                    if (item.name.equals(BACKSTAGE_PASSES)) {
//                        if (item.sellIn < 11) {
//                            if (item.quality < 50) {
//                                item.quality = item.quality + 1;
//                            }
//                        }
//
//                        if (item.sellIn < 6) {
//                            if (item.quality < 50) {
//                                item.quality = item.quality + 1;
//                            }
//                        }
//                    }
//                }
//            }
//
//            if (!item.name.equals(SULFURAS)) {
//                item.sellIn = item.sellIn - 1;
//            }
//
//            if (item.sellIn < 0) {
//                if (!item.name.equals(AGED_BRIE)) {
//                    if (!item.name.equals(BACKSTAGE_PASSES)) {
//                        if (item.quality > 0) {
//                            if (!item.name.equals(SULFURAS)) {
//                                item.quality = item.quality - 1;
//                            }
//                        }
//                    } else {
//                        item.quality = 0;
//                    }
//                } else {
//                    if (item.quality < 50) {
//                        item.quality = item.quality + 1;
//                    }
//                }
//            }
        }
    }

    private void updateStandardItem(Item item) {
        if (item.quality > 0) {
            if (item.sellIn > 0) {
                item.quality--;
            } else {
                if (item.quality > 1) {
                    item.quality = item.quality - 2;
                } else
                    item.quality = 0;
            }
        }
        item.sellIn--;
    }

    private void updateBackstagePasses(Item item) {
        if (item.sellIn > 10) {
            item.quality++;
        } else if (5 < item.sellIn) {
            if (item.quality < 49) {
                item.quality = item.quality + 2;
            } else {
                item.quality = 50;
            }
        } else if (0 < item.sellIn) {
            if (item.quality < 48) {
                item.quality = item.quality + 3;
            } else {
                item.quality = 50;
            }
        } else {
            item.quality = 0;
        }
        item.sellIn--;
    }

    private void updateAgedBrie(Item item) {
        if (item.quality < 50) {
            if (item.sellIn <= 0) {
                if (item.quality < 49) {
                    item.quality = item.quality + 2;
                } else {
                    item.quality = 50;
                }
            } else {
                item.quality = item.quality + 1;
            }
        }
        item.sellIn--;
    }
}