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

public class NomineeInformation extends Report {
    AndroidDriver driver;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Nominee\"]")
    public WebElement Nomineetab;
    @FindBy(how = How.XPATH, using = "//android.widget.EditText[@resource-id=\"nominee-name\"]")
    public WebElement Nomineename;
    @FindBy(how = How.XPATH, using = "//android.widget.EditText[@resource-id=\"nominee-name-aadhaar\"]")
    public WebElement NomineeAadharnumber;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Relationship\"]")
    public WebElement relatioship;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@resource-id=\"option-2\"]")
    public WebElement selectrelationship;



    public NomineeInformation() throws MalformedURLException {
        this.driver = SharedDriver.getCapabilities();
        PageFactory.initElements(driver, this);
    }
    public NomineeInformation ClickNomineeTab()  {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
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
}
