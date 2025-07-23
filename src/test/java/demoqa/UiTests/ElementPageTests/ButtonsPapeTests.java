package demoqa.UiTests.ElementPageTests;

import BaseTest;
import Pages.DemoqaPages.ElementsPage.ButtonsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ButtonsPapeTests extends BaseTest {
    ButtonsPage buttonsPage = new ButtonsPage();

    @Test
    public void doubleClickTest(){
        buttonsPage.navigateToBasePage();
        buttonsPage.clickOnButtonsPage();

        buttonsPage.performDoubleClick();
        Assertions.assertEquals("You have done a double click", buttonsPage.getDoubleClickMessage());
    }

    @Test
    public void rightClickTest(){
        buttonsPage.navigateToBasePage();
        buttonsPage.clickOnButtonsPage();

        buttonsPage.performRightClick();
        Assertions.assertEquals("You have done a right click", buttonsPage.getRightClickMessage());
    }
}
