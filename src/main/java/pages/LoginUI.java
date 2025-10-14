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

public class LoginUI extends Report {
    private AndroidDriver driver;

    @FindBy(how = How.XPATH,
            using = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView")
    public WebElement logo;

    @FindBy(how = How.XPATH, using = "//android.widget.EditText[@resource-id=\"login-mobile-input\"]")
    public WebElement NumberField;

    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@resource-id=\"login-agree-check\"]/android.widget.ImageView")
    public WebElement TermsCheckBox;

    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Send code\"]")
    public WebElement sendCode;

    @FindBy(how = How.XPATH, using = "//android.widget.CheckBox[@resource-id=\"recaptcha-anchor\"]")
    public WebElement CaptchaBox;

    @FindBy(how = How.XPATH, using = "//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]")
    public WebElement clickallownotification;

    @FindBy(how = How.XPATH, using = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[1]")
    public WebElement enterotp;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text=\"Verify\"]")
    public WebElement clickverify;

    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"My Account, View more\"]")
    public WebElement clickmyaccount;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text=\"OK\"]")
    public WebElement remainderok;




    public LoginUI() throws MalformedURLException {
        this.driver = SharedDriver.getCapabilities(); // Initialize the driver
        PageFactory.initElements(driver, this);
    }

    public LoginUI EnterMobileNumber(String phoneNumber) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
            wait.until(ExpectedConditions.elementToBeClickable(NumberField));
            NumberField.sendKeys(phoneNumber);
            return this;
    }


    public LoginUI ClickTermsCheckBox() {
        TermsCheckBox.click();
        return this;
    }

    public LoginUI ClicksendCode() {
        sendCode.click();
        return this;
    }

    public LoginUI ClickAllownotification() throws InterruptedException {
        Thread.sleep(6000);
        clickallownotification.click();
        return this;
    }

    public LoginUI EnterOTP() throws InterruptedException {
        Thread.sleep(5000);
        enterotp.click();
        for (int i = 1; i <= 6; i++) {
            driver.findElement(By.xpath(
                    "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[" + i + "]"
            )).sendKeys("7");
        }
        return this;
    }

    public LoginUI ClickVerifyButton() throws InterruptedException {
        clickverify.click();
        Thread.sleep(3000);
        remainderok.click();
        return this;
    }
    public LoginUI ClickMyAccount() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(clickmyaccount));
        clickmyaccount.click();
        return this;
    }


}
