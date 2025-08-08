
package Pages.DemoqaPages.Interactions;

import Elements.BaseElement;
import Elements.ButtonElement.ButtonElement;
import Pages.BasePage;
import Helpers.Logger;
import WebDriverManager.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class DraggablePage extends BasePage {
    private final ButtonElement simpleTab = new ButtonElement(driver, By.id("draggableExample-tab-simple"));
    private final BaseElement draggable = new BaseElement(driver, By.id("dragBox"));

    public DraggablePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        String url = "https://demoqa.com/dragabble";
        Logger.log("DraggablePage: open -> " + url);
        driver.get(url);
    }

    public Point getDraggableLocation() {
        return draggable.getElement().getLocation();
    }

    public void dragBy(int xOffset, int yOffset) {
        Logger.log("DraggablePage: dragBy -> " + xOffset + "," + yOffset);
        Actions actions = new Actions(WebDriverSingleton.driver);
        actions.dragAndDropBy(draggable.getElement(), xOffset, yOffset).perform();
    }
}
