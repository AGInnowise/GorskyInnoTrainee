
package demoqa.AlertsFrameWindowsTests;

import WebSites.UiTests.BaseTest;
import Pages.DemoqaPages.AlertsFrameWindows.FramesPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FramesTests extends BaseTest {

    @Test
    public void frames_ShouldHaveSampleHeading() {
        FramesPage page = new FramesPage(driver);
        page.open();

        String h1_1 = page.getFrame1Heading();
        String h1_2 = page.getFrame2Heading();

        Assertions.assertTrue(h1_1.contains("This is a sample page"), "Frame1 heading mismatch");
        Assertions.assertTrue(h1_2.contains("This is a sample page"), "Frame2 heading mismatch");
    }
}
