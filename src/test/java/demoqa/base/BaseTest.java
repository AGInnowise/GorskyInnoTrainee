package demoqa.base;

import demoqa.utils.ScreenshotUtil;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.TestWatcher;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static demoqa.base.WebDriverSingleton.driver;
import static demoqa.utils.ScreenshotUtil.takeScreenshot;

import java.util.Optional;

/**
 * Базовый класс для всех тестов.
 * Инициализирует драйвер и завершает его после теста.
 */
@ExtendWith(BaseTest.ScreenshotOnFailureExtension.class)
public abstract class BaseTest {

    @BeforeAll
    public static void setUp() {
        driver = WebDriverSingleton.getDriver();
        driver.manage().window().maximize();
    }

//    @AfterAll
//    public static void tearDown() {
//        driver.quit();
//    }

    static class ScreenshotOnFailureExtension implements TestWatcher {

        @Override
        public void testFailed(ExtensionContext context, Throwable cause) {
            System.out.println("⚠️ takeScreenshot called");// можно добавить лог или удалить
            ScreenshotUtil.takeScreenshot(WebDriverSingleton.driver);  // <--- обязательно вызвать!
        }

        @Override
        public void testSuccessful(ExtensionContext context) {
            System.out.println("⚠️ takeScreenshot IS NOT called");// можно добавить лог или удалить
        }
    }
}