package com.gildedrose;

import com.gildedrose.existingCodeTests.AgedBrieTest;
import com.gildedrose.existingCodeTests.BackstagePassTest;
import com.gildedrose.existingCodeTests.LegendaryItemTest;
import com.gildedrose.existingCodeTests.StandardItemTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        AgedBrieTest.class,
        BackstagePassTest.class,
        LegendaryItemTest.class,
        StandardItemTest.class
})
public class ExisitingCodeTestSuite {
}
