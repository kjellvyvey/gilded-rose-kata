package com.gildedrose;

import com.gildedrose.improvedCodeTests.QualityUpdaterForAgedBrie;
import com.gildedrose.improvedCodeTests.QualityUpdaterForBackStagepass;
import com.gildedrose.improvedCodeTests.QualityUpdaterForLegendaryItemTest;
import com.gildedrose.improvedCodeTests.QualityUpdaterForStandardItemTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        QualityUpdaterForBackStagepass.class,
        QualityUpdaterForAgedBrie.class,
        QualityUpdaterForStandardItemTest.class,
        QualityUpdaterForLegendaryItemTest.class,
})
public class ImpovedCodeTestSuite { //TODO separate SellinUpdater tests?
}
