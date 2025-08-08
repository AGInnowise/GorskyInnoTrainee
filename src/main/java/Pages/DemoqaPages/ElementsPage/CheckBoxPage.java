package Pages.DemoqaPages.ElementsPage;

import Elements.ButtonElement.ButtonElement;
import Pages.BasePage;
import WebDriverManager.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import Helpers.Logger;

public class CheckBoxPage extends BasePage {

    private final ButtonElement expandAllButton = new ButtonElement(driver, By.className("rct-icon-expand-all"));
    private final ButtonElement mainCheckBox = new ButtonElement(driver, By.xpath("//label[@for='tree-node-home']/span[1]"));
    private final ButtonElement commandsText = new ButtonElement(driver, By.xpath("//span[contains(text(), 'Commands')]"));
    private final ButtonElement angularText = new ButtonElement(driver, By.xpath("//span[contains(text(), 'Angular')]"));


    private final By checkedCheckboxLocator = By.className("rct-icon-check");
    private final By uncheckedCheckboxLocator = By.className("rct-icon-uncheck");

    private final By results = By.cssSelector(".text-success");

    private final ButtonElement checkBoxSelector = new ButtonElement(driver, By.id("item-1"));

    public CheckBoxPage() {
        super(WebDriverSingleton.driver);
        Logger.log("CheckBoxPage: initialized");
    }

    public void navigateToCheckBoxPage(){
        Logger.log("CheckBoxPage: navigateToCheckBoxPage");
        checkBoxSelector.click();
    }

    public void clickExpandAllButton() {
        Logger.log("CheckBoxPage: clickExpandAllButton");
        expandAllButton.click();
    }

    public void clickMainCheckBox() {
        Logger.log("CheckBoxPage: clickMainCheckBox");
        mainCheckBox.click();
    }

    public void clickCommandsText() {
        Logger.log("CheckBoxPage: clickCommandsText");
        commandsText.click();
    }

    public void clickAngularText() {
        Logger.log("CheckBoxPage: clickAngularText");
        angularText.click();
    }

    public boolean areAllCheckboxesSelected() {
        boolean allSelected = driver.findElements(uncheckedCheckboxLocator).size() == 0;
        Logger.log("CheckBoxPage: areAllCheckboxesSelected -> " + allSelected);
        return allSelected;
    }

    public boolean isSelectedCheckBoxesInResult(String elementText) {
        Logger.log("CheckBoxPage: isSelectedCheckBoxesInResult for " + elementText);
        boolean isTrue = false;
        List<WebElement> resultsList = driver.findElements(results);
        for (WebElement element : resultsList) {
            if (element.getText().contains(elementText.toLowerCase())) {
                isTrue = true;
            }
        }
        Logger.log("CheckBoxPage: isSelectedCheckBoxesInResult -> " + isTrue);
        return isTrue;
    }
}
