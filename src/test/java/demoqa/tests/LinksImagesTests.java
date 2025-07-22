package demoqa.tests;

import demoqa.base.BaseTest;
import demoqa.pages.LinksImagesPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LinksImagesTests extends BaseTest {
    LinksImagesPage linksImagesPage = new LinksImagesPage();

    @Test
    public void isValidLinkCorrectTest(){
        linksImagesPage.navigateToBasePage();
        linksImagesPage.clickOnLinksImagesPage();

        Assertions.assertTrue(linksImagesPage.isValidLinkCorrect());
    }

    @Test
    public void isBrokenLinkCorrectTest(){
        linksImagesPage.navigateToBasePage();
        linksImagesPage.clickOnLinksImagesPage();

        Assertions.assertTrue(linksImagesPage.isBrokenLinkCorrect());
    }
}
