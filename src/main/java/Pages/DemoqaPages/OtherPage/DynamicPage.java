package Pages.DemoqaPages.OtherPage;

import Elements.ButtonElement.ButtonElement;
import Pages.BasePage;
import WebDriverManager.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DynamicPage extends BasePage {
    private final ButtonElement dynamicSelector = new ButtonElement(driver, By.id("item-8"));

    private final By colorChangeButton = By.id("colorChange");
    private final By visibleAfterButton = By.id("visibleAfter");
    private String initialColor;

    public DynamicPage() {
        super(WebDriverSingleton.driver);
    }

    public void clickDynamicPage() {
        dynamicSelector.click();
    }

    public void storeInitialColor() {
        WebElement element = driver.findElement(colorChangeButton);
        initialColor = element.getCssValue("color");
    }

    public boolean isVisibleAfterButtonNotPresent() {
        return driver.findElements(visibleAfterButton).isEmpty();
    }

    public boolean isColorChanged() {
        String newColor = driver.findElement(colorChangeButton).getCssValue("color");
        return !newColor.equals(initialColor);
    }

    public boolean isVisibleAfterButtonPresent() {
        return !driver.findElements(visibleAfterButton).isEmpty();
    }

}
