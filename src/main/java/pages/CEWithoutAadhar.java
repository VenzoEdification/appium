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
import utils.extent.CommonMethods;

import java.net.MalformedURLException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CEWithoutAadhar extends Report {
    private AndroidDriver driver;

    @FindBy(how = How.XPATH, using = "//android.widget.EditText[@resource-id=\"Mob-input\"]")
    public WebElement mobilenumber;
    @FindBy(how = How.XPATH, using = "//android.widget.EditText[@resource-id=\"Aadhaar-input\"]")
    public WebElement aadharinput;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@resource-id=\"Aadhaar-Without Aadhar Verification\"]")
    public WebElement aadharwithout;
    @FindBy(how = How.XPATH, using = "//android.widget.EditText[@resource-id=\"Name-input\"]")
    public WebElement name;
    @FindBy(how = How.XPATH, using ="//android.view.ViewGroup[@resource-id=\"dob-input\"]")
    public WebElement calenderIcon;
    @FindBy(how = How.XPATH , using = "//android.widget.Button[@resource-id='android:id/button1']")
    public WebElement CalenderOk;
    @FindBy(how = How.XPATH , using = "//android.widget.TextView[@text=\"Female\"]")
    public WebElement female;


    public CEWithoutAadhar() throws MalformedURLException {
        this.driver = SharedDriver.getCapabilities();
        PageFactory.initElements(driver, this);
    }

    public CEWithoutAadhar EnterMobileNumber() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        String generatemobilenumber = CommonMethods.generateMobileNumber();
        wait.until(ExpectedConditions.elementToBeClickable(mobilenumber));
        mobilenumber.click();
        Thread.sleep(1000);
        mobilenumber.sendKeys(generatemobilenumber);
        driver.hideKeyboard();
        return this;
    }
    public CEWithoutAadhar EnterAadharNumber() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        String generateaadharnumber = CommonMethods.generateAadhaarNumber();
        wait.until(ExpectedConditions.elementToBeClickable(aadharinput));
        aadharinput.click();
        aadharinput.sendKeys(generateaadharnumber);
        driver.hideKeyboard();
        Thread.sleep(2000);
        return this;

    }
    public CEWithoutAadhar ClickWithoutAadhar() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(aadharwithout));
        aadharwithout.click();
        driver.hideKeyboard();
        return this;
    }
    public CEWithoutAadhar EnterName(String name) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(aadharinput));
        aadharinput.click();
        Thread.sleep(500);
        aadharinput.sendKeys(name);
        driver.hideKeyboard();
        return this;

    }
    public CEWithoutAadhar ClickcalenderIcon(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(calenderIcon));
        calenderIcon.click();
        return this;
    }
    public CEWithoutAadhar ClickcalenderOk(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(CalenderOk));
        CalenderOk.click();
        return this;
    }
    public CEWithoutAadhar SelectDate(String dateip) throws InterruptedException {
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
}
