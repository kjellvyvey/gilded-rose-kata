package com.gildedrose.qualityUpdater;

import com.gildedrose.Item;

public class QualityUpdater {
    private static final int QUALITY_MIN = 0;
    private static final int QUALITY_MAX = 50;

    public static Item updateQuality(final Item item) {
        switch (item.name) {
            case "Sulfuras, Hand of Ragnaros":
                return item;
            case "Aged Brie":
                return updateQualityForAgedBrie(updateSellIn(item));
            case "Backstage passes to a TAFKAL80ETC concert":
                return updateQualityForBackstagePass(updateSellIn(item));
            default:
                return updateQualityForStandardItem(updateSellIn(item));
        }
    }

    private static Item updateSellIn(Item item) {
        return new Item(item.name, --item.sellIn, item.quality);
    }

    private static Item updateQualityForStandardItem(Item item) {
        int newQuality = item.quality;
        if (item.sellIn >= 0) {
            newQuality -= 1;
        } else {
            newQuality -= 2;
        }
        return newItemWithNewQuality(item, newQuality);
    }

    private static Item updateQualityForAgedBrie(Item item) {
        int newQuality = item.quality;
        if (item.sellIn >= 0) {
            newQuality += 1;
        } else {
            newQuality += 2;
        }
        return newItemWithNewQuality(item, newQuality);
    }

    private static Item updateQualityForBackstagePass(Item item) {
        int newQuality = item.quality;
        if (item.sellIn >= 10 ) {
            newQuality += 1;
        } else if (item.sellIn >= 5) {
            newQuality += 2;
        } else if (item.sellIn >= 0) {
            newQuality += 3;
        } else {
            newQuality = 0;
        }
        return newItemWithNewQuality(item, newQuality);
    }

    private static Item newItemWithNewQuality(Item item, int newQuality) {
        newQuality = newQuality > QUALITY_MAX ? QUALITY_MAX : newQuality;
        newQuality = newQuality < QUALITY_MIN ? QUALITY_MIN : newQuality;
        return new Item(item.name, item.sellIn, newQuality);
    }
}
