
package demoqa.AlertsFrameWindowsTests;

import WebSites.UiTests.BaseTest;
import Pages.DemoqaPages.AlertsFrameWindows.NestedFramesPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NestedFramesTests extends BaseTest {

    @Test
    public void nestedFrames_ShouldContainParentAndChildTexts() {
        NestedFramesPage page = new NestedFramesPage(driver);
        page.open();

        Assertions.assertTrue(page.getParentText().contains("Parent frame"), "Parent frame text mismatch");
        Assertions.assertTrue(page.getChildText().contains("Child Iframe"), "Child frame text mismatch");
    }
}
