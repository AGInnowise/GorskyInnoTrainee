
package demoqa.AlertsFrameWindowsTests;

import WebSites.UiTests.BaseTest;
import Pages.DemoqaPages.AlertsFrameWindows.BrowserWindowsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class BrowserWindowsTests extends BaseTest {

    @Test
    public void openNewTabAndWindow_ShouldShowSamplePage() {
        BrowserWindowsPage page = new BrowserWindowsPage(driver);
        page.open();

        page.openNewTab();
        page.switchToNewestWindow();
        String h1Tab = driver.findElement(By.id("sampleHeading")).getText();
        Assertions.assertTrue(h1Tab.contains("This is a sample page"), "New Tab content incorrect");

        // Switch back to first window
        String firstHandle = driver.getWindowHandles().iterator().next();
        driver.switchTo().window(firstHandle);

        page.openNewWindow();
        page.switchToNewestWindow();
        String h1Window = driver.findElement(By.id("sampleHeading")).getText();
        Assertions.assertTrue(h1Window.contains("This is a sample page"), "New Window content incorrect");
    }
}
