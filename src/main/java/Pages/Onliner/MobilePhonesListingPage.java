package Pages.Onliner;

import Elements.ButtonElement.ButtonElement;
import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import Helpers.Logger;

public class MobilePhonesListingPage extends BasePage {
    private final ButtonElement checkBox256 = new ButtonElement(driver, By.xpath("//li[contains(@class, 'catalog-form__checkbox-item') and .//text()[contains(., '256')]]"));
    private final ButtonElement checkBox512 = new ButtonElement(driver, By.xpath("//li[contains(@class, 'catalog-form__checkbox-item') and .//text()[contains(., 'более 6.7\"')]]"));
    private final ButtonElement checkBoxBattery5000 = new ButtonElement(driver, By.xpath("//li[contains(@class, 'catalog-form__checkbox-item') and .//text()[contains(., '5000')]]"));
    private final By sortDropdown = By.xpath("//div[contains(@class,'catalog-form__sorting-part_2')]//select[contains(@class,'input-style__real')]");
    public MobilePhonesListingPage(WebDriver driver) {
        super(driver);
        Logger.log("MobilePhonesListingPage: initialized");
    }

    public void selectCheckBox256() {
        Logger.log("MobilePhonesListingPage: selectCheckBox256");
        checkBox256.click();
    }

    public void selectCheckBox512() {
        Logger.log("MobilePhonesListingPage: selectCheckBox512");
        checkBox512.click();
    }

    public void selectCheckBoxBattery5000() {
        Logger.log("MobilePhonesListingPage: selectCheckBoxBattery5000");
        checkBoxBattery5000.click();
    }

    public PhoneItemModel getTheMostExpensivePhone() {
        Logger.log("MobilePhonesListingPage: getTheMostExpensivePhone");
        List<WebElement> phoneCards = driver.findElements(By.cssSelector("div.catalog-form__offers-unit_primary"))
                                            .stream()
                                            .limit(10)
                                            .collect(Collectors.toList());

        List<PhoneItemModel> phones = phoneCards.stream()
                .map(card -> {
                    try {
                        String name = card.findElement(By.cssSelector(
                                ".catalog-form__link.catalog-form__link_primary-additional.catalog-form__link_base-additional.catalog-form__link_font-weight_semibold.catalog-form__link_nodecor"
                        )).getText();
                        Logger.log(name);

                        String priceText = new WebDriverWait(driver, Duration.ofSeconds(5))
                            .until(drv -> {
                                try {
                                    WebElement priceElement;
                                    try {
                                        priceElement = card.findElement(By.cssSelector(
                                            "a.catalog-form__link.catalog-form__link_primary-additional span:last-of-type"
                                        ));
                                    } catch (org.openqa.selenium.NoSuchElementException e) {
                                        priceElement = card.findElement(By.cssSelector(
                                            ".catalog-form__link.catalog-form__link_nodecor.catalog-form__link_error-alter.catalog-form__link_huge-additional.catalog-form__link_font-weight_bold span:last-of-type"
                                        ));
                                    }
                                    return priceElement.isDisplayed() ? priceElement.getText() : null;
                                } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.StaleElementReferenceException e) {
                                    return null;
                                }
                            });
                        Logger.log(" " + priceText);

                        int price = Integer.parseInt(priceText.split(",")[0].replaceAll("[^0-9]", ""));
                        return new PhoneItemModel(name, price);

                    } catch (org.openqa.selenium.StaleElementReferenceException e) {
                        Logger.log("Устаревший элемент: " + e.getMessage());
                        return null; // Можно также логировать
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        PhoneItemModel mostExpensive = phones.stream()
                .max(Comparator.comparingDouble(PhoneItemModel::getPrice))
                .orElseThrow(() -> new RuntimeException("Телефоны не найдены"));
        Logger.log("MobilePhonesListingPage: most expensive phone -> name: " + mostExpensive.getName() + ", price: " + mostExpensive.getPrice());
        return mostExpensive;
    }

    public void sortByExpensive() {
        Logger.log("MobilePhonesListingPage: sortByExpensive");
        WebElement dropdown = driver.findElement(sortDropdown);
        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].value = arguments[1]; arguments[0].dispatchEvent(new Event('change'));",
            dropdown, "price:desc");
    }

}
