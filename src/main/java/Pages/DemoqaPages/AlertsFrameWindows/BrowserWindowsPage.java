
package Pages.DemoqaPages.AlertsFrameWindows;

import Elements.ButtonElement.ButtonElement;
import Pages.BasePage;
import Helpers.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import WebDriverManager.WebDriverSingleton;
import java.util.ArrayList;

public class BrowserWindowsPage extends BasePage {
    private final ButtonElement tabButton = new ButtonElement(driver, By.id("tabButton"));
    private final ButtonElement windowButton = new ButtonElement(driver, By.id("windowButton"));

    public BrowserWindowsPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        String url = "https://demoqa.com/browser-windows";
        Logger.log("BrowserWindowsPage: open -> " + url);
        driver.get(url);
    }

    public void openNewTab() { Logger.log("BrowserWindowsPage: openNewTab"); tabButton.click(); }
    public void openNewWindow() { Logger.log("BrowserWindowsPage: openNewWindow"); windowButton.click(); }

    public void switchToNewestWindow() {
        Logger.log("BrowserWindowsPage: switchToNewestWindow");
        WebDriver drv = WebDriverSingleton.driver;
        java.util.ArrayList<String> handles = new java.util.ArrayList<>(drv.getWindowHandles());
        drv.switchTo().window(handles.get(handles.size()-1));
    }
}
