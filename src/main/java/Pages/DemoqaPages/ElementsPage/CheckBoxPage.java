package Pages.DemoqaPages.ElementsPage;

import Elements.ButtonElement.ButtonElement;
import Pages.BasePage;
import WebDriverManager.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

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
    }

    public void navigateToCheckBoxPage(){
        checkBoxSelector.click();
    }

    public void clickExpandAllButton() {
        expandAllButton.click();
    }

    public void clickMainCheckBox() {
        mainCheckBox.click();
    }

    public void clickCommandsText() {
        commandsText.click();
    }

    public void clickAngularText() {
        angularText.click();
    }

    public boolean areAllCheckboxesSelected() {
        return driver.findElements(uncheckedCheckboxLocator).size() == 0;
    }

    public boolean isSelectedCheckBoxesInResult(String elementText) {
        boolean isTrue = false;

        List<WebElement> resultsList = driver.findElements(results);
        for(WebElement element : resultsList){
            if(element.getText().contains(elementText.toLowerCase())){
                isTrue = true;
            }
        }
        return isTrue;
    }
}
