package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[android.widget.TextView[@text='Without Aadhar Verification']]/android.view.ViewGroup")
    public WebElement aadharwithout;
    @FindBy(how = How.XPATH, using = "//android.widget.EditText[@resource-id=\"Name-input\"]")
    public WebElement name;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@resource-id=\"DobButton\"]")
    public WebElement ClickCalender;
    @FindBy(how = How.XPATH, using = "//android.widget.Button[@resource-id='android:id/button1']")
    public WebElement CalenderOk;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@resource-id=\"genderRadioButton-Female\"]/ancestor::android.view.ViewGroup[@clickable=\"true\"]\n")
    public WebElement gender;


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
        Report.logInfo("Entered Mobile Number:" + generatemobilenumber);
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
        Report.logInfo("Entered Aadhar Number:" + generateaadharnumber);

        return this;

    }

    public CEWithoutAadhar clickWithoutAadhar() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));


        driver.findElement(MobileBy.id("Aadhaar-Without Aadhar Verification")).click();

        // driver.findElement(AppiumBy.accessibilityId("Without Aadhar Verification")).click();
        return this;
    }

    public CEWithoutAadhar EnterName(String talentname) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(name));
        name.click();
        Thread.sleep(500);
        name.sendKeys(talentname);
        driver.hideKeyboard();
        return this;

    }

    public CEWithoutAadhar Selectgender() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(gender));
        gender.click();
        return this;
    }

    public CEWithoutAadhar ClickcalenderOk() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(CalenderOk));
        CalenderOk.click();
        return this;
    }

    public CEWithoutAadhar enterDOB(String dateip) throws InterruptedException {
        ClickCalender.click();
        DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("M/d/yyyy");

        LocalDate targetDate = LocalDate.parse(dateip, inputFormat);
        LocalDate currentDate = LocalDate.now();

        boolean isPast = targetDate.isBefore(currentDate);

        String formattedDate = targetDate.format(outputFormat);
        System.out.println(formattedDate + ": formattedDate");

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

    public CEWithoutAadhar ValidateTalent() {
        try {
            By talentLocator = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"Name\"]");
            By talentstatus = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"Status-Text\"]");


            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
            wait.until(ExpectedConditions.visibilityOfElementLocated(talentLocator));

            WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(30));
            waits.until(ExpectedConditions.visibilityOfElementLocated(talentstatus));

            WebElement element = driver.findElement(talentLocator);
            String talentName = element.getText();

            WebElement elements = driver.findElement(talentstatus);
            String talentStatus = elements.getText();

            Report.logInfo("Viewed Talent Name: " + talentName + " - " +"Talent Status: " +talentStatus);


        } catch (Exception e) {
            Report.logFail("Failed to get viewed talent name: " + e.getMessage());
            throw e;
        }
        return this;
    }
}

