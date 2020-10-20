package com.gildedrose;

public class LegendaryItemUpdater implements ItemUpdater {

    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    @Override
    public void updateItem(Item item) {
        //NOOP
    }

    @Override
    public boolean updates(Item item) {
        return SULFURAS.equals(item.name);
    }
}
