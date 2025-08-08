package demoqa.OtherPageTests;

import WebSites.UiTests.BaseTest;
import Pages.DemoqaPages.OtherPage.FilesPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilesTests extends BaseTest {

    @Test
    public void IsFileDownloadedTest(){
        FilesPage filesPage = new FilesPage();

        filesPage.navigateToBaseDemoqaPage();
        filesPage.clickFilesPage();

        filesPage.clickDownloadButton();
        Assertions.assertTrue(filesPage.isFileDownloaded());

        filesPage.uploadDownloadedFile();
        Assertions.assertTrue(filesPage.isUploadedFilePathCorrect());
    }

//    @Test
//    public void IsFileUploadedTest(){
//        filesPage.navigateToBasePage();
//        filesPage.clickFilesPage();
//
//        filesPage.uploadDownloadedFile();
//        Assertions.assertTrue(filesPage.isUploadedFilePathCorrect());
//    }
}
