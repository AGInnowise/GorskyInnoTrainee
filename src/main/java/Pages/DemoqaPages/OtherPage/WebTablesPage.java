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
    }

    public void search(String searchText){
        searchBox.sendKeys(searchText);
    }

    public void clearSearch(){
        searchBox.sendKeys("");
    }

    public void clickAddButton(){
        addButton.click();
    }

    public void fillUserName(String username){
        firstNameInput.sendKeys(username);
    }

    public void fillLastName(String lastName){
        lastNameInput.sendKeys(lastName);
    }

    public void fillEmail(String email){
        emailInput.sendKeys(email);
    }

    public void fillAge(String age){
        ageInput.sendKeys(age);
    }

    public void fillSalary(String salary){
        salaryInput.sendKeys(salary);
    }

    public void fillDepartment(String department){
        departmentInput.sendKeys(department);
    }

    public void submitForm(){
        submitButton.click();
    }

    public void clickWebTablesPage(){
        webTablesSelector.click();
    }
    public boolean isTextPresentInTable(String text) {
        List<WebElement> elements = driver.findElements(By.className("rt-td"));
        for (WebElement element : elements) {
            if (element.getText().contains(text)) {
                return true;
            }
        }
        return false;
    }

    public void fillFormWithDefaultData(){
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
        return totalPages.getText();
    }

    public void select5RowsInDropdown() {
        WebElement dropdown = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("select[aria-label='rows per page']")));
        Select select = new Select(dropdown);
        select.selectByValue("5");
    }
}
