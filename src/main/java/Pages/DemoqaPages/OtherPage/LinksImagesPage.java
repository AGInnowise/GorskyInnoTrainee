package Pages.DemoqaPages.OtherPage;

import Elements.ButtonElement.ButtonElement;
import Elements.TextBoxElement.TextBoxElement;
import Pages.BasePage;
import WebDriverManager.WebDriverSingleton;
import org.openqa.selenium.By;

public class LinksImagesPage extends BasePage {
    private final ButtonElement linksSelector = new ButtonElement(driver, By.id("item-6"));
    private final TextBoxElement validLink = new TextBoxElement(driver, By.linkText("Click Here for Valid Link"));
    private final TextBoxElement brokenLink = new TextBoxElement(driver, By.linkText("Click Here for Broken Link"));

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
