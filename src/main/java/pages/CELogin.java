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

public class CELogin extends Report {
    private AndroidDriver driver;

    @FindBy(how = How.XPATH, using = "//android.widget.EditText[@resource-id=\"login-mobile-input\"]")
    public WebElement NumberField;
    @FindBy(how = How.XPATH, using = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[1]")
    public WebElement enterotp;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text=\"Verify\"]")
    public WebElement clickverify;

    public CELogin() throws MalformedURLException {
        this.driver = SharedDriver.getCapabilities(); // Initialize the driver
        PageFactory.initElements(driver, this);
    }

    public CELogin EnterMobileNumber(String phoneNumber) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(NumberField));
        NumberField.sendKeys(phoneNumber);
        return this;
    }
    public CELogin EnterOTP() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        Thread.sleep(5000);
        enterotp.click();
        for (int i = 1; i <= 6; i++) {
            driver.findElement(By.xpath(
                    "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[" + i + "]"
            )).sendKeys("0");
        }
        return this;
    }
    public CELogin ClickVerifyButton() throws InterruptedException {
        clickverify.click();
        Thread.sleep(3000);
        return this;
    }




}
