package com.gildedrose.existingCodeTests;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class StandardItemTest {

    @Parameters(name = "{index}: sellIn({0} -> {1}), quality before : {2}, quality difference after: {3}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 1, 0, 1, -1 },
                { 1, 0, 0, 0 },
                { 0, -1, 2, -2 },
                { 0, -1, 1, -1 },
                { 0, -1, 0, 0 }
        });
    }

    private int sellinInput, sellinExpected, qualityInput, qualityDifferenceExpected;

    public StandardItemTest(int sellinInput, int sellinExpected, int qualityInput, int qualityDifferenceExpected) {
        this.sellinInput = sellinInput;
        this.sellinExpected = sellinExpected;
        this.qualityInput = qualityInput;
        this.qualityDifferenceExpected = qualityDifferenceExpected;
    }

    @Test
    public void test() {
        Item[] items = new Item[] { new Item("Standard Item", sellinInput, qualityInput) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        int qualityDifferenceActual = items[0].quality - qualityInput;

        assertThat(items[0].sellIn, is(sellinExpected));
        assertThat(qualityDifferenceActual, is(qualityDifferenceExpected));
    }
}