package Pages.DemoqaPages.OtherPage;

import Elements.ButtonElement.ButtonElement;
import Pages.BasePage;
import WebDriverManager.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Helpers.Logger;

public class DynamicPage extends BasePage {
    private final ButtonElement dynamicSelector = new ButtonElement(driver, By.id("item-8"));

    private final By colorChangeButton = By.id("colorChange");
    private final By visibleAfterButton = By.id("visibleAfter");
    private String initialColor;

    public DynamicPage() {
        super(WebDriverSingleton.driver);
        Logger.log("DynamicPage: initialized");
    }

    public void clickDynamicPage() {
        Logger.log("DynamicPage: clickDynamicPage");
        dynamicSelector.click();
    }

    public void storeInitialColor() {
        Logger.log("DynamicPage: storeInitialColor");
        WebElement element = driver.findElement(colorChangeButton);
        initialColor = element.getCssValue("color");
        Logger.log("DynamicPage: initialColor stored -> " + initialColor);
    }

    public boolean isVisibleAfterButtonNotPresent() {
        boolean result = driver.findElements(visibleAfterButton).isEmpty();
        Logger.log("DynamicPage: isVisibleAfterButtonNotPresent -> " + result);
        return result;
    }

    public boolean isColorChanged() {
        String newColor = driver.findElement(colorChangeButton).getCssValue("color");
        boolean result = !newColor.equals(initialColor);
        Logger.log("DynamicPage: isColorChanged -> " + result + " (initial: " + initialColor + ", new: " + newColor + ")");
        return result;
    }

    public boolean isVisibleAfterButtonPresent() {
        boolean result = !driver.findElements(visibleAfterButton).isEmpty();
        Logger.log("DynamicPage: isVisibleAfterButtonPresent -> " + result);
        return result;
    }

}
