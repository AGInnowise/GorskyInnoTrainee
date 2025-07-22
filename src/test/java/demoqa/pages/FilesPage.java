package demoqa.pages;

import demoqa.base.BasePage;
import demoqa.base.WebDriverSingleton;
import demoqa.base.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class FilesPage extends BasePage {
    private final BaseElement filesSelector = new BaseElement(driver, By.id("item-7"));

    private final BaseElement downloadButton = new BaseElement(driver, By.id("downloadButton"));
    private final BaseElement uploadFileInput = new BaseElement(driver, By.id("uploadFile"));
    private final BaseElement uploadedFilePath = new BaseElement(driver, By.id("uploadedFilePath"));

    private final String downloadDir = System.getProperty("user.home") + "/Downloads";
    private String downloadedFileName;

    public FilesPage() {
        super(WebDriverSingleton.driver);
    }

    public void clickFilesPage() {
        filesSelector.click();
    }

    public boolean waitForUploadConfirmation(int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uploadedFilePath"))).isDisplayed();
    }

    public String getUploadedFileName() {
        return driver.findElement(By.id("uploadedFilePath")).getText();
    }

    public boolean waitForFileDownload(String filePath, int timeoutInSeconds) {
        File file = new File(filePath);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(d -> file.exists());
    }

    public void clickDownloadButton() {
        downloadButton.click();
    }

    public boolean isFileDownloaded() {
        try (Stream<Path> files = Files.list(Paths.get(downloadDir))) {
            Optional<Path> latestFile = files
                    .filter(Files::isRegularFile)
                    .max(Comparator.comparingLong(p -> p.toFile().lastModified()));

            if (latestFile.isPresent()) {
                downloadedFileName = latestFile.get().toString();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void uploadDownloadedFile() {
        if (downloadedFileName != null) {
            uploadFileInput.findElement().sendKeys(downloadedFileName);
        }
    }

    public boolean isUploadedFilePathCorrect() {
        if (downloadedFileName != null) {
            String expectedFileName = Paths.get(downloadedFileName).getFileName().toString();
            String actualText = uploadedFilePath.getText();
            return actualText.endsWith(expectedFileName);
        }
        return false;
    }
}