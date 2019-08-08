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
public class BackstagePassTest {

    @Parameters(name = "{index}: sellIn({0} -> {1}), quality before : {2}, quality difference after: {3}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 12, 11, 0, 1 },
                { 12, 11, 49, 1 },
                { 12, 11, 50, 0 },
                { 11, 10, 0, 2 },
                { 11, 10, 48, 2 },
                { 11, 10, 49, 1 },
                { 11, 10, 50, 0 },
                { 10, 9, 0, 2 },
                { 10, 9, 48, 2 },
                { 10, 9, 49, 1 },
                { 10, 9, 50, 0 },
                { 6, 5, 0, 3 },
                { 5, 4, 47, 3 },
                { 5, 4, 48, 2 },
                { 5, 4, 49, 1 },
                { 5, 4, 50, 0 },
                { 1, 0, 0, 3 },
                { 0, -1, 3, -3 }
        });
    }

    private int sellinInput, sellinExpected, qualityInput, qualityDifferenceExpected;

    public BackstagePassTest(int sellinInput, int sellinExpected, int qualityInput, int qualityDifferenceExpected) {
        this.sellinInput = sellinInput;
        this.sellinExpected = sellinExpected;
        this.qualityInput = qualityInput;
        this.qualityDifferenceExpected = qualityDifferenceExpected;
    }

    @Test
    public void test() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sellinInput, qualityInput) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        int qualityDifferenceActual = items[0].quality - qualityInput;

        assertThat(items[0].sellIn, is(sellinExpected));
        assertThat(qualityDifferenceActual, is(qualityDifferenceExpected));
    }
}
