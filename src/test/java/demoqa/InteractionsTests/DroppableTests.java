
package demoqa.InteractionsTests;

import WebSites.UiTests.BaseTest;
import Pages.DemoqaPages.Interactions.DroppablePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DroppableTests extends BaseTest {

    @Test
    public void simpleDroppable_ShouldShowDropped() {
        DroppablePage page = new DroppablePage(driver);
        page.open();

        page.dragToDropBox();
        Assertions.assertTrue(page.isDroppedState(), "Droppable should display 'Dropped!' after drop");
    }
}
