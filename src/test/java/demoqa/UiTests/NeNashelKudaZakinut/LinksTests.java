package demoqa.UiTests.NeNashelKudaZakinut;

import BaseTest;
import Pages.DemoqaPages.NeNashelKudaZakinut.LinksPage;
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
