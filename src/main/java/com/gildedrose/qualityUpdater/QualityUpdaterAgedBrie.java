package com.gildedrose.qualityUpdater;

import com.gildedrose.Item;

import static java.lang.Math.min;

public class QualityUpdaterAgedBrie extends QualityUpdater {

    @Override
    public Item updateQuality(Item item) {
        Item newItem = updateSellIn(item, --item.sellIn);

        int newQuality = newItem.quality;
        if (newItem.sellIn >= 0) {
            newQuality += 1;
        } else {
            newQuality += 2;
        }
        return updateQuality(newItem,  min(newQuality, QUALITY_MAX));
    }
}
