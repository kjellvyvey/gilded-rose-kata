package com.gildedrose.improvedCodeTests;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


@RunWith(JUnit4.class)
public class QualityUpdaterForLegendaryItemTest {

    public GildedRose app;

    @Before
    public void setUp() {
        app = new GildedRose();
    }

    @Test
    public void Given_A_Legendary_Item_With_Sellin_Of_1_And_Quality_Of_80_When_Quality_Is_Updated_Expect_Quality_Of_80() {
        int sellin = 1;
        int sellinExpected = 1;
        int quality = 80;
        int qualityExpected = 80;

        app.setItems(new Item[]{new Item("Sulfuras, Hand of Ragnaros", sellin, quality)});
        app.updateQualityImproved();

        int sellinAcutal = app.getItems()[0].sellIn;
        int qualityActual = app.getItems()[0].quality;

        assertThat(qualityActual, is(qualityExpected));
        assertThat(sellinAcutal, is(sellinExpected));
    }
}