package WebDriverManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverFactory {
    public static WebDriver createDriver(BrowserType type) {
        switch (type) {
            case CHROME:
                // Автоматически скачиваем и настраиваем ChromeDriver
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case SAFARI:
                // Для Safari на macOS: убедитесь, что `safaridriver` включён (sudo safaridriver --enable)
                return new SafariDriver();
            default:
                throw new IllegalArgumentException("Unsupported browser: " + type);
        }
    }
}