package demoqa.tests;

import demoqa.base.BaseTest;
import demoqa.pages.WebTablesPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;

import static demoqa.base.WebDriverSingleton.driver;

public class WebTablesTests extends BaseTest {

    @Test
    public void checkAddedRecordTest(){
        WebTablesPage webTablesPage = new WebTablesPage();
        String searchText = "Gorsky";

        webTablesPage.navigateToBasePage();
        webTablesPage.clickWebTablesPage();

        webTablesPage.fillFormWithDefaultData();

        webTablesPage.search(searchText);
        Assertions.assertTrue(webTablesPage.isTextPresentInTable(searchText));
    }

    @Test
    public void checkPaginationTest(){
        WebTablesPage webTablesPage = new WebTablesPage();

        webTablesPage.navigateToBasePage();
        webTablesPage.clickWebTablesPage();
        webTablesPage.select5RowsInDropdown();

        webTablesPage.fillFormWithDefaultData();
        webTablesPage.fillFormWithDefaultData();
        webTablesPage.fillFormWithDefaultData();

        Assertions.assertTrue(webTablesPage.getTotalPages().equals("2"));
    }
}
