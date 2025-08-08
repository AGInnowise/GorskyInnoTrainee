
package Pages.DemoqaPages.AlertsFrameWindows;

import Elements.ButtonElement.ButtonElement;
import Elements.BaseElement;
import Pages.BasePage;
import Helpers.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ModalDialogsPage extends BasePage {
    private final ButtonElement showSmallModal = new ButtonElement(driver, By.id("showSmallModal"));
    private final ButtonElement showLargeModal = new ButtonElement(driver, By.id("showLargeModal"));
    private final ButtonElement closeSmallModal = new ButtonElement(driver, By.id("closeSmallModal"));
    private final ButtonElement closeLargeModal = new ButtonElement(driver, By.id("closeLargeModal"));
    private final BaseElement smallModalTitle = new BaseElement(driver, By.id("example-modal-sizes-title-sm"));
    private final BaseElement largeModalTitle = new BaseElement(driver, By.id("example-modal-sizes-title-lg"));

    public ModalDialogsPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        String url = "https://demoqa.com/modal-dialogs";
        Logger.log("ModalDialogsPage: open -> " + url);
        driver.get(url);
    }

    public void openSmallModal() { showSmallModal.click(); }
    public void openLargeModal() { showLargeModal.click(); }
    public String getSmallModalTitle() { return smallModalTitle.getText(); }
    public String getLargeModalTitle() { return largeModalTitle.getText(); }
    public void closeSmall() { closeSmallModal.click(); }
    public void closeLarge() { closeLargeModal.click(); }
}
