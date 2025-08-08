package Pages.DemoqaPages.ElementsPage;

import Elements.BaseElement;
import Elements.ButtonElement.ButtonElement;
import Elements.TextBoxElement.TextBoxElement;
import Pages.BasePage;
import WebDriverManager.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Helpers.Logger;

public class RadioButtonPage extends BasePage {

    private final ButtonElement yesRadio = new ButtonElement(driver, By.id("yesRadio"));
    private final ButtonElement impressiveRadio = new ButtonElement(driver, By.id("impressiveRadio"));
    private final TextBoxElement resultText = new TextBoxElement(driver, By.className("text-success"));
    private final ButtonElement radioButtonSelector = new ButtonElement(driver, By.id("item-2"));

    public RadioButtonPage() {
        super(WebDriverSingleton.driver);
        Logger.log("RadioButtonPage: initialized");
    }

    public void clickRadioButtonPage() {
        Logger.log("RadioButtonPage: clickRadioButtonPage");
        radioButtonSelector.click();
    }

    public void clickYesRadio() {
        Logger.log("RadioButtonPage: clickYesRadio");
        WebDriver driver = WebDriverSingleton.driver;
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", yesRadio.getElement());
    }

    public void clickImpressiveRadio() {
        Logger.log("RadioButtonPage: clickImpressiveRadio");
        WebDriver driver = WebDriverSingleton.driver;
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", impressiveRadio.getElement());
    }

    public boolean isResultText(String expectedText) {
        String actual = resultText.getText();
        Logger.log("RadioButtonPage: isResultText -> expected: " + expectedText + ", actual: " + actual);
        return actual.equalsIgnoreCase(expectedText);
    }
}
