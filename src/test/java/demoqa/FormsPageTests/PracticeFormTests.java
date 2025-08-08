package demoqa.FormsPageTests;

import WebSites.UiTests.BaseTest;
import Pages.DemoqaPages.FormsPage.PracticeFormPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.nio.file.Paths;
import java.util.Arrays;

public class PracticeFormTests extends BaseTest {

    @Test
    public void fillPracticeForm_Smoke() {
        PracticeFormPage page = new PracticeFormPage(driver);

        // Открываем форму напрямую (в проекте baseDemoqaUrl указывает на text-box)
        page.open();

        page.fillFirstName("Alex");
        page.fillLastName("Gorsky");
        page.fillEmail("alex.gorsky@example.com");
        page.selectGender("Male");
        page.fillMobile("9000000000");
        page.setDateOfBirth("10 Sep 1995");
        page.addSubjects(Arrays.asList("Maths", "English"));
        page.fillCurrentAddress("Minsk, Address 1");
        page.selectState("NCR");
        page.selectCity("Delhi");

        page.submit();

        // Простейшие проверки соответствуют стилю остальных тестов (assertTrue/equals)
        Assertions.assertTrue(page.isResultContains("Student Name", "Alex Gorsky"), "Student Name is incorrect");
        Assertions.assertTrue(page.isResultContains("Student Email", "alex.gorsky@example.com"), "Email is incorrect");
        Assertions.assertTrue(page.isResultContains("Gender", "Male"), "Gender is incorrect");
        Assertions.assertTrue(page.isResultContains("Mobile", "9000000000"), "Mobile is incorrect");
        Assertions.assertTrue(page.isResultContains("Date of Birth", "10 September,1995"), "Date of Birth is incorrect");
        Assertions.assertTrue(page.isResultContains("Subjects", "Maths, English"), "Subjects are incorrect");
        Assertions.assertTrue(page.isResultContains("Address", "Minsk"), "Address is incorrect");
        Assertions.assertTrue(page.isResultContains("State and City", "NCR Delhi"), "State and City are incorrect");
    }
}
