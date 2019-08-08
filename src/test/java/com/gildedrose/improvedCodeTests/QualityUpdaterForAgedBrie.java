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
public class QualityUpdaterForAgedBrie {

    public GildedRose app;

    @Before
    public void setUp() {
        app = new GildedRose();
    }

    @Test
    public void Given_Aged_Brie_With_Sellin_Of_0_And_Quality_Of_0_When_Quality_Is_Updated_Expect_Quality_Of_1() {
        int sellin = 1;
        int quality = 0;
        int sellinExpected = 0;
        int qualityExpected = 1;

        app.setItems( new Item[] { new Item("Aged Brie", sellin, quality) });
        app.updateQualityImproved();

        int sellinActual = app.getItems()[0].sellIn;
        int qualityActual = app.getItems()[0].quality;

        assertThat(sellinActual, is(sellinExpected));
        assertThat(qualityActual, is(qualityExpected));
    }

    @Test
    public void Given_Aged_Brie_With_Sellin_Of_0_And_Quality_Of_49_When_Quality_Is_Updated_Expect_Quality_Of_50() {
        int sellin = 1;
        int quality = 49;
        int sellinExpected = 0;
        int qualityExpected = 50;

        app.setItems( new Item[] { new Item("Aged Brie", sellin, quality) });
        app.updateQualityImproved();

        int sellinActual = app.getItems()[0].sellIn;
        int qualityActual = app.getItems()[0].quality;

        assertThat(sellinActual, is(sellinExpected));
        assertThat(qualityActual, is(qualityExpected));
    }

    @Test
    public void Given_Aged_Brie_With_Sellin_Of_0_And_Quality_Of_50_When_Quality_Is_Updated_Expect_Quality_Of_50() {
        int sellin = 1;
        int quality = 50;
        int sellinExpected = 0;
        int qualityExpected = 50;

        app.setItems( new Item[] { new Item("Aged Brie", sellin, quality) });
        app.updateQualityImproved();

        int sellinActual = app.getItems()[0].sellIn;
        int qualityActual = app.getItems()[0].quality;

        assertThat(sellinActual, is(sellinExpected));
        assertThat(qualityActual, is(qualityExpected));
    }

    @Test
    public void Given_Aged_Brie_With_Sellin_Of_Minus_1_And_Quality_Of_0_When_Quality_Is_Updated_Expect_Quality_Of_1() {
        int sellin = 0;
        int quality = 0;
        int sellinExpected = -1;
        int qualityExpected = 1;

        app.setItems( new Item[] { new Item("Aged Brie", sellin, quality) });
        app.updateQualityImproved();

        int sellinActual = app.getItems()[0].sellIn;
        int qualityActual = app.getItems()[0].quality;

        assertThat(sellinActual, is(sellinExpected));
        assertThat(qualityActual, is(qualityExpected));
    }

    @Test
    public void Given_Aged_Brie_With_Sellin_Of_Minus_1_And_Quality_Of_50_When_Quality_Is_Updated_Expect_Quality_Of_50() {
        int sellin = 0;
        int quality = 50;
        int sellinExpected = -1;
        int qualityExpected = 50;

        app.setItems( new Item[] { new Item("Aged Brie", sellin, quality) });
        app.updateQualityImproved();

        int sellinActual = app.getItems()[0].sellIn;
        int qualityActual = app.getItems()[0].quality;

        assertThat(sellinActual, is(sellinExpected));
        assertThat(qualityActual, is(qualityExpected));
    }
}
