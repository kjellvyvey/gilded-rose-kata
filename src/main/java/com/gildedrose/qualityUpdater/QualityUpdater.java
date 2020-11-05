package com.gildedrose.qualityUpdater;

import com.gildedrose.Item;

public abstract class QualityUpdater {
    public static final int QUALITY_MIN = 0;
    public static final int QUALITY_MAX = 50;

    public abstract Item updateQuality(Item item);

    protected Item updateSellIn(Item item, int newSellin) {
        return new Item(item.name, newSellin, item.quality);
    }

    protected Item updateQuality(Item item, int newQuality) {
        return new Item(item.name, item.sellIn, newQuality);
    }
}
