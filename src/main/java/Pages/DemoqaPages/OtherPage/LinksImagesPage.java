package Pages.DemoqaPages.OtherPage;

import Elements.ButtonElement.ButtonElement;
import Elements.TextBoxElement.TextBoxElement;
import Pages.BasePage;
import WebDriverManager.WebDriverSingleton;
import org.openqa.selenium.By;
import Helpers.Logger;

public class LinksImagesPage extends BasePage {
    private final ButtonElement linksSelector = new ButtonElement(driver, By.id("item-6"));
    private final TextBoxElement validLink = new TextBoxElement(driver, By.linkText("Click Here for Valid Link"));
    private final TextBoxElement brokenLink = new TextBoxElement(driver, By.linkText("Click Here for Broken Link"));

    public LinksImagesPage() {
        super(WebDriverSingleton.driver);
        Logger.log("LinksImagesPage: initialized");
    }

    public void clickOnLinksImagesPage(){
        Logger.log("LinksImagesPage: clickOnLinksImagesPage");
        linksSelector.click();
    }

    public boolean isValidLinkCorrect() {
        boolean result = validLink.getAttribute("href").contains("demoqa.com");
        Logger.log("LinksImagesPage: isValidLinkCorrect -> " + result);
        return result;
    }

    public boolean isBrokenLinkCorrect() {
        boolean result = brokenLink.getAttribute("href").contains("status_codes/500");
        Logger.log("LinksImagesPage: isBrokenLinkCorrect -> " + result);
        return result;
    }
}
