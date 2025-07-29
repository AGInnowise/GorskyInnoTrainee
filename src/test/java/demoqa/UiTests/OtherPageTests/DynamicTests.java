package demoqa.UiTests.OtherPageTests;

import demoqa.UiTests.BaseTest;
import Pages.DemoqaPages.OtherPage.DynamicPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DynamicTests extends BaseTest {
    DynamicPage dynamicPage = new DynamicPage();

    @Test
    public void IsColorChangedTest() throws InterruptedException {
        dynamicPage.navigateToBasePage();
        dynamicPage.clickDynamicPage();

        dynamicPage.storeInitialColor();
        Thread.sleep(5000);
        Assertions.assertTrue(dynamicPage.isColorChanged());
    }

    @Test
    public void IsButtonPresentedTest() throws InterruptedException {
        dynamicPage.navigateToBasePage();
        dynamicPage.clickDynamicPage();

        Assertions.assertFalse(dynamicPage.isVisibleAfterButtonPresent());
        Thread.sleep(5000);
        Assertions.assertTrue(dynamicPage.isVisibleAfterButtonPresent());
    }
}

