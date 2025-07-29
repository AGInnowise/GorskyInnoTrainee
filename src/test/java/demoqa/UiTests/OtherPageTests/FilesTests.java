package demoqa.UiTests.OtherPageTests;

import demoqa.UiTests.BaseTest;
import Pages.DemoqaPages.OtherPage.FilesPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilesTests extends BaseTest {
    FilesPage filesPage = new FilesPage();

    @Test
    public void IsFileDownloadedTest(){
        filesPage.navigateToBasePage();
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
