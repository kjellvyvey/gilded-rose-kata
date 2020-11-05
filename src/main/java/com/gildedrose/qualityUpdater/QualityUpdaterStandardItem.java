package com.gildedrose.qualityUpdater;

import com.gildedrose.Item;

import static java.lang.Math.max;

public class QualityUpdaterStandardItem extends QualityUpdater {

    @Override
    public Item updateQuality(Item item) {
        Item newItem = updateSellIn(item);

        int newQuality = newItem.quality;
        if (item.sellIn >= 0) {
            newQuality -= 1;
        } else {
            newQuality -= 2;
        }
        return updateQuality(newItem, max(newQuality, QUALITY_MIN));
    }
}
