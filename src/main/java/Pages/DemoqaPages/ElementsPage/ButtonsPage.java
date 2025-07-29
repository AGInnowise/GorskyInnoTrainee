package Pages.DemoqaPages.ElementsPage;

import Elements.ButtonElement.ButtonElement;
import Pages.BasePage;
import WebDriverManager.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class ButtonsPage extends BasePage {

    private final ButtonElement doubleClickBtn = new ButtonElement(driver, By.id("doubleClickBtn"));
    private final ButtonElement rightClickBtn = new ButtonElement(driver, By.id("rightClickBtn"));
    private final ButtonElement doubleClickMessage = new ButtonElement(driver, By.id("doubleClickMessage"));
    private final ButtonElement rightClickMessage = new ButtonElement(driver, By.id("rightClickMessage"));
    private final ButtonElement buttonsSelector = new ButtonElement(driver, By.id("item-4"));

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
