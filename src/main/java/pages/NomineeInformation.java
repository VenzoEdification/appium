package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
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

public class NomineeInformation extends Report {
    AndroidDriver driver;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Nominee\"]")
    public WebElement Nomineetab;
    @FindBy(how = How.XPATH, using = "//android.widget.EditText[@resource-id=\"nominee-name\"]")
    public WebElement Nomineename;
    @FindBy(how = How.XPATH, using = "//android.widget.EditText[@resource-id=\"nominee-name-aadhaar\"]")
    public WebElement NomineeAadharnumber;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@resource-id=\"relationship\"]")
    public WebElement relatioship;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@resource-id=\"option-2\"]")
    public WebElement selectrelationship;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@resource-id=\"nominee-dob-button\"]")
    public WebElement dob;
    @FindBy(how = How.XPATH, using = "//android.widget.Button[@resource-id=\"android:id/button1\"]")
    public WebElement okbutton;
    @FindBy(how = How.XPATH,using = "//android.widget.EditText[@resource-id=\"AddressLine1-input\"]")
    public WebElement Address;
    @FindBy(how = How.XPATH,using = "//android.view.ViewGroup[@resource-id=\"city-input\"]")
    public WebElement City;
    @FindBy(how = How.XPATH,using = "//android.widget.EditText[@resource-id=\"pincode-input\"]")
    public WebElement Pincode;
    @FindBy(how = How.XPATH, using = "//android.widget.EditText[@resource-id=\"search-text\"]")
    public WebElement searchcity;



    public NomineeInformation() throws MalformedURLException {
        this.driver = SharedDriver.getCapabilities();
        PageFactory.initElements(driver, this);
    }
    public NomineeInformation ClickNomineeTab()  {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(Nomineetab));
        Nomineetab.click();
        return this;
    }
    public NomineeInformation ClickNomineeName()  {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(Nomineename));
        Nomineename.click();
        return this;
    }
    public NomineeInformation EnterNomineeName(String NomineeName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(Nomineename));
        Nomineename.clear();
        Nomineename.sendKeys(NomineeName);
        driver.hideKeyboard();
        return this;
    }
    public NomineeInformation ClickNomineeAadharNumber()  {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(NomineeAadharnumber));
        NomineeAadharnumber.click();
        return this;
    }
    public NomineeInformation EnterNomineeAadharNumber(String NomineeAadharNumber) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(NomineeAadharnumber));
        NomineeAadharnumber.clear();
        NomineeAadharnumber.sendKeys(NomineeAadharNumber);
        driver.hideKeyboard();
        return this;
    }
    public NomineeInformation ClickRelationship()  {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(relatioship));
        relatioship.click();
        return this;
    }
    public NomineeInformation SelectRelationship()  {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(selectrelationship));
        selectrelationship.click();
        return this;
    }
    public NomineeInformation ClickDOB() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(dob));
        dob.click();
        Thread.sleep(3000);
        okbutton.click();
        return this;
    }
    public NomineeInformation EnterCity(String city) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(searchcity));
        Thread.sleep(3000);
        searchcity.sendKeys(city);
        Thread.sleep(2000);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        driver.hideKeyboard();
        return this;
    }
    public NomineeInformation EnterAddressLine1(String AddressLine1) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(Address));
        Address.clear();
        Address.sendKeys(AddressLine1);
        driver.hideKeyboard();
        Thread.sleep(3000);
        return this;
    }
    public NomineeInformation EnterPincode(String pincode) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(Pincode));
        Pincode.sendKeys(pincode);
        driver.hideKeyboard();
        return this;
    }

}
