package Pages.DemoqaPages.OtherPage;

import Elements.ButtonElement.ButtonElement;
import Elements.TextBoxElement.TextBoxElement;
import Pages.BasePage;
import WebDriverManager.WebDriverSingleton;
import org.openqa.selenium.By;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import Helpers.Logger;

public class WebTablesPage extends BasePage {

    private final TextBoxElement searchBox = new TextBoxElement(driver, By.id("searchBox"));
    private final ButtonElement addButton = new ButtonElement(driver, By.id("addNewRecordButton"));
    private final TextBoxElement firstNameInput = new TextBoxElement(driver, By.id("firstName"));
    private final TextBoxElement lastNameInput = new TextBoxElement(driver, By.id("lastName"));
    private final TextBoxElement emailInput = new TextBoxElement(driver, By.id("userEmail"));
    private final TextBoxElement ageInput = new TextBoxElement(driver, By.id("age"));
    private final TextBoxElement salaryInput = new TextBoxElement(driver, By.id("salary"));
    private final TextBoxElement departmentInput = new TextBoxElement(driver, By.id("department"));
    private final ButtonElement submitButton = new ButtonElement(driver, By.id("submit"));
    private final ButtonElement webTablesSelector = new ButtonElement(driver, By.id("item-3"));
    private final TextBoxElement totalPages = new TextBoxElement(driver, By.cssSelector(".-totalPages"));

    public WebTablesPage() {
        super(WebDriverSingleton.driver);
        Logger.log("WebTablesPage: initialized");
    }

    public void search(String searchText){
        Logger.log("WebTablesPage: search -> " + searchText);
        searchBox.sendKeys(searchText);
    }

    public void clearSearch(){
        Logger.log("WebTablesPage: clearSearch");
        searchBox.sendKeys("");
    }

    public void clickAddButton(){
        Logger.log("WebTablesPage: clickAddButton");
        addButton.click();
    }

    public void fillUserName(String username){
        Logger.log("WebTablesPage: fillUserName -> " + username);
        firstNameInput.sendKeys(username);
    }

    public void fillLastName(String lastName){
        Logger.log("WebTablesPage: fillLastName -> " + lastName);
        lastNameInput.sendKeys(lastName);
    }

    public void fillEmail(String email){
        Logger.log("WebTablesPage: fillEmail -> " + email);
        emailInput.sendKeys(email);
    }

    public void fillAge(String age){
        Logger.log("WebTablesPage: fillAge -> " + age);
        ageInput.sendKeys(age);
    }

    public void fillSalary(String salary){
        Logger.log("WebTablesPage: fillSalary -> " + salary);
        salaryInput.sendKeys(salary);
    }

    public void fillDepartment(String department){
        Logger.log("WebTablesPage: fillDepartment -> " + department);
        departmentInput.sendKeys(department);
    }

    public void submitForm(){
        Logger.log("WebTablesPage: submitForm");
        submitButton.click();
    }

    public void clickWebTablesPage(){
        Logger.log("WebTablesPage: clickWebTablesPage");
        webTablesSelector.click();
    }
    public boolean isTextPresentInTable(String text) {
        Logger.log("WebTablesPage: isTextPresentInTable -> " + text);
        List<WebElement> elements = driver.findElements(By.className("rt-td"));
        for (WebElement element : elements) {
            if (element.getText().contains(text)) {
                Logger.log("WebTablesPage: isTextPresentInTable -> found");
                return true;
            }
        }
        Logger.log("WebTablesPage: isTextPresentInTable -> not found");
        return false;
    }

    public void fillFormWithDefaultData(){
        Logger.log("WebTablesPage: fillFormWithDefaultData");
        clickAddButton();
        fillUserName("Alexander");
        fillLastName("Gorsky");
        fillAge("77");
        fillEmail("test@gmail.com");
        fillDepartment("QA");
        fillSalary("100000000");
        submitForm();
    }

    public String getTotalPages(){
        String pages = totalPages.getText();
        Logger.log("WebTablesPage: getTotalPages -> " + pages);
        return pages;
    }

    public void select5RowsInDropdown() {
        Logger.log("WebTablesPage: select5RowsInDropdown");
        WebElement dropdown = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("select[aria-label='rows per page']")));
        Select select = new Select(dropdown);
        select.selectByValue("5");
    }
}
