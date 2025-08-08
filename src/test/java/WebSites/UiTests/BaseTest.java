package WebSites.UiTests;

import Helpers.ScreenshotUtil;
import WebDriverManager.WebDriverSingleton;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.TestWatcher;
import org.junit.jupiter.api.extension.ExtensionContext;
import WebDriverManager.BrowserType;
import org.openqa.selenium.WebDriver;

/**
 * Базовый класс для всех тестов.
 * Инициализирует драйвер и завершает его после теста.
 */
@ExtendWith(BaseTest.ScreenshotOnFailureExtension.class)
public abstract class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = WebDriverSingleton.getDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        WebDriverSingleton.quitDriver();
    }

    static class ScreenshotOnFailureExtension implements TestWatcher {

        @Override
        public void testFailed(ExtensionContext context, Throwable cause) {
            System.out.println("⚠️ takeScreenshot called");// можно добавить лог или удалить
            ScreenshotUtil.takeScreenshot(WebDriverSingleton.getDriver());  // <--- обязательно вызвать!
        }

        @Override
        public void testSuccessful(ExtensionContext context) {
            System.out.println("⚠️ takeScreenshot IS NOT called");// можно добавить лог или удалить
        }
    }
}