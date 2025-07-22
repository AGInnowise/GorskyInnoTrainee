package demoqa.tests;

import demoqa.base.BaseTest;
import demoqa.pages.ButtonsPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ButtonsTests extends BaseTest {
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
