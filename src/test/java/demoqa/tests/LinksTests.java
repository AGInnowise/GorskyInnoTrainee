package demoqa.tests;

import demoqa.base.BaseTest;
import demoqa.pages.LinksPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LinksTests extends BaseTest {
    LinksPage linksPage = new LinksPage();

    @Test
    public void ClickOnCreatedLinkTest(){
        linksPage.navigateToBasePage();
        linksPage.clickOnLinksPage();

        linksPage.clickCreatedLink();
        Assertions.assertEquals("Link has responded with staus 201 and status text Created", linksPage.getLinkResponseText());
    }

    @Test
    public void linkOpenedInNewTabTest(){
        linksPage.navigateToBasePage();
        linksPage.clickOnLinksPage();

        linksPage.clickSimpleLink();
        Assertions.assertEquals("DEMOQA", linksPage.getPageTitle());
    }
}
