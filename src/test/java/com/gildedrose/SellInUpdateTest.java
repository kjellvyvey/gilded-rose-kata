package com.gildedrose;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

class SellInUpdateTest {

    private GildedRose gildedRose;

    @Test
    public void testSellinUpdaterForStandardItem() {
        SoftAssertions.assertSoftly(s -> {
            testSellInUpdate(s, new Item("+5 Dexterity Vest", 1, 20), 0);
            testSellInUpdate(s, new Item("+5 Dexterity Vest", 0, 1), -1);
            testSellInUpdate(s, new Item("+5 Dexterity Vest", -1, 0), -2);
        });
    }

    @Test
    public void testSellinUpdaterForAgedBrie() {
        SoftAssertions.assertSoftly(s -> {
            testSellInUpdate(s, new Item("Aged Brie", 1, 0), 0);
            testSellInUpdate(s, new Item("Aged Brie", 0, 0), -1);
            testSellInUpdate(s, new Item("Aged Brie", -1, 0), -2);
        });
    }

    @Test
    public void testSellinUpdaterForBackstagePass() {
        SoftAssertions.assertSoftly(s -> {
            testSellInUpdate(s, new Item("Backstage passes to a TAFKAL80ETC concert", 1, 20), 0);
            testSellInUpdate(s, new Item("Backstage passes to a TAFKAL80ETC concert", 0, 49), -1);
            testSellInUpdate(s, new Item("Backstage passes to a TAFKAL80ETC concert", -1, 49),-2);
        });
    }

    @Test
    public void testSellinUpdaterForLegendaryItem() {
        SoftAssertions.assertSoftly(s -> {
            testSellInUpdate(s, new Item("Sulfuras, Hand of Ragnaros", 1, 80),1);
            testSellInUpdate(s, new Item("Sulfuras, Hand of Ragnaros", 0, 80),0);
            testSellInUpdate(s, new Item("Sulfuras, Hand of Ragnaros", -1, 80),-1);
        });
    }
    
    private void testSellInUpdate(SoftAssertions s, Item item, int expectedSellin) {
        testOldSellInUpdate(s, new Item(item.name, item.sellIn, item.quality), expectedSellin);
        testNewSellInUpdate(s, new Item(item.name, item.sellIn, item.quality), expectedSellin);
    }

    private void testOldSellInUpdate(SoftAssertions s, Item item, int expectedQuality) {
        gildedRose = new GildedRose();
        gildedRose.setItems(new Item[]{item});

        gildedRose.updateQuality();

        int actualSellIn = gildedRose.getItems()[0].sellIn;
        s.assertThat(actualSellIn).isEqualTo(expectedQuality);
    }

    private void testNewSellInUpdate(SoftAssertions s, Item item, int expectedQuality) {
        gildedRose = new GildedRose();
        gildedRose.setItems(new Item[]{item});

        gildedRose.updateQualityNew();

        int actualSellIn = gildedRose.getItems()[0].sellIn;
        s.assertThat(actualSellIn).isEqualTo(expectedQuality);
    }
}