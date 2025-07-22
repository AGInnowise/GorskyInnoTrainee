package demoqa.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverSingleton {
    public static WebDriver driver;

    private WebDriverSingleton() {}

    public static WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--headless"); // или просто "--headless" для старых версий
//            options.addArguments("--disable-gpu");
//            options.addArguments("--window-size=1920,1080");
//            options.addArguments("--remote-allow-origins=*");

            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}