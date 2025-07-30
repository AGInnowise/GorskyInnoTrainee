package Pages.DemoqaPages.ElementsPage;

import Elements.ButtonElement.ButtonElement;
import Elements.TextBoxElement.TextBoxElement;
import Pages.BasePage;
import WebDriverManager.WebDriverSingleton;
import org.openqa.selenium.By;

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
