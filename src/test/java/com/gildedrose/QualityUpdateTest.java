package com.gildedrose;

import com.gildedrose.qualityUpdater.GildedRoseQualityUpdater;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

class QualityUpdateTest {
    @Test
    public void testQualityUpdaterForStandardItem() {
        SoftAssertions.assertSoftly(s -> {
            testQualityUpdater(s, new Item("+5 Dexterity Vest", 10, 10), 9);
            testQualityUpdater(s, new Item("+5 Dexterity Vest", 1, 10), 9);

            testQualityUpdater(s, new Item("+5 Dexterity Vest", 0, 10), 8);
            testQualityUpdater(s, new Item("+5 Dexterity Vest", -1, 10), 8);

            testQualityUpdater(s, new Item("+5 Dexterity Vest", 1, 0), 0);
            testQualityUpdater(s, new Item("+5 Dexterity Vest", -1, 0), 0);
        });
    }

    @Test
    public void testQualityUpdaterForAgedBrie() {
        SoftAssertions.assertSoftly(s -> {
            testQualityUpdater(s, new Item("Aged Brie", 1, 10), 11);
            testQualityUpdater(s, new Item("Aged Brie", 1, 0), 1);

            testQualityUpdater(s, new Item("Aged Brie", 0, 0), 2);
            testQualityUpdater(s, new Item("Aged Brie", -1, 0), 2);

            testQualityUpdater(s, new Item("Aged Brie", -1, 48), 50);
            testQualityUpdater(s, new Item("Aged Brie", -1, 49), 50);
            testQualityUpdater(s, new Item("Aged Brie", -1, 50), 50);
        });
    }

    @Test
    public void testQualityUpdaterForBackstagePass() {
        SoftAssertions.assertSoftly(s -> {
            testQualityUpdater(s, new Item("Backstage passes to a TAFKAL80ETC concert", 11, 0), 1);

            testQualityUpdater(s, new Item("Backstage passes to a TAFKAL80ETC concert", 10, 0), 2);
            testQualityUpdater(s, new Item("Backstage passes to a TAFKAL80ETC concert", 9, 0), 2);
            testQualityUpdater(s, new Item("Backstage passes to a TAFKAL80ETC concert", 6, 0), 2);

            testQualityUpdater(s, new Item("Backstage passes to a TAFKAL80ETC concert", 5, 0), 3);
            testQualityUpdater(s, new Item("Backstage passes to a TAFKAL80ETC concert", 1, 0), 3);

            testQualityUpdater(s, new Item("Backstage passes to a TAFKAL80ETC concert", 1, 46), 49);
            testQualityUpdater(s, new Item("Backstage passes to a TAFKAL80ETC concert", 1, 47), 50);
            testQualityUpdater(s, new Item("Backstage passes to a TAFKAL80ETC concert", 1, 48), 50);
            testQualityUpdater(s, new Item("Backstage passes to a TAFKAL80ETC concert", 1, 49), 50);
            testQualityUpdater(s, new Item("Backstage passes to a TAFKAL80ETC concert", 1, 50), 50);

            testQualityUpdater(s, new Item("Backstage passes to a TAFKAL80ETC concert", 0, 0), 0);
            testQualityUpdater(s, new Item("Backstage passes to a TAFKAL80ETC concert", 0, 50),0);
        });
    }

    @Test
    public void testQualityUpdaterForLegendaryItem() {
        SoftAssertions.assertSoftly(s -> {
            testQualityUpdater(s, new Item("Sulfuras, Hand of Ragnaros", -1, 80),80);
            testQualityUpdater(s, new Item("Sulfuras, Hand of Ragnaros", 0, 80),80);
            testQualityUpdater(s, new Item("Sulfuras, Hand of Ragnaros", 10, 80),80);

            testQualityUpdater(s, new Item("Sulfuras, Hand of Ragnaros", -1, -10),-10);
            testQualityUpdater(s, new Item("Sulfuras, Hand of Ragnaros", 0, -10),-10);
            testQualityUpdater(s, new Item("Sulfuras, Hand of Ragnaros", 10, -10),-10);
        });
    }

    private void testQualityUpdater(SoftAssertions s, Item item, int expectedQuality) {
        testQualityUpdaterOld(s, new Item(item.name, item.sellIn, item.quality), expectedQuality);
        testQualityUpdaterNew(s, new Item(item.name, item.sellIn, item.quality), expectedQuality);
    }

    private void testQualityUpdaterOld(SoftAssertions s, Item item, int expectedQuality) {
        GildedRose gildedRose = new GildedRose();
        gildedRose.setItems(new Item[]{item});
        gildedRose.updateQuality();

        s.assertThat(gildedRose.getItems()[0].quality).isEqualTo(expectedQuality);
    }

    private void testQualityUpdaterNew(SoftAssertions s, Item item, int expectedQuality) {
        GildedRoseQualityUpdater qualityUpdater = new GildedRoseQualityUpdater();

        Item actual = qualityUpdater.updateQuality(item);

        s.assertThat(actual.quality).isEqualTo(expectedQuality);
    }
}
