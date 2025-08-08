package Pages.DemoqaPages.OtherPage;

import Elements.ButtonElement.ButtonElement;
import Elements.TextBoxElement.TextBoxElement;
import Pages.BasePage;
import WebDriverManager.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Helpers.Logger;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class FilesPage extends BasePage {
    private final ButtonElement filesSelector = new ButtonElement(driver, By.id("item-7"));

    private final ButtonElement downloadButton = new ButtonElement(driver, By.id("downloadButton"));
    private final TextBoxElement uploadFileInput = new TextBoxElement(driver, By.id("uploadFile"));
    private final TextBoxElement uploadedFilePath = new TextBoxElement(driver, By.id("uploadedFilePath"));

    private final String downloadDir = System.getProperty("user.home") + "/Downloads";
    private String downloadedFileName;

    public FilesPage() {
        super(WebDriverSingleton.driver);
        Logger.log("FilesPage: initialized");
    }

    public void clickFilesPage() {
        Logger.log("FilesPage: clickFilesPage");
        filesSelector.click();
    }

    public boolean waitForUploadConfirmation(int timeoutInSeconds) {
        Logger.log("FilesPage: waitForUploadConfirmation -> timeoutInSeconds = " + timeoutInSeconds);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        boolean visible = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uploadedFilePath"))).isDisplayed();
        Logger.log("FilesPage: waitForUploadConfirmation -> visible = " + visible);
        return visible;
    }

    public String getUploadedFileName() {
        String name = driver.findElement(By.id("uploadedFilePath")).getText();
        Logger.log("FilesPage: getUploadedFileName -> " + name);
        return name;
    }

    public boolean waitForFileDownload(String filePath, int timeoutInSeconds) {
        Logger.log("FilesPage: waitForFileDownload -> filePath = " + filePath + ", timeoutInSeconds = " + timeoutInSeconds);
        File file = new File(filePath);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        boolean result = wait.until(d -> file.exists());
        Logger.log("FilesPage: waitForFileDownload -> result = " + result);
        return result;
    }

    public void clickDownloadButton() {
        Logger.log("FilesPage: clickDownloadButton");
        downloadButton.click();
    }

    public boolean isFileDownloaded() {
        Logger.log("FilesPage: isFileDownloaded");
        try (Stream<Path> files = Files.list(Paths.get(downloadDir))) {
            Optional<Path> latestFile = files
                    .filter(Files::isRegularFile)
                    .max(Comparator.comparingLong(p -> p.toFile().lastModified()));

            if (latestFile.isPresent()) {
                downloadedFileName = latestFile.get().toString();
                Logger.log("FilesPage: isFileDownloaded -> downloadedFileName = " + downloadedFileName);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Logger.log("FilesPage: isFileDownloaded -> no file found, returning false");
        return false;
    }

    public void uploadDownloadedFile() {
        Logger.log("FilesPage: uploadDownloadedFile -> downloadedFileName = " + downloadedFileName);
        if (downloadedFileName != null) {
            uploadFileInput.findElement().sendKeys(downloadedFileName);
        }
    }

    public boolean isUploadedFilePathCorrect() {
        Logger.log("FilesPage: isUploadedFilePathCorrect -> downloadedFileName = " + downloadedFileName);
        if (downloadedFileName != null) {
            String expectedFileName = Paths.get(downloadedFileName).getFileName().toString();
            String actualText = uploadedFilePath.getText();
            boolean result = actualText.endsWith(expectedFileName);
            Logger.log("FilesPage: isUploadedFilePathCorrect -> expected: " + expectedFileName + ", actual: " + actualText + ", result: " + result);
            return result;
        }
        Logger.log("FilesPage: isUploadedFilePathCorrect -> downloadedFileName was null, returning false");
        return false;
    }
}