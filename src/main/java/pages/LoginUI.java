package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Report;
import utils.SharedDriver;
import org.openqa.selenium.support.PageFactory;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Map;

public class LoginUI extends Report {
    AndroidDriver driver;

    @FindBy(how = How.ID, using = "com.sec.android.app.popupcalculator:id/calc_keypad_btn_08")
    public WebElement eight;

    @FindBy(how = How.XPATH,
            using = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView")
    public WebElement logo;

    @FindBy(how = How.XPATH, using = "//android.widget.EditText[@text=\"Enter number\"]")
    public WebElement NumberField;

    @FindBy(how = How.XPATH, using = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.ImageView")
    public WebElement TermsCheckBox;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text=\"Send code\"]")
    public WebElement sendCode;

    @FindBy(how = How.XPATH, using = "//android.widget.CheckBox[@resource-id=\"recaptcha-anchor\"]")
    public WebElement CaptchaBox;

    public LoginUI() {

//        try {
//            this.driver = SharedDriver.getCapabilities(); // Initialize the driver
//        } catch (MalformedURLException e) {
//            throw new RuntimeException(e);
//        }
//        PageFactory.initElements(driver, this);

    }

    public void setupDriver() {
        try {
            this.driver = SharedDriver.getCapabilities();
            PageFactory.initElements(driver, this);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public LoginUI clickEight(String heading) {
        driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_edt_formula")).sendKeys(heading);

        // eight.click();
//    if (eight != null) {
//            eight.click();
//            Report.test.get().info("Eight clicked successfully");
//        } else {
//            Report.test.get().fail("Element 'eight' was not initialized correctly.");
//        }
        return this;
    }

    public LoginUI CheckLogo()  {
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        logo.isDisplayed();
        System.out.println("***Logo Appeared***");
        return this;
    }

    public LoginUI EnterMobileNumber(String num){
        NumberField.sendKeys(num);
        return this;
    }

    public LoginUI ClickTermsCheckBox(){
        TermsCheckBox.click();
        return this;
    }

    public LoginUI ClicksendCode(){
        sendCode.click();
        return this;
    }

    public LoginUI ClickCaptchaBox(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(CaptchaBox));

        CaptchaBox.click();
        return this;
    }


}

