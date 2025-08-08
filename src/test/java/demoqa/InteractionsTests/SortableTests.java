
package demoqa.InteractionsTests;

import WebSites.UiTests.BaseTest;
import Pages.DemoqaPages.Interactions.SortablePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SortableTests extends BaseTest {

    @Test
    public void listSortable_ShouldChangeOrder() {
        SortablePage page = new SortablePage(driver);
        page.open();

        List<String> before = page.getListOrder();
        page.dragListItemTo(0, 3);
        List<String> after = page.getListOrder();

        Assertions.assertNotEquals(before, after, "Order of list items should change after drag-and-drop");
    }
}
