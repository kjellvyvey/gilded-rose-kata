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
public class QualityUpdaterForStandardItemTest {

    public GildedRose app;

    @Before
    public void setUp() {
        app = new GildedRose();
    }

    @Test
    public void Given_A_Standard_Item_With_Sellin_Of_1_And_Quality_Of_1_When_Quality_Is_Updated_Expect_Quality_Of_0() {
        int sellin = 1;
        int sellinExpected = 0;
        int quality = 1;
        int qualityExpected = 0;

        app.setItems( new Item[] { new Item("Standard Item", sellin, quality) });
        app.updateQualityImproved();

        int qualityActual = app.getItems()[0].quality;
        int sellinActual = app.getItems()[0].sellIn;

        assertThat(qualityActual, is(qualityExpected));
        assertThat(sellinActual, is(sellinExpected));
    }

    @Test
    public void Given_A_Standard_Item_With_Sellin_Of_Minus_One_And_Quality_Of_2_When_Quality_Is_Updated_Expect_Quality_Of_0() {
        int sellin = 0;
        int sellinExpected = -1;
        int quality = 2;
        int qualityExpected = 0;

        app.setItems( new Item[] { new Item("Standard Item", sellin, quality) });
        app.updateQualityImproved();

        int qualityActual = app.getItems()[0].quality;
        int sellinActual = app.getItems()[0].sellIn;

        assertThat(qualityActual, is(qualityExpected));
        assertThat(sellinActual, is(sellinExpected));
    }

    @Test
    public void Given_A_Standard_Item_With_Sellin_Of_0_And_Quality_Of_1_When_Quality_Is_Updated_Expect_Quality_Of_0() {
        int sellin = 1;
        int sellinExpected = 0;
        int quality = 1;
        int qualityExpected = 0;

        app.setItems( new Item[] { new Item("Standard Item", sellin, quality) });
        app.updateQualityImproved();

        int qualityActual = app.getItems()[0].quality;
        int sellinActual = app.getItems()[0].sellIn;

        assertThat(qualityActual, is(qualityExpected));
        assertThat(sellinActual, is(sellinExpected));
    }

    @Test
    public void Given_A_Standard_Item_With_Sellin_Of_0_And_Quality_Of_0_When_Quality_Is_Updated_Expect_Quality_Of_0() {
        int sellin = 1;
        int sellinExpected = 0;
        int quality = 0;
        int qualityExpected = 0;

        app.setItems( new Item[] { new Item("Standard Item", sellin, quality) });
        app.updateQualityImproved();

        int qualityActual = app.getItems()[0].quality;
        int sellinActual = app.getItems()[0].sellIn;

        assertThat(qualityActual, is(qualityExpected));
        assertThat(sellinActual, is(sellinExpected));
    }
}
