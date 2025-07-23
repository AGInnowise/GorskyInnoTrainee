package Pages.DemoqaPages.NeNashelKudaZakinut;

import Elements.BaseElement;
import Pages.BasePage;
import WebDriverManager.WebDriverSingleton;
import demoqa.base.BaseElement;
import demoqa.base.BasePage;
import demoqa.base.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WebTablesPage extends BasePage {

    private final BaseElement searchBox = new BaseElement(driver, By.id("searchBox"));
    private final BaseElement addButton = new BaseElement(driver, By.id("addNewRecordButton"));
    private final BaseElement firstNameInput = new BaseElement(driver, By.id("firstName"));
    private final BaseElement lastNameInput = new BaseElement(driver, By.id("lastName"));
    private final BaseElement emailInput = new BaseElement(driver, By.id("userEmail"));
    private final BaseElement ageInput = new BaseElement(driver, By.id("age"));
    private final BaseElement salaryInput = new BaseElement(driver, By.id("salary"));
    private final BaseElement departmentInput = new BaseElement(driver, By.id("department"));
    private final BaseElement submitButton = new BaseElement(driver, By.id("submit"));
    private final BaseElement webTablesSelector = new BaseElement(driver, By.id("item-3"));
    private final BaseElement totalPages = new BaseElement(driver, By.cssSelector(".-totalPages"));

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
