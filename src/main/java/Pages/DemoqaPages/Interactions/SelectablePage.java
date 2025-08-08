
package Pages.DemoqaPages.Interactions;

import Elements.BaseElement;
import Elements.ButtonElement.ButtonElement;
import Pages.BasePage;
import Helpers.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class SelectablePage extends BasePage {
    private final ButtonElement listTab = new ButtonElement(driver, By.id("demo-tab-list"));
    private final ButtonElement gridTab = new ButtonElement(driver, By.id("demo-tab-grid"));

    private final By listItems = By.cssSelector("#verticalListContainer li");
    private final By gridItems = By.cssSelector("#gridContainer .list-group-item");

    public SelectablePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        String url = "https://demoqa.com/selectable";
        Logger.log("SelectablePage: open -> " + url);
        driver.get(url);
    }

    public void selectListItem(int index0based) {
        listTab.click();
        java.util.List<WebElement> items = driver.findElements(listItems);
        items.get(index0based).click();
    }

    public void selectGridItemByText(String text) {
        gridTab.click();
        for (WebElement el : driver.findElements(gridItems)) {
            if (el.getText().trim().equalsIgnoreCase(text.trim())) {
                el.click();
                break;
            }
        }
    }

    public boolean isAnyListItemActive() {
        return driver.findElements(listItems).stream().anyMatch(e -> e.getAttribute("class").toLowerCase().contains("active"));
    }

    public boolean isGridItemActive(String text) {
        for (WebElement el : driver.findElements(gridItems)) {
            if (el.getText().trim().equalsIgnoreCase(text.trim())) {
                return el.getAttribute("class").toLowerCase().contains("active");
            }
        }
        return false;
    }
}
