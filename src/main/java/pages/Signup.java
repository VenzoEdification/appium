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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Signup extends Report {
    AndroidDriver driver;

    @FindBy(how= How.XPATH, using = "//android.widget.TextView[@text=\"Sign up\"]\n")
    public WebElement signuplink;

    @FindBy(how = How.XPATH , using = "//android.widget.Button[@resource-id='android:id/button1']")
    public WebElement CalenderOk;
    @FindBy(how = How.XPATH,
            using ="//android.view.ViewGroup[@resource-id=\"dob-input\"]")
    public WebElement calenderIcon;
    @FindBy(how= How.XPATH, using = "//android.widget.EditText[@resource-id=\"name-input\"]" )
    public WebElement name;
    @FindBy(how= How.XPATH, using = "//android.widget.EditText[@resource-id=\"mobile-input\"]" )
    public WebElement mobilenumber;
    @FindBy(how = How.XPATH ,using="//android.view.ViewGroup[@resource-id=\"agree-check\"]/android.widget.ImageView")
    public WebElement agreecheckbox;

    @FindBy(how = How.XPATH ,using="//android.view.ViewGroup[@content-desc=\"Send code\"]")
    public WebElement sendcode;

    @FindBy(how = How.XPATH , using = "//android.widget.TextView[@text=\"Female\"]")
    public WebElement female;


    public Signup() throws MalformedURLException {
        this.driver = SharedDriver.getCapabilities();
        PageFactory.initElements(driver, this);
    }
    public Signup ClickSignupLink(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(signuplink));
        signuplink.click();
        return this;
    }
    public Signup ClickName(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(name));
        name.click();
        return this;
    }
    public Signup ClickcalenderIcon(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(calenderIcon));
        calenderIcon.click();
        return this;
    }
    public Signup EnterName(String Signupname){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(name));
        name.sendKeys(Signupname);
        return this;
    }

    public Signup SelectDate(String dateip) throws InterruptedException {
        DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("M/d/yyyy");

        LocalDate targetDate = LocalDate.parse(dateip, inputFormat);
        LocalDate currentDate = LocalDate.now();

        boolean isPast = targetDate.isBefore(currentDate);

        String formattedDate = targetDate.format(outputFormat);
        System.out.println(formattedDate+": formattedDate");

        while (true) {
            try {
                WebElement datepicker = driver.findElement(
                        By.xpath("//android.view.View[@content-desc='" + formattedDate + "']")
                );
                datepicker.click();
                break;
            } catch (Exception e) {
                if (isPast) {
                    driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Previous month']")).click();
                    Thread.sleep(2000);
                } else {
                    driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Next month']")).click();
                }
                Thread.sleep(500);
            }
        }

        return this;
    }


    public Signup ClickcalenderOk(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(CalenderOk));
        CalenderOk.click();
        return this;
    }
    public Signup ClickSendCodeButton() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(sendcode));
        sendcode.click();
        Thread.sleep(3000);
        return this;
    }
    public Signup ChooseGender() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(female));
        female.click();
        Thread.sleep(3000);

        return this;
    }
    public Signup EnterMobileNumber(String mobile) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(mobilenumber));
        mobilenumber.click();
        Thread.sleep(1000);
        mobilenumber.sendKeys(mobile);
        driver.hideKeyboard();
        return this;
    }
    public Signup ClickAgreeCheckBOx() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(agreecheckbox));
        agreecheckbox.click();

        return this;
    }


}
