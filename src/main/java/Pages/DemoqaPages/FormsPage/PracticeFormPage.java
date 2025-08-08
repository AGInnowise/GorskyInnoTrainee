package Pages.DemoqaPages.FormsPage;

import Elements.ButtonElement.ButtonElement;
import Elements.TextBoxElement.TextBoxElement;
import Elements.BaseElement;
import Pages.BasePage;
import WebDriverManager.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import Helpers.Logger;

/**
 * Practice Form page object for https://demoqa.com/automation-practice-form
 * Стиль и паттерны совпадают с остальными Page Object из проекта:
 * - Наследуемся от BasePage;
 * - Используем обёртки ButtonElement/TextBoxElement/BaseElement;
 * - Логируем каждое действие через Helpers.Logger.
 */
public class PracticeFormPage extends BasePage {

    // === Locators (обёртки) ===
    private final TextBoxElement firstNameInput = new TextBoxElement(driver, By.id("firstName"));
    private final TextBoxElement lastNameInput = new TextBoxElement(driver, By.id("lastName"));
    private final TextBoxElement emailInput = new TextBoxElement(driver, By.id("userEmail"));
    // радиокнопки (клик по label безопаснее)
    private final ButtonElement genderMaleLabel = new ButtonElement(driver, By.cssSelector("#genterWrapper label[for='gender-radio-1']"));
    private final ButtonElement genderFemaleLabel = new ButtonElement(driver, By.cssSelector("#genterWrapper label[for='gender-radio-2']"));
    private final ButtonElement genderOtherLabel = new ButtonElement(driver, By.cssSelector("#genterWrapper label[for='gender-radio-3']"));

    private final TextBoxElement mobileInput = new TextBoxElement(driver, By.id("userNumber"));
    private final TextBoxElement dateOfBirthInput = new TextBoxElement(driver, By.id("dateOfBirthInput"));
    private final TextBoxElement subjectsInput = new TextBoxElement(driver, By.id("subjectsInput"));

    // чекбоксы-хобби (тоже кликаем по label)
    private final ButtonElement hobbySports = new ButtonElement(driver, By.cssSelector("#hobbies-checkbox-1"));
    private final ButtonElement hobbyReading = new ButtonElement(driver, By.cssSelector("#hobbies-checkbox-2"));
    private final ButtonElement hobbyMusic = new ButtonElement(driver, By.cssSelector("#hobbies-checkbox-3"));

    private final TextBoxElement currentAddressInput = new TextBoxElement(driver, By.id("currentAddress"));
    private final ButtonElement uploadPictureInput = new ButtonElement(driver, By.id("uploadPicture"));

    // react-select
    private final ButtonElement stateContainer = new ButtonElement(driver, By.id("state"));
    private final ButtonElement cityContainer  = new ButtonElement(driver, By.id("city"));
    private final TextBoxElement stateInput = new TextBoxElement(driver, By.id("react-select-3-input"));
    private final TextBoxElement cityInput  = new TextBoxElement(driver, By.id("react-select-4-input"));

    private final ButtonElement submitButton = new ButtonElement(driver, By.id("submit"));

    // Result modal
    private final ButtonElement resultModal = new ButtonElement(driver, By.cssSelector(".modal-content"));
    private final BaseElement resultTableRows = new BaseElement(driver, By.cssSelector(".table-responsive tbody tr"));

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    // === Actions ===

    /** Открываем страницу напрямую (в проекте baseDemoqaUrl указывает на text-box). */
    public void open() {
        String url = "https://demoqa.com/automation-practice-form";
        Logger.log("PracticeFormPage: open -> " + url);
        driver.get(url);
    }

    public void fillFirstName(String value) {
        Logger.log("PracticeFormPage: fillFirstName -> " + value);
        firstNameInput.sendKeys(value);
    }

    public void fillLastName(String value) {
        Logger.log("PracticeFormPage: fillLastName -> " + value);
        lastNameInput.sendKeys(value);
    }

    public void fillEmail(String value) {
        Logger.log("PracticeFormPage: fillEmail -> " + value);
        emailInput.sendKeys(value);
    }

    public void selectGender(String gender) {
        Logger.log("PracticeFormPage: selectGender -> " + gender);
        String g = gender.toLowerCase();
        if (g.startsWith("m")) {
            genderMaleLabel.click();
        } else if (g.startsWith("f") || g.startsWith("ж")) {
            genderFemaleLabel.click();
        } else {
            genderOtherLabel.click();
        }
    }

    public void fillMobile(String digits) {
        Logger.log("PracticeFormPage: fillMobile -> " + digits);
        mobileInput.sendKeys(digits);
    }

    /**
     * Установка даты рождения. Для стабильности используем JS на input (формат как в UI).
     * Пример: "10 Sep 1995".
     */
    public void setDateOfBirth(String formattedDate) {
        Logger.log("PracticeFormPage: setDateOfBirth -> " + formattedDate);
        WebDriver drv = WebDriverSingleton.driver;
        ((org.openqa.selenium.JavascriptExecutor) drv)
                .executeScript("arguments[0].value = arguments[1]; arguments[0].dispatchEvent(new Event('change'));",
                        dateOfBirthInput.getElement(), formattedDate);
    }

    /** Добавление нескольких предметов через autocomplete. */
    public void addSubjects(List<String> subjects) {
        Logger.log("PracticeFormPage: addSubjects -> " + subjects);
        WebElement field = subjectsInput.getElement();
        for (String s : subjects) {
            field.sendKeys(s);
            field.sendKeys(Keys.ENTER);
        }
    }

    public void selectHobby(String hobby) {
        Logger.log("PracticeFormPage: selectHobby -> " + hobby);
        String h = hobby.toLowerCase();
        if (h.contains("sport")) {
            hobbySports.click();
        } else if (h.contains("read")) {
            hobbyReading.click();
        } else {
            hobbyMusic.click();
        }
    }

    public void uploadPicture(String absolutePath) {
        Logger.log("PracticeFormPage: uploadPicture -> " + absolutePath);
        // input type=file допускает sendKeys пути
        uploadPictureInput.getElement().sendKeys(absolutePath);
    }

    public void fillCurrentAddress(String value) {
        Logger.log("PracticeFormPage: fillCurrentAddress -> " + value);
        currentAddressInput.sendKeys(value);
    }

    public void selectState(String state) {
        Logger.log("PracticeFormPage: selectState -> " + state);
        stateContainer.click();
        stateInput.sendKeys(state);
        stateInput.getElement().sendKeys(Keys.ENTER);
    }

    public void selectCity(String city) {
        Logger.log("PracticeFormPage: selectCity -> " + city);
        cityContainer.click();
        cityInput.sendKeys(city);
        cityInput.getElement().sendKeys(Keys.ENTER);
    }

    public void submit() {
        Logger.log("PracticeFormPage: submit");
        // Кнопка может быть перекрыта футером — кликаем с прокруткой или JS
        submitButton.clickWithJS();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(resultModal.getElement()));
    }

    /** Возвращает текст всех строк в таблице результата (для простых contains-проверок). */
    public List<String> getResultRows() {
        Logger.log("PracticeFormPage: getResultRows");
        List<WebElement> rows = driver.findElements(By.cssSelector(".table-responsive tbody tr"));
        return rows.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    /** Утилита, чтобы быстро проверить наличие строки с ключом и значением. */
    public boolean isResultContains(String key, String partOfValue) {
        Logger.log("PracticeFormPage: isResultContains -> " + key + " = " + partOfValue);
        for (String row : getResultRows()) {
            Logger.log(row + " => " + partOfValue);
            if (row.startsWith(key) && row.toLowerCase().contains(partOfValue.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
