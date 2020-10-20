package com.gildedrose;

public class ConjuredItemUpdater implements ItemUpdater {

    private static final String CONJURED = "Conjured";

    @Override
    public void updateItem(Item item) {
        if (isExpired(item)) {
            lowerQualityBy(item, 4);
        } else {
            lowerQualityBy(item, 2);
        }
        item.sellIn--;
    }

    @Override
    public boolean updates(Item item) {
        return item.name != null && item.name.startsWith(CONJURED);
    }

}
