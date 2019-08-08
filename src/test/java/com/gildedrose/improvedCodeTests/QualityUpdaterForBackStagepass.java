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
public class QualityUpdaterForBackStagepass { //TODO more edge case tests needed

    public GildedRose app;

    @Before
    public void setUp() {
        app = new GildedRose();
    }

    @Test
    public void Given_BackStagepass_With_Sellin_Of_11_And_Quality_Of_0_When_Quality_Is_Updated_Expect_Quality_Of_1() {
        int sellin = 12;
        int sellinExpected = 11;
        int quality = 0;
        int qualityExpected = 1;

        app.setItems( new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sellin, quality) });
        app.updateQualityImproved();

        int sellinActual = app.getItems()[0].sellIn;
        int qualityActual = app.getItems()[0].quality;

        assertThat(sellinActual, is(sellinExpected));
        assertThat(qualityActual, is(qualityExpected));
    }

    @Test
    public void Given_BackStagepass_With_Sellin_Of_10_And_Quality_Of_0_When_Quality_Is_Updated_Expect_Quality_Of_2() {
        int sellin = 11;
        int sellinExpected = 10;
        int quality = 0;
        int qualityExpected = 2;

        app.setItems( new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sellin, quality) });
        app.updateQualityImproved();

        int sellinActual = app.getItems()[0].sellIn;
        int qualityActual = app.getItems()[0].quality;

        assertThat(sellinActual, is(sellinExpected));
        assertThat(qualityActual, is(qualityExpected));
    }

    @Test
    public void Given_BackStagepass_With_Sellin_Of_5_And_Quality_Of_0_When_Quality_Is_Updated_Expect_Quality_Of_3() {
        int sellin = 6;
        int sellinExpected = 5;
        int quality = 0;
        int qualityExpected = 3;

        app.setItems( new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sellin, quality) });
        app.updateQualityImproved();

        int sellinActual = app.getItems()[0].sellIn;
        int qualityActual = app.getItems()[0].quality;

        assertThat(sellinActual, is(sellinExpected));
        assertThat(qualityActual, is(qualityExpected));
    }

    @Test
    public void Given_BackStagepass_With_Sellin_Of_4_And_Quality_Of_0_When_Quality_Is_Updated_Expect_Quality_Of_3() {
        int sellin = 5;
        int sellinExpected = 4;
        int quality = 0;
        int qualityExpected = 3;

        app.setItems( new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sellin, quality) });
        app.updateQualityImproved();

        int sellinActual = app.getItems()[0].sellIn;
        int qualityActual = app.getItems()[0].quality;

        assertThat(sellinActual, is(sellinExpected));
        assertThat(qualityActual, is(qualityExpected));
    }

    @Test
    public void Given_BackStagepass_With_Sellin_Of_1_And_Quality_Of_0_When_Quality_Is_Updated_Expect_Quality_Of_3() {
        int sellin = 1;
        int sellinExpected = 0;
        int quality = 0;
        int qualityExpected = 3;

        app.setItems( new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sellin, quality) });
        app.updateQualityImproved();

        int sellinActual = app.getItems()[0].sellIn;
        int qualityActual = app.getItems()[0].quality;

        assertThat(sellinActual, is(sellinExpected));
        assertThat(qualityActual, is(qualityExpected));
    }

    @Test
    public void Given_BackStagepass_With_Sellin_Of_Minus_1_And_Quality_Of_10_When_Quality_Is_Updated_Expect_Quality_Of_0() {
        int sellin = 0;
        int sellinExpected = -1;
        int quality = 10;
        int qualityExpected = 0;

        app.setItems( new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sellin, quality) });
        app.updateQualityImproved();

        int sellinActual = app.getItems()[0].sellIn;
        int qualityActual = app.getItems()[0].quality;

        assertThat(sellinActual, is(sellinExpected));
        assertThat(qualityActual, is(qualityExpected));
    }
}
