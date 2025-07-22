package demoqa.pages;

import demoqa.base.BasePage;
import demoqa.base.WebDriverSingleton;
import demoqa.base.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;

public class ButtonsPage extends BasePage {

    private final BaseElement doubleClickBtn = new BaseElement(driver, By.id("doubleClickBtn"));
    private final BaseElement rightClickBtn = new BaseElement(driver, By.id("rightClickBtn"));
    private final BaseElement doubleClickMessage = new BaseElement(driver, By.id("doubleClickMessage"));
    private final BaseElement rightClickMessage = new BaseElement(driver, By.id("rightClickMessage"));
    private final BaseElement buttonsSelector = new BaseElement(driver, By.id("item-4"));

    public ButtonsPage() {
        super(WebDriverSingleton.driver);
    }

    public void performDoubleClick() {
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickBtn.findElement()).perform();
    }

    public void performRightClick() {
        Actions actions = new Actions(driver);
        actions.contextClick(rightClickBtn.findElement()).perform();
    }

    public String getDoubleClickMessage() {
        return doubleClickMessage.getText();
    }

    public String getRightClickMessage() {
        return rightClickMessage.getText();
    }

    public void clickOnButtonsPage(){
        buttonsSelector.click();
    }
}
