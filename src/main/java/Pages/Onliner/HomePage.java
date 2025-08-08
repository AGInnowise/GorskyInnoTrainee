package Pages.Onliner;

import Elements.ButtonElement.ButtonElement;
import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Helpers.Logger;

public class HomePage extends BasePage {
    private final ButtonElement mobilePhones = new ButtonElement(driver, By.xpath("//a[contains(@class, 'project-navigation__link') and @href='https://catalog.onliner.by/mobile']"));
    private final ButtonElement submitCookiesButton = new ButtonElement(driver, By.id("submit-button"));

    public HomePage(WebDriver driver) {
        super(driver);
        Logger.log("HomePage: initialized");
    }

    public void clickOnMobilePhonesLink(){
        Logger.log("HomePage: clickOnMobilePhonesLink");
        mobilePhones.clickWithJS();
    }
    public void clickSubmitCookies(){
        Logger.log("HomePage: clickSubmitCookies");
        submitCookiesButton.clickWithJS();
    }
}
