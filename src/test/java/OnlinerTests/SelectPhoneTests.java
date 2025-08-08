package OnlinerTests;

import Pages.Onliner.HomePage;
import Pages.Onliner.MobilePhonesListingPage;
import WebDriverManager.BrowserType;
import WebDriverManager.WebDriverSingleton;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class SelectPhoneTests extends WebSites.UiTests.BaseTest {

    @ParameterizedTest(name = "SelectPerfectPhoneTest on {0}")
    @EnumSource(value = BrowserType.class, names = {"SAFARI", "CHROME"})
    public void selectPerfectPhoneTest(BrowserType browserType) {
        driver = WebDriverSingleton.getDriver(browserType);
        driver.manage().window().maximize();

        HomePage homePage = new HomePage(driver);
        homePage.navigateToBaseOnlinerPage();
        homePage.clickSubmitCookies();
        homePage.clickOnMobilePhonesLink();

        MobilePhonesListingPage listingPage = new MobilePhonesListingPage(driver);
        listingPage.selectCheckBox256();
        listingPage.selectCheckBox512();
        listingPage.selectCheckBoxBattery5000();
        listingPage.sortByExpensive();
        System.out.println("\nThe most expensive is: " + listingPage.getTheMostExpensivePhone());
    }
}
