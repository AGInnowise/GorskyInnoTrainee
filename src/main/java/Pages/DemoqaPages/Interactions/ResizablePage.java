
package Pages.DemoqaPages.Interactions;

import Elements.BaseElement;
import Pages.BasePage;
import Helpers.Logger;
import WebDriverManager.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ResizablePage extends BasePage {
    private final BaseElement restrictedBox = new BaseElement(driver, By.id("resizableBoxWithRestriction"));
    private final By restrictedHandle = By.cssSelector("#resizableBoxWithRestriction .react-resizable-handle");
    private final BaseElement freeBox = new BaseElement(driver, By.id("resizable"));
    private final By freeHandle = By.cssSelector("#resizable .react-resizable-handle");

    public ResizablePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        String url = "https://demoqa.com/resizable";
        Logger.log("ResizablePage: open -> " + url);
        driver.get(url);
    }

    public Dimension getRestrictedSize() { return restrictedBox.getElement().getSize(); }
    public Dimension getFreeSize() { return freeBox.getElement().getSize(); }

    public void resizeRestrictedBy(int x, int y) {
        Logger.log("ResizablePage: resizeRestrictedBy -> " + x + "," + y);
        WebElement handle = driver.findElement(restrictedHandle);
        new Actions(WebDriverSingleton.driver).dragAndDropBy(handle, x, y).perform();
    }

    public void resizeFreeBy(int x, int y) {
        Logger.log("ResizablePage: resizeFreeBy -> " + x + "," + y);
        WebElement handle = driver.findElement(freeHandle);
        new Actions(WebDriverSingleton.driver).dragAndDropBy(handle, x, y).perform();
    }
}
