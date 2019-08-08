package com.gildedrose.existingCodeTests;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class LegendaryItemTest {

    @Parameters(name = "{index}: sellIn({0} -> {1}), quality before : {2}, quality difference after: {3}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 1, 1, 80, 0 },
                { 0, 0, 80, 0},
                { 1, 1, 80, 0 },
                { 0, 0, 80, 0 }
        });
    }

    private int sellinInput, sellinExpected, qualityInput, qualityDifferenceExpected;

    public LegendaryItemTest(int sellinInput, int sellinExpected, int qualityInput, int qualityDifferenceExpected) {
        this.sellinInput = sellinInput;
        this.sellinExpected = sellinExpected;
        this.qualityInput = qualityInput;
        this.qualityDifferenceExpected = qualityDifferenceExpected;
    }

    @Test
    public void test() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", sellinInput, qualityInput) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        int qualityDifferenceActual = items[0].quality - qualityInput;

        assertThat(app.getItems()[0].sellIn, is(sellinExpected));
        assertThat(qualityDifferenceActual, is(qualityDifferenceExpected));
    }
}
