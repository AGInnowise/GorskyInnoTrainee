package Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Обёртка над WebElement с удобными методами.
 */
public class BaseElement {
    private final WebDriver driver;
    protected final By locator;
    protected final int timeoutInSeconds = 10;

    public BaseElement(WebDriver driver, By locator) {
        this.driver = driver;
        this.locator = locator;
    }

    public WebElement findElement() {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getText() {
        return findElement().getText();
    }

    public String getValue() {
        return findElement().getAttribute("value");
    }

    public boolean isDisplayed() {
        try {
            return findElement().isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public By getLocator() {
        return locator;
    }

    public String getAttribute(String attributeName) {
        return findElement().getAttribute(attributeName);
    }

    public WebElement getElement() {
        return findElement();
    }
}