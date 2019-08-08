package com.gildedrose;

public class SellInUpdater {

    public static Item updateSellInForItem(final Item item) {
        switch (item.name) {
            case "Sulfuras, Hand of Ragnaros":
                return item;
            default:
                return updateSellInForNonLegendary(item, item.sellIn - 1);
        }
    }

    private static Item updateSellInForNonLegendary(Item item, int newSellin) {
        return new Item(item.name, newSellin, item.quality);
    }
}
