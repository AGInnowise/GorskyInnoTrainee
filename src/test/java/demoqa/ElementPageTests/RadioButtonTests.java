package demoqa.ElementPageTests;

import WebSites.UiTests.BaseTest;
import Pages.DemoqaPages.ElementsPage.RadioButtonPage;
import org.junit.jupiter.api.Test;

public class RadioButtonTests extends BaseTest {

    @Test
    public void isYesSelectedTest(){
        RadioButtonPage radioButtonPage = new RadioButtonPage();
        radioButtonPage.navigateToBaseDemoqaPage();
        radioButtonPage.clickRadioButtonPage();

        radioButtonPage.clickYesRadio();
        radioButtonPage.isResultText("Yes");
    }

    @Test
    public void isImpressiveSelectedTest(){
        RadioButtonPage radioButtonPage = new RadioButtonPage();
        radioButtonPage.navigateToBaseDemoqaPage();
        radioButtonPage.clickRadioButtonPage();

        radioButtonPage.clickImpressiveRadio();
        radioButtonPage.isResultText("Impressive");
    }
}
