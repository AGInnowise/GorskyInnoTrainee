
package Pages.DemoqaPages.Interactions;

import Elements.BaseElement;
import Elements.ButtonElement.ButtonElement;
import Pages.BasePage;
import Helpers.Logger;
import WebDriverManager.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class DroppablePage extends BasePage {
    private final ButtonElement simpleTab = new ButtonElement(driver, By.id("droppableExample-tab-simple"));
    private final BaseElement draggable = new BaseElement(driver, By.id("draggable"));
    private final BaseElement droppable = new BaseElement(driver, By.id("droppable"));

    public DroppablePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        String url = "https://demoqa.com/droppable";
        Logger.log("DroppablePage: open -> " + url);
        driver.get(url);
    }

    public void dragToDropBox() {
        Logger.log("DroppablePage: dragToDropBox");
        new Actions(WebDriverSingleton.driver)
                .dragAndDrop(draggable.getElement(), droppable.getElement())
                .perform();
    }

    public String getDropBoxText() { return droppable.getText(); }

    public boolean isDroppedState() {
        return getDropBoxText().toLowerCase().contains("dropped");
    }
}
