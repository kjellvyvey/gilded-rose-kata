package com.gildedrose;

import com.gildedrose.qualityUpdater.QualityUpdaterStrategy;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20),
//                new Item("Aged Brie", 10, 10),
//                new Item("Elixir of the Mongoose", 5, 7), //
//                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
//                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
//                new Item("Backstage passes to a TAFKAL80ETC concert", 20, 0),
//                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
//                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
//                new Item("Sulfuras, Hand of Ragnaros", 20, 80)

                // this conjured item does not work properly yet
                //new Item("Conjured Mana Cake", 3, 6)
        };

        GildedRose app = new GildedRose(items);

        int days = 60;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
//            System.out.println("-------- day " + i + " --------");
//            System.out.println("name, sellIn, quality");

            System.out.println(String.format("day %-4s sellin: %-4s quality:%-4s", i, items[0].sellIn, items[0].quality));
            app.updateQuality();
        }
    }

}
