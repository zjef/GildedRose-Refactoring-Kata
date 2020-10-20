package com.gildedrose;

import java.util.Arrays;
import java.util.List;

public class ItemUpdaterFactory {

    private static final List<ItemUpdater> updaters = Arrays.asList(
            new AgedBrieUpdater(),
            new BackstagePassesUpdater(),
            new LegendaryItemUpdater(),
            new ConjuredItemUpdater()
    );

    public static ItemUpdater getUpdater(Item item) {
        return updaters.stream().filter(itemUpdater -> itemUpdater.updates(item))
                .findFirst()
                .orElse(new StandardItemUpdater());
    }
}
