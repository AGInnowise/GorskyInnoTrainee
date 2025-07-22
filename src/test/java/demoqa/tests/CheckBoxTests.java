package demoqa.tests;

import demoqa.base.BaseTest;
import demoqa.pages.CheckBoxPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckBoxTests extends BaseTest {

    @Test
    public void checkAllCheckBoxesSelectedTest(){
        CheckBoxPage checkBoxPage = new CheckBoxPage();
        checkBoxPage.navigateToBasePage();
        checkBoxPage.navigateToCheckBoxPage();

        checkBoxPage.clickExpandAllButton();
        checkBoxPage.clickMainCheckBox();

        Assertions.assertTrue(checkBoxPage.areAllCheckboxesSelected());
    }

    @Test
    public void CheckSelectedCheckBoxIsInResult(){
        CheckBoxPage checkBoxPage = new CheckBoxPage();
        checkBoxPage.navigateToBasePage();
        checkBoxPage.navigateToCheckBoxPage();
        checkBoxPage.clickExpandAllButton();

        checkBoxPage.clickCommandsText();
        Assertions.assertTrue(checkBoxPage.isSelectedCheckBoxesInResult("Commands"));

        checkBoxPage.clickAngularText();
        Assertions.assertTrue(checkBoxPage.isSelectedCheckBoxesInResult("Angular"));
    }
}
