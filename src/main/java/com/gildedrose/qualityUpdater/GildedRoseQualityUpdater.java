package com.gildedrose.qualityUpdater;

import com.gildedrose.Item;

import java.util.HashMap;
import java.util.Map;

public class GildedRoseQualityUpdater {

    public static final QualityUpdater QUALITY_UPDATER_STANDARD = new QualityUpdaterStandardItem();

    private Map<String, QualityUpdater> updaters = new HashMap<>();

    public GildedRoseQualityUpdater() {
        loadQualityUpdaters();
    }

    public Item updateQuality(final Item item) {
        QualityUpdater updater = getUpdater(item.name);

        return updater.updateQuality(item);
    }

    private void loadQualityUpdaters() {
        updaters.put("Sulfuras, Hand of Ragnaros", new QualityUpdaterLegendaryItem());
        updaters.put("Aged Brie", new QualityUpdaterAgedBrie());
        updaters.put("Backstage passes to a TAFKAL80ETC concert", new QualityUpdaterBackStagePass());
    }

    private QualityUpdater getUpdater(String name) {
        return updaters.computeIfAbsent(name, (String) -> QUALITY_UPDATER_STANDARD);
    }
}
