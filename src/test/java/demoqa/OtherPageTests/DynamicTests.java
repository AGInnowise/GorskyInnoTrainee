package demoqa.OtherPageTests;

import WebSites.UiTests.BaseTest;
import Pages.DemoqaPages.OtherPage.DynamicPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DynamicTests extends BaseTest {

    @Test
    public void IsColorChangedTest() throws InterruptedException {
        DynamicPage dynamicPage = new DynamicPage();

        dynamicPage.navigateToBaseDemoqaPage();
        dynamicPage.clickDynamicPage();

        dynamicPage.storeInitialColor();
        Thread.sleep(5000);
        Assertions.assertTrue(dynamicPage.isColorChanged());
    }

    @Test
    public void IsButtonPresentedTest() throws InterruptedException {
        DynamicPage dynamicPage = new DynamicPage();

        dynamicPage.navigateToBaseDemoqaPage();
        dynamicPage.clickDynamicPage();

        Assertions.assertFalse(dynamicPage.isVisibleAfterButtonPresent());
        Thread.sleep(5000);
        Assertions.assertTrue(dynamicPage.isVisibleAfterButtonPresent());
    }
}

