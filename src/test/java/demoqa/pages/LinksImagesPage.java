package demoqa.pages;

import demoqa.base.BaseElement;
import demoqa.base.BasePage;
import demoqa.base.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LinksImagesPage extends BasePage {
    private final BaseElement linksSelector = new BaseElement(driver, By.id("item-6"));
    private final BaseElement validLink = new BaseElement(driver, By.linkText("Click Here for Valid Link"));
    private final BaseElement brokenLink = new BaseElement(driver, By.linkText("Click Here for Broken Link"));

    public LinksImagesPage() {
        super(WebDriverSingleton.driver);
    }

    public void clickOnLinksImagesPage(){
        linksSelector.click();
    }

    public boolean isValidLinkCorrect() {
        return validLink.getAttribute("href").contains("demoqa.com");
    }

    public boolean isBrokenLinkCorrect() {
        return brokenLink.getAttribute("href").contains("status_codes/500");
    }
}
