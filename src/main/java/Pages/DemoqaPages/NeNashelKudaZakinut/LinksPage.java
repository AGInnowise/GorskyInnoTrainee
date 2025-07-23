package Pages.DemoqaPages.NeNashelKudaZakinut;

import Elements.BaseElement;
import Pages.BasePage;
import WebDriverManager.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import demoqa.base.BaseElement;
import demoqa.base.BasePage;
import demoqa.base.WebDriverSingleton;
import org.openqa.selenium.By;

public class LinksPage extends BasePage {
    private final BaseElement linksSelector = new BaseElement(driver, By.id("item-5"));
    private final BaseElement simpleLink = new BaseElement(driver, By.id("simpleLink"));
    private final BaseElement createdLink = new BaseElement(driver, By.id("created"));
    private final BaseElement linkResponse = new BaseElement(driver, By.id("linkResponse"));

    public LinksPage( ) {
        super(WebDriverSingleton.driver);
    }

    public void clickOnLinksPage(){
        linksSelector.click();
    }

    public void clickSimpleLink() {
        simpleLink.click();
    }

    public void clickCreatedLink() {
        createdLink.click();
    }

    public String getLinkResponseText() {
        return linkResponse.getText();
    }

    public void switchToNewTab() {
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
}
