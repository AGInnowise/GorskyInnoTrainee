package Elements.TextBoxElement;

import Elements.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextBoxElement extends BaseElement {
    public TextBoxElement(WebDriver driver, By locator) {
        super(driver, locator);
    }

    public void sendKeys(String text) {
        WebElement element = findElement();
        element.clear();
        element.sendKeys(text);
    }
}
