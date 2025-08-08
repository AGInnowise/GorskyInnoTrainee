
package demoqa.InteractionsTests;

import WebSites.UiTests.BaseTest;
import Pages.DemoqaPages.Interactions.SelectablePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SelectableTests extends BaseTest {

    @Test
    public void listSelectable_ShouldActivateItem() {
        SelectablePage page = new SelectablePage(driver);
        page.open();

        page.selectListItem(1);
        Assertions.assertTrue(page.isAnyListItemActive(), "One of list items should become active");
    }

    @Test
    public void gridSelectable_ShouldActivateSpecificCell() {
        SelectablePage page = new SelectablePage(driver);
        page.open();

        page.selectGridItemByText("Two");
        Assertions.assertTrue(page.isGridItemActive("Two"), "Selected grid item should be active");
    }
}
