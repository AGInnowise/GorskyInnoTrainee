package Pages.DemoqaPages.ElementsPage;

import Elements.BaseElement;
import Pages.BasePage;
import WebDriverManager.WebDriverSingleton;
import demoqa.base.BaseElement;
import demoqa.base.BasePage;
import demoqa.base.ConfigReader;
import demoqa.base.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextBoxPage extends BasePage {
    private final BaseElement textBoxMenuItem = new BaseElement(driver, By.id("item-0"));
    private final BaseElement userNameInput = new BaseElement(driver, By.id("userName"));
    private final BaseElement userEmailInput = new BaseElement(driver, By.id("userEmail"));
    private final BaseElement currentAddressInput = new BaseElement(driver, By.id("currentAddress"));
    private final BaseElement permanentAddressInput = new BaseElement(driver, By.id("permanentAddress"));
    private final BaseElement submitButton = new BaseElement(driver, By.id("submit"));

    private final BaseElement resultName = new BaseElement(driver, By.id("name"));
    private final BaseElement resultEmail = new BaseElement(driver, By.id("email"));
    private final BaseElement resultCurrentAddress = new BaseElement(driver, By.id("currentAddress"));
    private final BaseElement resultPermanentAddress = new BaseElement(driver, By.id("permanentAddress"));

    private final BaseElement emailValidationError = new BaseElement(driver, By.className("field-error"));

    public TextBoxPage() {
        super(WebDriverSingleton.driver);
    }

    public void clickTextBox() {
        textBoxMenuItem.click();
    }

    public void fillUsername(String username){
        userNameInput.sendKeys(username);
    }

    public void fillEmail(String email){
        userEmailInput.sendKeys(email);
    }

    public void fillCurrentAddress(String address){
        currentAddressInput.sendKeys(address);
    }

    public void fillPermanentAddress(String address){
        permanentAddressInput.sendKeys(address);
    }

    public void clickSubmitButton(){
        submitButton.click();
    }

    public String getResultName(){
        return resultName.getText();
    }

    public String getResultEmail(){
        return resultEmail.getText();
    }

    public String getResultCurrentAddress(){
        return resultCurrentAddress.getValue();
    }

    public String getResultPermanentAddress(){
        return resultPermanentAddress.getValue();
    }

    public boolean isEmailValidationErrorVisible() {
        return emailValidationError.isDisplayed();
    }
}
