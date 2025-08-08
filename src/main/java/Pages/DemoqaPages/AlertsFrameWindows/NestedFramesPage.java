
package Pages.DemoqaPages.AlertsFrameWindows;

import Elements.BaseElement;
import Pages.BasePage;
import Helpers.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import WebDriverManager.WebDriverSingleton;

public class NestedFramesPage extends BasePage {
    private final BaseElement parentFrame = new BaseElement(driver, By.id("frame1"));
    private final By childIframe = By.cssSelector("iframe");
    private final By parentText = By.cssSelector("body");
    private final By childText = By.cssSelector("p");

    public NestedFramesPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        String url = "https://demoqa.com/nestedframes";
        Logger.log("NestedFramesPage: open -> " + url);
        driver.get(url);
    }

    public String getParentText() {
        WebDriver drv = WebDriverSingleton.driver;
        drv.switchTo().frame(parentFrame.getElement());
        String text = driver.findElement(parentText).getText();
        drv.switchTo().defaultContent();
        return text;
    }

    public String getChildText() {
        WebDriver drv = WebDriverSingleton.driver;
        drv.switchTo().frame(parentFrame.getElement());
        drv.switchTo().frame(driver.findElement(childIframe));
        String text = driver.findElement(childText).getText();
        drv.switchTo().defaultContent();
        return text;
    }
}
