package demoqa.ElementPageTests;

import WebSites.UiTests.BaseTest;
import Pages.DemoqaPages.ElementsPage.ButtonsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ButtonsPapeTests extends BaseTest {

    @Test
    public void doubleClickTest(){
        ButtonsPage buttonsPage = new ButtonsPage();

        buttonsPage.navigateToBaseDemoqaPage();
        buttonsPage.clickOnButtonsPage();

        buttonsPage.performDoubleClick();
        Assertions.assertEquals("You have done a double click", buttonsPage.getDoubleClickMessage());
    }

    @Test
    public void rightClickTest(){
        ButtonsPage buttonsPage = new ButtonsPage();

        buttonsPage.navigateToBaseDemoqaPage();
        buttonsPage.clickOnButtonsPage();

        buttonsPage.performRightClick();
        Assertions.assertEquals("You have done a right click", buttonsPage.getRightClickMessage());
    }
}
