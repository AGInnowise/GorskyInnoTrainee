package demoqa.UiTests.NeNashelKudaZakinut;

import BaseTest;
import Pages.DemoqaPages.ElementsPage.TextBoxPage;
import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TextBoxTests extends BaseTest {

    @Test
    public void fillTextBoxFormSuccessTest() {
        TextBoxPage textBoxPage = new TextBoxPage();
        String name = "Alex";
        String email = "test@example.com";
        String currentAddress = "Address 1";
        String permanentAddress = "Permanent address 2";

        textBoxPage.navigateToBasePage();
        textBoxPage.fillUsername(name);
        textBoxPage.fillEmail(email);
        textBoxPage.fillCurrentAddress(currentAddress);
        textBoxPage.fillPermanentAddress(permanentAddress);
        textBoxPage.clickSubmitButton();

        Assertions.assertTrue(textBoxPage.getResultName().contains(name), "Returned Name is incorrect");
        Assertions.assertTrue(textBoxPage.getResultEmail().contains(email), "Returned Email is incorrect");
        Assertions.assertTrue(textBoxPage.getResultCurrentAddress().contains(currentAddress), "Returned Current Address is incorrect");
        Assertions.assertTrue(textBoxPage.getResultPermanentAddress().contains(permanentAddress), "Returned Permanent Address is incorrect");
    }

    @Test
    public void checkEmailValidationTest(){
        TextBoxPage textBoxPage = new TextBoxPage();

        textBoxPage.fillEmail("IncorrectEmail");
        textBoxPage.clickSubmitButton();

        Assertions.assertTrue(textBoxPage.isEmailValidationErrorVisible());
    }
}