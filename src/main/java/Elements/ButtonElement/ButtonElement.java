package Elements.ButtonElement;

import Elements.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ButtonElement extends BaseElement {
    WebDriver driver = super.getDriver();
    public ButtonElement(WebDriver driver, By locator) {
        super(driver, locator);
    }

    public void click() {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(super.timeoutInSeconds))
                .until(ExpectedConditions.elementToBeClickable(locator));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);

        element.click();
    }

    public void clickWithJS() {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(super.timeoutInSeconds))
                .until(ExpectedConditions.elementToBeClickable(locator));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
    // тут наследуемся от бейсЭлемента и просто добавляем методы для кнопки типичные
    // С другими элементами аналогично: наследуемся от бейсЭлемента и дописываем реализацаю
}
