package com.gildedrose;

public class QualityUpdater {
    private static final int QUALITY_MIN = 0;
    private static final int QUALITY_MAX = 50;

    public static Item updateQualityForItem(final Item item) {
        switch (item.name) {
            case "Sulfuras, Hand of Ragnaros":
                return item; //TODO don't return the item like this
            case "Aged Brie":
                return updateQualityForAgedBrie(item);
            case "Backstage passes to a TAFKAL80ETC concert":
                return updateQualityForBackstagePass(item);
            default:
                return updateQualityForStandardItem(item);
        }
    }

    private static Item updateQualityForStandardItem(Item item) { //TODO refactor the following three methods to quality calculators
        int newQuality = item.quality;
        if (item.sellIn >= 0) {
            newQuality -= 1; //TODO psfi for literals
        } else {
            newQuality -= 2;
        }
        return updateItemWithNewQuality(item, newQuality);
    }

    private static Item updateQualityForAgedBrie(Item item) {
        int newQuality = item.quality + 1;
        return updateItemWithNewQuality(item, newQuality);
    }

    private static Item updateQualityForBackstagePass(Item item) {
        int newQuality = item.quality;
        if (item.sellIn > 10 ) {
            newQuality += 1;
        } else if (item.sellIn > 5) {
            newQuality += 2;
        } else if (item.sellIn >= 0) {
            newQuality += 3;
        } else if (item.sellIn < 0) {
            newQuality = 0;
        }
        return updateItemWithNewQuality(item, newQuality);
    }

    private static Item updateItemWithNewQuality(Item item, int newQuality) { //TODO refactor checks in this method in a separate method
        newQuality = newQuality > QUALITY_MAX ? QUALITY_MAX : newQuality;
        newQuality = newQuality < QUALITY_MIN ? QUALITY_MIN : newQuality;
        return new Item(item.name, item.sellIn, newQuality);
    }
}
