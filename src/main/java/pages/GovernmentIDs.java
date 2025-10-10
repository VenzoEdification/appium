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
import java.util.List;

public class GovernmentIDs extends Report {
    AndroidDriver driver;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@resource-id=\"Goverment ID's\"]")
    public WebElement GovernmentIDstab;
    @FindBy(how = How.XPATH, using = "//android.widget.EditText[@resource-id=\"aadhaar-number\"]")
    public WebElement Aadharnumber;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@resource-id=\"pan-verify\"]")
    public WebElement panverify ;
    @FindBy(how = How.XPATH, using = "(//android.widget.TextView[@text=\"Verify\"])[1]")
    public WebElement aadharverify ;
    @FindBy(how = How.XPATH, using = "//android.widget.EditText[@resource-id=\"pan-number\"]")
    public WebElement PANnumber ;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Upload Aadhaar\"]")
    public WebElement Uploadaadhar ;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@resource-id=\"pan-upload\"]")
    public WebElement Uploadpan ;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text=\"Verified\"]")
    public WebElement verified ;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text=\"Verified\"]")
    public WebElement panverified ;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@resource-id=\"camera-button\"]")
    public WebElement camera;
    @FindBy(how = How.XPATH, using = "//android.widget.ImageButton[@content-desc=\"Take picture\"]")
    public WebElement takepicture;
    @FindBy(how = How.XPATH, using = "//android.widget.Button[@content-desc=\"OK\"]")
    public WebElement cameraok;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@resource-id=\"Aadhaar-delete-doc\"]")
    public WebElement aadhardelete;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@resource-id=\"Pan-delete-doc\"]")
    public WebElement pandelete;




    public GovernmentIDs() throws MalformedURLException {
        this.driver = SharedDriver.getCapabilities();
        PageFactory.initElements(driver, this);
    }

    public GovernmentIDs ClickGovernmentIDs() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(GovernmentIDstab));
        GovernmentIDstab.click();
        return this;
    }
    public GovernmentIDs AadharFlow(String aadharnumber) throws InterruptedException {
        List<WebElement> aadharField = driver.findElements(By.xpath("//android.widget.EditText[@resource-id='aadhaar-number']"));
        List<WebElement> verifiedText = driver.findElements(By.xpath("//android.widget.TextView[@text='Verified']"));

        if (aadharField.isEmpty() && verifiedText.isEmpty()) {
            aadharField = driver.findElements(By.xpath("//android.widget.EditText[@resource-id='aadhaar-number']"));
            verifiedText = driver.findElements(By.xpath("//android.widget.TextView[@text='Verified']"));
        }

        if (!aadharField.isEmpty()) {
            aadharField.get(0).click(); ClickAadharNumber();
            EnterAadharNumber(aadharnumber);
            ClickAadharVerify();
        } else Report.logInfo(!verifiedText.isEmpty() ? "Aadhar is already applied" : "Aadhar not found");

        return this;
    }


    public GovernmentIDs ClickAadharNumber() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(Aadharnumber));
        Aadharnumber.click();
        return this;
    }
    public GovernmentIDs EnterAadharNumber(String aadharnumber ) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(Aadharnumber));
        Aadharnumber.clear();
        Aadharnumber.sendKeys(aadharnumber);
        driver.hideKeyboard();
        return this;
    }
    public GovernmentIDs ClickAadharVerify() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(aadharverify));
        aadharverify.click();
        Thread.sleep(40000);
        return this;
    }
    public GovernmentIDs PANFlow(String pannumber) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try {
            if (panverify.isDisplayed()) {
              ClickPAN();
              EnterPANnumber(pannumber);
              ClickPanVerify();
            }
        } catch (Exception e) {
            if (panverified.isDisplayed()) {
            } else {
                String isReadOnly = PANnumber.getAttribute("readonly");
                String isEnabled = PANnumber.getAttribute("enabled");

                if ("true".equalsIgnoreCase(isReadOnly) || "false".equalsIgnoreCase(isEnabled)) {
                    Report.logPass("PAN field is already non-editable (verified).");
                } else {
                    Report.logFail("PAN field is editable but verify button not found — inconsistent state.");
                }
            }
        }

        return this;
    }
    public GovernmentIDs ClickPAN() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(PANnumber));
        PANnumber.click();
        return this;
    }
    public GovernmentIDs EnterPANnumber(String pannumber ) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(PANnumber));
        PANnumber.clear();
        PANnumber.sendKeys(pannumber);
        driver.hideKeyboard();
        return this;
    }
    public GovernmentIDs ClickPanVerify() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(panverify));
        panverify.click();

        return this;
    }
    public GovernmentIDs UploadAadhar() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        if (!driver.findElements(By.xpath("//android.view.ViewGroup[@content-desc=\"Upload Aadhaar\"]")).isEmpty()) {
            ClickUploadAadhar();
            ClickCamera();
            ClickTakePicture();
            ClickCameraOkButton();
        }
        else if (!driver.findElements(By.xpath("//android.widget.TextView[@resource-id=\"Aadhaar-delete-doc\"]")).isEmpty()) {
            ClickAadharDelete();
            ClickUploadAadhar();
            ClickCamera();
            ClickTakePicture();
            ClickCameraOkButton();
        }
        return this;
    }

    public GovernmentIDs ClickUploadAadhar() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.elementToBeClickable(Uploadaadhar));
        Uploadaadhar.click();
        return this;
    }

    public GovernmentIDs UploadPAN() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        if (!driver.findElements(By.xpath("//android.view.ViewGroup[@content-desc=\"Upload Pan\"]")).isEmpty()) {
           ClickUploadPAN();
            ClickCamera();
            ClickTakePicture();
            ClickCameraOkButton();
        }
        else if (!driver.findElements(By.xpath("//android.widget.TextView[@resource-id=\"Pan-delete-doc\"]")).isEmpty()) {
            ClickPANDelete();
            ClickUploadPAN();
            ClickCamera();
            ClickTakePicture();
            ClickCameraOkButton();
        }
        return this;
    }
    public GovernmentIDs ClickUploadPAN() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.elementToBeClickable(Uploadpan));
        Uploadpan.click();
        return this;
    }

    public GovernmentIDs ClickAadharDelete() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(aadhardelete));
        aadhardelete.click();
        return this;
    }
    public GovernmentIDs ClickPANDelete() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(pandelete));
        pandelete.click();
        return this;
    }
    public GovernmentIDs ClickCamera() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(camera));
        camera.click();
        return this;
    }
    public GovernmentIDs ClickTakePicture() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(takepicture));
        takepicture.click();
        return this;
    }
    public GovernmentIDs ClickCameraOkButton() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(cameraok));
        cameraok.click();
        Thread.sleep(2000);
        return this;
    }

}
