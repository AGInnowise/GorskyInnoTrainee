
package demoqa.InteractionsTests;

import WebSites.UiTests.BaseTest;
import Pages.DemoqaPages.Interactions.DraggablePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Point;

public class DraggableTests extends BaseTest {

    @Test
    public void simpleDraggable_ShouldChangeLocation() {
        DraggablePage page = new DraggablePage(driver);
        page.open();

        Point before = page.getDraggableLocation();
        page.dragBy(60, 40);
        Point after = page.getDraggableLocation();

        Assertions.assertTrue(after.getX() != before.getX() || after.getY() != before.getY(),
                "Element location should change after dragging");
    }
}
