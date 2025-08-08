
package demoqa.AlertsFrameWindowsTests;

import WebSites.UiTests.BaseTest;
import Pages.DemoqaPages.AlertsFrameWindows.AlertsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AlertsTests extends BaseTest {

    @Test
    public void alertsFlow_ShouldHandleAllTypes() {
        AlertsPage page = new AlertsPage(driver);
        page.open();

        page.triggerImmediateAlertAndAccept();
        page.triggerTimerAlertAndAccept();

        page.triggerConfirm(true);
        Assertions.assertTrue(page.getConfirmResultText().contains("You selected Ok"), "Confirm result should be OK");

        page.triggerConfirm(false);
        Assertions.assertTrue(page.getConfirmResultText().contains("You selected Cancel"), "Confirm result should be Cancel");

        page.triggerPrompt("Hello QA");
        Assertions.assertTrue(page.getPromptResultText().contains("Hello QA"), "Prompt result should contain typed text");
    }
}
