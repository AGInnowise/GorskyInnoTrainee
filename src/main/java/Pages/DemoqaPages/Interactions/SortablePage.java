
package Pages.DemoqaPages.Interactions;

import Elements.ButtonElement.ButtonElement;
import Pages.BasePage;
import Helpers.Logger;
import WebDriverManager.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.List;
import java.util.stream.Collectors;

public class SortablePage extends BasePage {
    private final ButtonElement listTab = new ButtonElement(driver, By.id("demo-tab-list"));
    private final ButtonElement gridTab = new ButtonElement(driver, By.id("demo-tab-grid"));
    private final By listItems = By.cssSelector("#demo-tabpane-list .list-group-item");
    private final By gridItems = By.cssSelector("#demo-tabpane-grid .list-group-item");

    public SortablePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        String url = "https://demoqa.com/sortable";
        Logger.log("SortablePage: open -> " + url);
        driver.get(url);
    }

    public java.util.List<String> getListOrder() {
        return driver.findElements(listItems).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void dragListItemTo(int fromIndex, int toIndex) {
        listTab.click();
        java.util.List<WebElement> items = driver.findElements(listItems);
        WebElement source = items.get(fromIndex);
        WebElement target = items.get(toIndex);
        new Actions(WebDriverSingleton.driver).clickAndHold(source).moveToElement(target).release().perform();
    }
}
