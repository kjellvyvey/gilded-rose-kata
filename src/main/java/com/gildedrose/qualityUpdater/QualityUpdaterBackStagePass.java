package com.gildedrose.qualityUpdater;

import com.gildedrose.Item;

import static java.lang.Math.min;

public class QualityUpdaterBackStagePass extends QualityUpdater {

    @Override
    public Item updateQuality(Item item) {
        Item newItem = updateSellIn(item);

        int newQuality = newItem.quality;
        if (item.sellIn >= 10 ) {
            newQuality += 1;
        } else if (item.sellIn >= 5) {
            newQuality += 2;
        } else if (item.sellIn >= 0) {
            newQuality += 3;
        } else {
            newQuality = 0;
        }
        return updateQuality(newItem, min(newQuality, QUALITY_MAX));
    }
}
