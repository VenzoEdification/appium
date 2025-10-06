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

public class GovernmentIDs extends Report {
    AndroidDriver driver;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Education\"]")
    public WebElement GovernmentIDstab;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Education\"]")
    public WebElement Aadharnumber;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Education\"]")
    public WebElement verify ;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Education\"]")
    public WebElement PANnumber ;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Education\"]")
    public WebElement Uploadaadhar ;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Education\"]")
    public WebElement Uploadpan ;

    public GovernmentIDs() throws MalformedURLException {
        this.driver = SharedDriver.getCapabilities();
        PageFactory.initElements(driver, this);
    }

    public GovernmentIDs ClickGovernmentIDs() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(GovernmentIDstab));
        GovernmentIDstab.click();
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
    public GovernmentIDs ClickVerify() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(verify));
        verify.click();
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
    public GovernmentIDs ClickUploadAadhar() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(Uploadaadhar));
        Uploadaadhar.click();
        return this;
    }
    public GovernmentIDs ClickUploadPAN() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(Uploadpan));
        Uploadpan.click();
        return this;
    }

}
