package Pages.DemoqaPages.ElementsPage;

import Elements.ButtonElement.ButtonElement;
import Elements.TextBoxElement.TextBoxElement;
import Pages.BasePage;
import WebDriverManager.WebDriverSingleton;
import org.openqa.selenium.By;
import Helpers.Logger;

public class TextBoxPage extends BasePage {
    private final ButtonElement textBoxMenuItem = new ButtonElement(driver, By.id("item-0"));
    private final TextBoxElement userNameInput = new TextBoxElement(driver, By.id("userName"));
    private final TextBoxElement userEmailInput = new TextBoxElement(driver, By.id("userEmail"));
    private final TextBoxElement currentAddressInput = new TextBoxElement(driver, By.id("currentAddress"));
    private final TextBoxElement permanentAddressInput = new TextBoxElement(driver, By.id("permanentAddress"));
    private final ButtonElement submitButton = new ButtonElement(driver, By.id("submit"));

    private final TextBoxElement resultName = new TextBoxElement(driver, By.id("name"));
    private final TextBoxElement resultEmail = new TextBoxElement(driver, By.id("email"));
    private final TextBoxElement resultCurrentAddress = new TextBoxElement(driver, By.id("currentAddress"));
    private final TextBoxElement resultPermanentAddress = new TextBoxElement(driver, By.id("permanentAddress"));

    private final TextBoxElement emailValidationError = new TextBoxElement(driver, By.className("field-error"));

    public TextBoxPage() {
        super(WebDriverSingleton.driver);
        Logger.log("TextBoxPage: initialized");
    }

    public void clickTextBox() {
        Logger.log("TextBoxPage: clickTextBox");
        textBoxMenuItem.click();
    }

    public void fillUsername(String username){
        Logger.log("TextBoxPage: fillUsername -> " + username);
        userNameInput.sendKeys(username);
    }

    public void fillEmail(String email){
        Logger.log("TextBoxPage: fillEmail -> " + email);
        userEmailInput.sendKeys(email);
    }

    public void fillCurrentAddress(String address){
        Logger.log("TextBoxPage: fillCurrentAddress -> " + address);
        currentAddressInput.sendKeys(address);
    }

    public void fillPermanentAddress(String address){
        Logger.log("TextBoxPage: fillPermanentAddress -> " + address);
        permanentAddressInput.sendKeys(address);
    }

    public void clickSubmitButton(){
        Logger.log("TextBoxPage: clickSubmitButton");
        submitButton.click();
    }

    public String getResultName(){
        String name = resultName.getText();
        Logger.log("TextBoxPage: getResultName -> " + name);
        return name;
    }

    public String getResultEmail(){
        String email = resultEmail.getText();
        Logger.log("TextBoxPage: getResultEmail -> " + email);
        return email;
    }

    public String getResultCurrentAddress(){
        String current = resultCurrentAddress.getValue();
        Logger.log("TextBoxPage: getResultCurrentAddress -> " + current);
        return current;
    }

    public String getResultPermanentAddress(){
        String permanent = resultPermanentAddress.getValue();
        Logger.log("TextBoxPage: getResultPermanentAddress -> " + permanent);
        return permanent;
    }

    public boolean isEmailValidationErrorVisible() {
        boolean visible = emailValidationError.isDisplayed();
        Logger.log("TextBoxPage: isEmailValidationErrorVisible -> " + visible);
        return visible;
    }
}
