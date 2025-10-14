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

public class CEWithAadhar extends Report {
    private AndroidDriver driver;

    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"+\"]")
    public WebElement addtalents;
    @FindBy(how = How.XPATH, using = "//android.widget.EditText[@resource-id=\"Mob-input\"]")
    public WebElement mobilenumber;
    @FindBy(how = How.XPATH, using = "//android.widget.EditText[@resource-id=\"Aadhaar-input\"]")
    public WebElement aadharinput;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"With Aadhar Verification\"]/android.view.ViewGroup")
    public WebElement aadharwith;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Confirm\"]")
    public WebElement confirm;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Confirm\"]")
    public WebElement verify;

    public CEWithAadhar() throws MalformedURLException {
        this.driver = SharedDriver.getCapabilities();
        PageFactory.initElements(driver, this);
    }

    public CEWithAadhar ClickAddTalentButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.elementToBeClickable(addtalents));
        addtalents.click();
        return this;
    }

    public CEWithAadhar EnterMobileNumber(String MobileNumber) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(mobilenumber));
        mobilenumber.click();
        Thread.sleep(500);
        mobilenumber.sendKeys(MobileNumber);
        driver.hideKeyboard();
        return this;

    }
    public CEWithAadhar EnterAadharNumber(String aadhar) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(aadharinput));
        aadharinput.click();
        Thread.sleep(500);
        aadharinput.sendKeys(aadhar);
        driver.hideKeyboard();
        return this;

    }
    public CEWithAadhar ClickConfirmButton() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(confirm));
        confirm.click();
        Thread.sleep(65000);
        return this;
    }
    public CEWithAadhar ClickWithAadhar() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(aadharwith));
        aadharwith.click();
        return this;
    }




}

