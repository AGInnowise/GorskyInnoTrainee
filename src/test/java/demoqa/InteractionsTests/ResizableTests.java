
package demoqa.InteractionsTests;

import WebSites.UiTests.BaseTest;
import Pages.DemoqaPages.Interactions.ResizablePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;

public class ResizableTests extends BaseTest {

    @Test
    public void restrictedBox_ShouldRespectResize() {
        ResizablePage page = new ResizablePage(driver);
        page.open();

        Dimension before = page.getRestrictedSize();
        page.resizeRestrictedBy(50, 30);
        Dimension after = page.getRestrictedSize();

        Assertions.assertTrue(after.getHeight() != before.getHeight() || after.getWidth() != before.getWidth(),
                "Restricted box size should change within limits");
    }

    @Test
    public void freeBox_ShouldResizeFreely() {
        ResizablePage page = new ResizablePage(driver);
        page.open();

        Dimension before = page.getFreeSize();
        page.resizeFreeBy(80, 40);
        Dimension after = page.getFreeSize();

        Assertions.assertTrue(after.getHeight() != before.getHeight() || after.getWidth() != before.getWidth(),
                "Free box size should change");
    }
}
