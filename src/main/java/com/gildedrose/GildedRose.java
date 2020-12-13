package com.gildedrose;

import com.gildedrose.qualityUpdater.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GildedRose {
    private Item[] items;

    public GildedRose() {}

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }

    public void updateQualityNew() {
        GildedRoseQualityUpdater qualityUpdater = new GildedRoseQualityUpdater();

        this.items = Arrays
                .stream(items)
                .map(qualityUpdater::updateQuality)
                .toArray(Item[]::new);
    }

    private class GildedRoseQualityUpdater {

        private QualityUpdater QUALITY_UPDATER_STANDARD = new QualityUpdaterStandardItem();

        private Map<String, QualityUpdater> updaters = new HashMap<>();

        public GildedRoseQualityUpdater() {
            initializeUpdaters();
        }

        private void initializeUpdaters() {
            updaters.put("Sulfuras, Hand of Ragnaros", new QualityUpdaterLegendaryItem());
            updaters.put("Aged Brie", new QualityUpdaterAgedBrie());
            updaters.put("Backstage passes to a TAFKAL80ETC concert", new QualityUpdaterBackStagePass());
        }

        public Item updateQuality(final Item item) {
            QualityUpdater updater = getUpdater(item.name);

            return updater.updateQuality(item);
        }

        private QualityUpdater getUpdater(String name) {
            return updaters.computeIfAbsent(name, (String) -> QUALITY_UPDATER_STANDARD);
        }
    }
}
