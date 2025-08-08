
package Pages.DemoqaPages.AlertsFrameWindows;

import Elements.ButtonElement.ButtonElement;
import Elements.BaseElement;
import Pages.BasePage;
import Helpers.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import WebDriverManager.WebDriverSingleton;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AlertsPage extends BasePage {
    private final ButtonElement alertButton = new ButtonElement(driver, By.id("alertButton"));
    private final ButtonElement timerAlertButton = new ButtonElement(driver, By.id("timerAlertButton"));
    private final ButtonElement confirmButton = new ButtonElement(driver, By.id("confirmButton"));
    private final ButtonElement promptButton = new ButtonElement(driver, By.id("promtButton")); // demoqa typo
    private final BaseElement confirmResult = new BaseElement(driver, By.id("confirmResult"));
    private final BaseElement promptResult = new BaseElement(driver, By.id("promptResult"));

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        String url = "https://demoqa.com/alerts";
        Logger.log("AlertsPage: open -> " + url);
        driver.get(url);
    }

    public void triggerImmediateAlertAndAccept() {
        Logger.log("AlertsPage: triggerImmediateAlertAndAccept");
        alertButton.click();
        WebDriver drv = WebDriverSingleton.driver;
        drv.switchTo().alert().accept();
    }

    public void triggerTimerAlertAndAccept() {
        Logger.log("AlertsPage: triggerTimerAlertAndAccept");
        timerAlertButton.click();
        WebDriver drv = WebDriverSingleton.driver;
        new WebDriverWait(drv, Duration.ofSeconds(7)).until(ExpectedConditions.alertIsPresent());
        drv.switchTo().alert().accept();
    }

    public void triggerConfirm(boolean accept) {
        Logger.log("AlertsPage: triggerConfirm -> " + (accept ? "accept" : "dismiss"));
        confirmButton.click();
        WebDriver drv = WebDriverSingleton.driver;
        if (accept) drv.switchTo().alert().accept();
        else drv.switchTo().alert().dismiss();
    }

    public void triggerPrompt(String text) {
        Logger.log("AlertsPage: triggerPrompt -> " + text);
        promptButton.click();
        WebDriver drv = WebDriverSingleton.driver;
        drv.switchTo().alert().sendKeys(text);
        drv.switchTo().alert().accept();
    }

    public String getConfirmResultText() { return confirmResult.getText(); }
    public String getPromptResultText() { return promptResult.getText(); }
}
