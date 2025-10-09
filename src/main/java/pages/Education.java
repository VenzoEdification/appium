package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Report;
import utils.SharedDriver;

import java.net.MalformedURLException;
import java.time.Duration;

public class Education extends Report {
    AndroidDriver driver;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Education\"]")
    public WebElement educationtab;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@resource-id=\"education-level\"]")
    public WebElement educationlevel;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@resource-id=\"option-2\"]")
    public WebElement selectlevel;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@resource-id=\"education-field\"]")
    public WebElement educationfield;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@resource-id=\"option-3\"]")
    public WebElement selectfield;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Upload File\"]")
    public WebElement uploadfile;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@resource-id=\"education-update-button\"]")
    public WebElement Updatebutton;

    @FindBy(how = How.XPATH, using = "//android.widget.Button[@content-desc=\"OK\"]")
    public WebElement cameraok;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@resource-id=\"camera-button\"]")
    public WebElement camera;
    @FindBy(how = How.XPATH, using = "//android.widget.ImageButton[@content-desc=\"Take picture\"]")
    public WebElement takepicture;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@resource-id=\"delete-doc-1\"]")
    public WebElement deletedoc1;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@resource-id=\"delete-doc-2\"]")
    public WebElement deletedoc2;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@resource-id=\"delete-doc-3\"]")
    public WebElement deletedoc3;



    public Education() throws MalformedURLException {
        this.driver = SharedDriver.getCapabilities();
        PageFactory.initElements(driver, this);
    }

    public Education ClickEducationTab() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(educationtab));
        educationtab.click();
        return this;
    }
    public Education ClickEducationLevel() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(educationlevel));
        educationlevel.click();
        return this;
    }
    public Education SelectEducationLevel() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(selectlevel));
        selectlevel.click();
        return this;
    }
    public Education ClickEducationField() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(educationfield));
        educationfield.click();
        return this;
    }
    public Education SelectEducationField() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(selectfield));
        selectfield.click();
        return this;
    }
    public Education ClickUploadfile() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(uploadfile));
        uploadfile.click();
        return this;
    }
    public GovernmentIDs ClickCamera() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(camera));
        camera.click();
        return this.ClickCamera();
    }
    public Education ClickTakePicture() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(takepicture));
        takepicture.click();
        return this;
    }

    public Education ClickCameraOkButton() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(cameraok));
        cameraok.click();
        Thread.sleep(3000);
        return this;
    }
    public Education UploadDocument1() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        if (!driver.findElements(By.xpath("//android.view.ViewGroup[@content-desc=\"Upload File\"]")).isEmpty()) {
            ClickUploadfile();
            ClickCamera();
            ClickTakePicture();
            ClickCameraOkButton();
        }
        else if (!driver.findElements(By.xpath("//android.widget.TextView[@resource-id=\"delete-doc-1\"]")).isEmpty()) {
            deletedoc1.click();
            ClickCamera();
            ClickTakePicture();
            ClickCameraOkButton();
        }

        return this;
    }
    public Education UploadDocument2() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        if (!driver.findElements(By.xpath("//android.view.ViewGroup[@content-desc=\"Upload File\"]")).isEmpty()) {
            ClickUploadfile();
            ClickCamera();
            ClickTakePicture();
            ClickCameraOkButton();
        }
        else if (!driver.findElements(By.xpath("//android.widget.TextView[@resource-id=\"delete-doc-2\"]")).isEmpty()) {
            deletedoc2.click();
            ClickCamera();
            ClickTakePicture();
            ClickCameraOkButton();
        }

        return this;
    }
    public Education UploadDocument3() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        if (!driver.findElements(By.xpath("//android.view.ViewGroup[@content-desc=\"Upload File\"]")).isEmpty()) {
            ClickUploadfile();
            ClickCamera();
            ClickTakePicture();
            ClickCameraOkButton();
        }
        else if (!driver.findElements(By.xpath("//android.widget.TextView[@resource-id=\"delete-doc-3\"]")).isEmpty()) {
            deletedoc2.click();
            ClickCamera();
            ClickTakePicture();
            ClickCameraOkButton();
        }

        return this;
    }


}

