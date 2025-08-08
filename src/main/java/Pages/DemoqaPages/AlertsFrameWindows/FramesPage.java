
package Pages.DemoqaPages.AlertsFrameWindows;

import Elements.BaseElement;
import Pages.BasePage;
import Helpers.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import WebDriverManager.WebDriverSingleton;

public class FramesPage extends BasePage {
    private final BaseElement frame1 = new BaseElement(driver, By.id("frame1"));
    private final BaseElement frame2 = new BaseElement(driver, By.id("frame2"));
    private final By innerHeader = By.id("sampleHeading");

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        String url = "https://demoqa.com/frames";
        Logger.log("FramesPage: open -> " + url);
        driver.get(url);
    }

    public String getFrame1Heading() {
        WebDriver drv = WebDriverSingleton.driver;
        drv.switchTo().frame(frame1.getElement());
        String text = driver.findElement(innerHeader).getText();
        drv.switchTo().defaultContent();
        return text;
    }

    public String getFrame2Heading() {
        WebDriver drv = WebDriverSingleton.driver;
        drv.switchTo().frame(frame2.getElement());
        String text = driver.findElement(innerHeader).getText();
        drv.switchTo().defaultContent();
        return text;
    }
}
