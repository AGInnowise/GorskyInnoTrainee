package demoqa.OtherPageTests;

import WebSites.UiTests.BaseTest;
import Pages.DemoqaPages.OtherPage.LinksImagesPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LinksImagesTests extends BaseTest {

    @Test
    public void isValidLinkCorrectTest(){
        LinksImagesPage linksImagesPage = new LinksImagesPage();

        linksImagesPage.navigateToBaseDemoqaPage();
        linksImagesPage.clickOnLinksImagesPage();

        Assertions.assertTrue(linksImagesPage.isValidLinkCorrect());
    }

    @Test
    public void isBrokenLinkCorrectTest(){
        LinksImagesPage linksImagesPage = new LinksImagesPage();

        linksImagesPage.navigateToBaseDemoqaPage();
        linksImagesPage.clickOnLinksImagesPage();

        Assertions.assertTrue(linksImagesPage.isBrokenLinkCorrect());
    }
}
