package demoqa.pages;

import demoqa.base.BasePage;
import demoqa.base.BaseElement;
import demoqa.base.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RadioButtonPage extends BasePage {

    private final BaseElement yesRadio = new BaseElement(driver, By.id("yesRadio"));
    private final BaseElement impressiveRadio = new BaseElement(driver, By.id("impressiveRadio"));
    private final BaseElement resultText = new BaseElement(driver, By.className("text-success"));
    private final BaseElement radioButtonSelector = new BaseElement(driver, By.id("item-2"));

    public RadioButtonPage() {
        super(WebDriverSingleton.driver);
    }

    public void clickRadioButtonPage() {
        radioButtonSelector.click();
    }

    public void clickYesRadio() {
        yesRadio.click();
    }

    public void clickImpressiveRadio() {
        impressiveRadio.click();
    }

    public boolean isResultText(String expectedText) {
        return resultText.getText().equalsIgnoreCase(expectedText);
    }
}
