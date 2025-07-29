package Pages.DemoqaPages.OtherPage;
import Elements.ButtonElement.ButtonElement;
import Pages.BasePage;
import WebDriverManager.WebDriverSingleton;
import org.openqa.selenium.By;

public class LinksPage extends BasePage {
    private final ButtonElement linksSelector = new ButtonElement(driver, By.id("item-5"));
    private final ButtonElement simpleLink = new ButtonElement(driver, By.id("simpleLink"));
    private final ButtonElement createdLink = new ButtonElement(driver, By.id("created"));
    private final ButtonElement linkResponse = new ButtonElement(driver, By.id("linkResponse"));

    public LinksPage( ) {
        super(WebDriverSingleton.driver);
    }

    public void clickOnLinksPage(){
        linksSelector.click();
    }

    public void clickSimpleLink() {
        simpleLink.click();
    }

    public void clickCreatedLink() {
        createdLink.click();
    }

    public String getLinkResponseText() {
        return linkResponse.getText();
    }

    public void switchToNewTab() {
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
}
