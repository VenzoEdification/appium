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
import java.util.List;

public class JobApply extends Report {
    AndroidDriver driver;

    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Job, View more\"]")
    public WebElement jobmenu;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@resource-id=\"job-view-button\"]")
    public WebElement jobviewbutton;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text=\"Applied\"]")
    public WebElement jobapplied;
    @FindBy(how = How.XPATH, using = "//android.widget.EditText[@resource-id=\"job-search\"]")
    public WebElement jobsearch;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@resource-id=\"job-apply\"]")
    public WebElement jobapplynow;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Back to Job\"]")
    public WebElement backtojob;


    public JobApply() throws MalformedURLException {
        this.driver = SharedDriver.getCapabilities();
        PageFactory.initElements(driver, this);
    }

    public JobApply ClickJobMenu() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(jobmenu));
        jobmenu.click();
        return this;
    }

    public JobApply ClickJobView() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(jobviewbutton));
        jobviewbutton.click();
        return this;
    }

    public JobApply ClickJobApplyNow() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(jobapplynow));
        jobapplynow.click();
        return this;
    }

    public JobApply ClickBacktojob() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(backtojob));
        backtojob.click();
        return this;
    }


    public JobApply JobSearch(String job) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(jobsearch));
        jobsearch.click();
        jobsearch.sendKeys(job);
        driver.hideKeyboard();
        return this;
    }

    public JobApply ApplyJob() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        List<WebElement> applyButton = driver.findElements(By.xpath("//android.view.ViewGroup[@resource-id='job-apply']"));

        List<WebElement> appliedText = driver.findElements(By.xpath("//android.widget.TextView[@text='Applied']"));

        if (applyButton.isEmpty() && appliedText.isEmpty()) {

            applyButton = driver.findElements(By.xpath("//android.view.ViewGroup[@resource-id='job-apply']"));
            appliedText = driver.findElements(By.xpath("//android.widget.TextView[@text='Applied']"));
        }
        if (!applyButton.isEmpty()) {
            applyButton.get(0).click();
            ClickBacktojob();
        } else if (!appliedText.isEmpty()) {
            Report.logInfo("Job is already applied");
        } else {
            Report.logFail("Job Apply button or Applied status not found");
        }


        return this;
    }

    public JobApply driverquit() {
        driver.quit();
        return this;
    }

    }





