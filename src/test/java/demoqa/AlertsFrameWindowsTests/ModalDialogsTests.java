
package demoqa.AlertsFrameWindowsTests;

import WebSites.UiTests.BaseTest;
import Pages.DemoqaPages.AlertsFrameWindows.ModalDialogsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ModalDialogsTests extends BaseTest {

    @Test
    public void modalDialogs_SmallAndLarge_ShouldOpenAndClose() {
        ModalDialogsPage page = new ModalDialogsPage(driver);
        page.open();

        page.openSmallModal();
        Assertions.assertTrue(page.getSmallModalTitle().toLowerCase().contains("small modal"), "Small modal title mismatch");
        page.closeSmall();

        page.openLargeModal();
        Assertions.assertTrue(page.getLargeModalTitle().toLowerCase().contains("large modal"), "Large modal title mismatch");
        page.closeLarge();
    }
}
