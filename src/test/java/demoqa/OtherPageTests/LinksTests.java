package demoqa.OtherPageTests;

import WebSites.UiTests.BaseTest;
import Pages.DemoqaPages.OtherPage.LinksPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LinksTests extends BaseTest {

    @Test
    public void ClickOnCreatedLinkTest(){
        LinksPage linksPage = new LinksPage();

        linksPage.navigateToBaseDemoqaPage();
        linksPage.clickOnLinksPage();

        linksPage.clickCreatedLink();
        Assertions.assertEquals("Link has responded with staus 201 and status text Created", linksPage.getLinkResponseText());
    }

    @Test
    public void linkOpenedInNewTabTest(){
        LinksPage linksPage = new LinksPage();

        linksPage.navigateToBaseDemoqaPage();
        linksPage.clickOnLinksPage();

        linksPage.clickSimpleLink();
        Assertions.assertEquals("DEMOQA", linksPage.getPageTitle());
    }
}
