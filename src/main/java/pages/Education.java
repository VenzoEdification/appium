package pages;

import io.appium.java_client.android.AndroidDriver;
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
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@resource-id=\"option-1\"]")
    public WebElement selectlevel;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@resource-id=\"education-field\"]")
    public WebElement educationfield;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@resource-id=\"option-2\"]")
    public WebElement selectfield;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Upload File\"]")
    public WebElement uploadfile;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@resource-id=\"education-update-button\"]")
    public WebElement Updatebutton;

    @FindBy(how = How.XPATH, using = "//android.widget.Button[@content-desc=\"OK\"]")
    public WebElement cameraok;

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

    public Education ClickCameraOkButton() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(cameraok));
        cameraok.click();
        return this;
    }


}

