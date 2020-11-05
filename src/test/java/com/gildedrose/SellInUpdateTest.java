package com.gildedrose;

import com.gildedrose.qualityUpdater.GildedRoseQualityUpdater;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

class SellInUpdateTest {
    @Test
    public void testSellinUpdaterForStandardItem() {
        SoftAssertions.assertSoftly(s -> {
            testQualityUpdater(s, new Item("+5 Dexterity Vest", 1, 20), 0);
            testQualityUpdater(s, new Item("+5 Dexterity Vest", 0, 1), -1);
            testQualityUpdater(s, new Item("+5 Dexterity Vest", -1, 0), -2);
        });
    }

    @Test
    public void testSellinUpdaterForAgedBrie() {
        SoftAssertions.assertSoftly(s -> {
            testQualityUpdater(s, new Item("Aged Brie", 1, 0), 0);
            testQualityUpdater(s, new Item("Aged Brie", 0, 0), -1);
            testQualityUpdater(s, new Item("Aged Brie", -1, 0), -2);
        });
    }

    @Test
    public void testSellinUpdaterForBackstagePass() {
        SoftAssertions.assertSoftly(s -> {
            testQualityUpdater(s, new Item("Backstage passes to a TAFKAL80ETC concert", 1, 20), 0);
            testQualityUpdater(s, new Item("Backstage passes to a TAFKAL80ETC concert", 0, 49), -1);
            testQualityUpdater(s, new Item("Backstage passes to a TAFKAL80ETC concert", -1, 49),-2);
        });
    }

    @Test
    public void testSellinUpdaterForLegendaryItem() {
        SoftAssertions.assertSoftly(s -> {
            testQualityUpdater(s, new Item("Sulfuras, Hand of Ragnaros", 1, 80),1);
            testQualityUpdater(s, new Item("Sulfuras, Hand of Ragnaros", 0, 80),0);
            testQualityUpdater(s, new Item("Sulfuras, Hand of Ragnaros", -1, 80),-1);
        });
    }
    
    private void testQualityUpdater(SoftAssertions s, Item item, int expectedSellin) {
        testQualityUpdaterOld(s, new Item(item.name, item.sellIn, item.quality), expectedSellin);
        testQualityUpdaterNew(s, new Item(item.name, item.sellIn, item.quality), expectedSellin);
    }

    private void testQualityUpdaterOld(SoftAssertions s, Item item, int expectedQuality) {
        GildedRose gildedRose = new GildedRose();
        gildedRose.setItems(new Item[]{item});
        gildedRose.updateQuality();

        s.assertThat(gildedRose.getItems()[0].sellIn).isEqualTo(expectedQuality);
    }

    private void testQualityUpdaterNew(SoftAssertions s, Item item, int expectedQuality) {
        GildedRoseQualityUpdater qualityUpdater = new GildedRoseQualityUpdater();

        Item actual = qualityUpdater.updateQuality(item);

        s.assertThat(actual.sellIn).isEqualTo(expectedQuality);
    }
}