package demoqa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Базовый класс для всех Page Object.
 * Содержит общие действия и конструктор инициализации элементов.
 */
public abstract class BasePage {
    protected WebDriver driver;
    private final String basePage = ConfigReader.get("baseUrl");

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Пример универсального метода
    public String getPageTitle() {
        return driver.getTitle();
    }

    public void navigateToBasePage(){
        driver.get(basePage);
    }
}