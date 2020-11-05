package com.gildedrose;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

class QualityUpdateTest {

    private GildedRose gildedRose;

    @Test
    public void testQualityUpdaterForStandardItem() {
        SoftAssertions.assertSoftly(s -> {
            testUpdateQuality(s, new Item("+5 Dexterity Vest", 10, 60), 59);
            testUpdateQuality(s, new Item("+5 Dexterity Vest", 10, 10), 9);
            testUpdateQuality(s, new Item("+5 Dexterity Vest", 1, 10), 9);

            testUpdateQuality(s, new Item("+5 Dexterity Vest", 0, 10), 8);
            testUpdateQuality(s, new Item("+5 Dexterity Vest", -1, 10), 8);

            testUpdateQuality(s, new Item("+5 Dexterity Vest", 1, 0), 0);
            testUpdateQuality(s, new Item("+5 Dexterity Vest", -1, 0), 0);
        });
    }

    @Test
    public void testQualityUpdaterForAgedBrie() {
        SoftAssertions.assertSoftly(s -> {
            testUpdateQuality(s, new Item("Aged Brie", 1, 10), 11);
            testUpdateQuality(s, new Item("Aged Brie", 1, 0), 1);

            testUpdateQuality(s, new Item("Aged Brie", 0, 0), 2);
            testUpdateQuality(s, new Item("Aged Brie", -1, 0), 2);

            testUpdateQuality(s, new Item("Aged Brie", -1, 48), 50);
            testUpdateQuality(s, new Item("Aged Brie", -1, 49), 50);
            testUpdateQuality(s, new Item("Aged Brie", -1, 50), 50);
        });
    }

    @Test
    public void testQualityUpdaterForBackstagePass() {
        SoftAssertions.assertSoftly(s -> {
            testUpdateQuality(s, new Item("Backstage passes to a TAFKAL80ETC concert", 11, 0), 1);

            testUpdateQuality(s, new Item("Backstage passes to a TAFKAL80ETC concert", 10, 0), 2);
            testUpdateQuality(s, new Item("Backstage passes to a TAFKAL80ETC concert", 9, 0), 2);
            testUpdateQuality(s, new Item("Backstage passes to a TAFKAL80ETC concert", 6, 0), 2);

            testUpdateQuality(s, new Item("Backstage passes to a TAFKAL80ETC concert", 5, 0), 3);
            testUpdateQuality(s, new Item("Backstage passes to a TAFKAL80ETC concert", 1, 0), 3);

            testUpdateQuality(s, new Item("Backstage passes to a TAFKAL80ETC concert", 1, 46), 49);
            testUpdateQuality(s, new Item("Backstage passes to a TAFKAL80ETC concert", 1, 47), 50);
            testUpdateQuality(s, new Item("Backstage passes to a TAFKAL80ETC concert", 1, 48), 50);
            testUpdateQuality(s, new Item("Backstage passes to a TAFKAL80ETC concert", 1, 49), 50);
            testUpdateQuality(s, new Item("Backstage passes to a TAFKAL80ETC concert", 1, 50), 50);

            testUpdateQuality(s, new Item("Backstage passes to a TAFKAL80ETC concert", 0, 0), 0);
            testUpdateQuality(s, new Item("Backstage passes to a TAFKAL80ETC concert", 0, 50),0);
        });
    }

    @Test
    public void testQualityUpdaterForLegendaryItem() {
        SoftAssertions.assertSoftly(s -> {
            testUpdateQuality(s, new Item("Sulfuras, Hand of Ragnaros", -1, 80),80);
            testUpdateQuality(s, new Item("Sulfuras, Hand of Ragnaros", 0, 80),80);
            testUpdateQuality(s, new Item("Sulfuras, Hand of Ragnaros", 10, 80),80);

            testUpdateQuality(s, new Item("Sulfuras, Hand of Ragnaros", -1, -10),-10);
            testUpdateQuality(s, new Item("Sulfuras, Hand of Ragnaros", 0, -10),-10);
            testUpdateQuality(s, new Item("Sulfuras, Hand of Ragnaros", 10, -10),-10);
        });
    }

    private void testUpdateQuality(SoftAssertions s, Item item, int expectedQuality) {
        gildedRose = new GildedRose(new Item[]{item});

        testOldQualityUpdate(s, new Item(item.name, item.sellIn, item.quality), expectedQuality);
        testNewQualityUpdate(s, new Item(item.name, item.sellIn, item.quality), expectedQuality);
    }

    private void testOldQualityUpdate(SoftAssertions s, Item item, int expectedQuality) {
        gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        int actualQuality = gildedRose.getItems()[0].quality;
        s.assertThat(actualQuality).isEqualTo(expectedQuality);
    }

    private void testNewQualityUpdate(SoftAssertions s, Item item, int expectedQuality) {
        gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQualityNew();

        int actualQuality = gildedRose.getItems()[0].quality;
        s.assertThat(actualQuality).isEqualTo(expectedQuality);
    }
}
