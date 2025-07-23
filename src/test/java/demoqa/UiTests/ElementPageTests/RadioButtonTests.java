package demoqa.UiTests.ElementPageTests;

import BaseTest;
import Pages.DemoqaPages.ElementsPage.RadioButtonPage;
import org.junit.jupiter.api.Test;

public class RadioButtonTests extends BaseTest {

    @Test
    public void isYesSelectedTest(){
        RadioButtonPage radioButtonPage = new RadioButtonPage();
        radioButtonPage.navigateToBasePage();
        radioButtonPage.clickRadioButtonPage();

        radioButtonPage.clickYesRadio();
        radioButtonPage.isResultText("Yes");
    }

    @Test
    public void isImpressiveSelectedTest(){
        RadioButtonPage radioButtonPage = new RadioButtonPage();
        radioButtonPage.navigateToBasePage();
        radioButtonPage.clickRadioButtonPage();

        radioButtonPage.clickImpressiveRadio();
        radioButtonPage.isResultText("Impressive");
    }
}
