package com.gildedrose.qualityUpdater;

import com.gildedrose.Item;

import static java.lang.Math.min;

public class QualityUpdaterBackStagePass extends QualityUpdater {

    @Override
    public Item updateQuality(Item item) {
        Item newItem = updateSellIn(item, --item.sellIn);

        int newQuality = newItem.quality;
        if (newItem.sellIn >= 10 ) {
            newQuality += 1;
        } else if (newItem.sellIn >= 5) {
            newQuality += 2;
        } else if (newItem.sellIn >= 0) {
            newQuality += 3;
        } else {
            newQuality = 0;
        }
        return updateQuality(newItem, min(newQuality, QUALITY_MAX));
    }
}
