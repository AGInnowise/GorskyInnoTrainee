package Elements.ButtonElement;

import Elements.BaseElement;
import WebDriverManager.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ButtonElement extends BaseElement {
    WebDriverSingleton driver = new WebDriverSingleton();
    public ButtonElement(WebDriver driver, By locator) {
        super(driver, locator);
    }

    public void click() {
        WebElement element = new WebDriverWait((WebDriver) driver, Duration.ofSeconds(super.timeoutInSeconds))
                .until(ExpectedConditions.elementToBeClickable(locator));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);

        element.click();
    }
    // тут наследуемся от бейсЭлемента и просто добавляем методы для кнопки типичные
    // С другими элементами аналогично: наследуемся от бейсЭлемента и дописываем реализацаю
}
