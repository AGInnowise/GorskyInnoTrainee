package Pages.DemoqaPages.OtherPage;
import Elements.ButtonElement.ButtonElement;
import Pages.BasePage;
import WebDriverManager.WebDriverSingleton;
import org.openqa.selenium.By;
import Helpers.Logger;

public class LinksPage extends BasePage {
    private final ButtonElement linksSelector = new ButtonElement(driver, By.id("item-5"));
    private final ButtonElement simpleLink = new ButtonElement(driver, By.id("simpleLink"));
    private final ButtonElement createdLink = new ButtonElement(driver, By.id("created"));
    private final ButtonElement linkResponse = new ButtonElement(driver, By.id("linkResponse"));

    public LinksPage( ) {
        super(WebDriverSingleton.driver);
        Logger.log("LinksPage: initialized");
    }

    public void clickOnLinksPage(){
        Logger.log("LinksPage: clickOnLinksPage");
        linksSelector.click();
    }

    public void clickSimpleLink() {
        Logger.log("LinksPage: clickSimpleLink");
        simpleLink.click();
    }

    public void clickCreatedLink() {
        Logger.log("LinksPage: clickCreatedLink");
        createdLink.click();
    }

    public String getLinkResponseText() {
        String text = linkResponse.getText();
        Logger.log("LinksPage: getLinkResponseText -> " + text);
        return text;
    }

    public void switchToNewTab() {
        Logger.log("LinksPage: switchToNewTab");
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
}
