package Pages.DemoqaPages.ElementsPage;

import Elements.ButtonElement.ButtonElement;
import Pages.BasePage;
import WebDriverManager.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import Helpers.Logger;

public class ButtonsPage extends BasePage {

    private final ButtonElement doubleClickBtn = new ButtonElement(driver, By.id("doubleClickBtn"));
    private final ButtonElement rightClickBtn = new ButtonElement(driver, By.id("rightClickBtn"));
    private final ButtonElement doubleClickMessage = new ButtonElement(driver, By.id("doubleClickMessage"));
    private final ButtonElement rightClickMessage = new ButtonElement(driver, By.id("rightClickMessage"));
    private final ButtonElement buttonsSelector = new ButtonElement(driver, By.id("item-4"));

    public ButtonsPage() {
        super(WebDriverSingleton.driver);
        Logger.log("ButtonsPage: initialized");
    }

    public void performDoubleClick() {
        Logger.log("ButtonsPage: performDoubleClick");
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickBtn.findElement()).perform();
    }

    public void performRightClick() {
        Logger.log("ButtonsPage: performRightClick");
        Actions actions = new Actions(driver);
        actions.contextClick(rightClickBtn.findElement()).perform();
    }

    public String getDoubleClickMessage() {
        String message = doubleClickMessage.getText();
        Logger.log("ButtonsPage: getDoubleClickMessage -> " + message);
        return message;
    }

    public String getRightClickMessage() {
        String message = rightClickMessage.getText();
        Logger.log("ButtonsPage: getRightClickMessage -> " + message);
        return message;
    }

    public void clickOnButtonsPage(){
        Logger.log("ButtonsPage: clickOnButtonsPage");
        buttonsSelector.click();
    }
}
