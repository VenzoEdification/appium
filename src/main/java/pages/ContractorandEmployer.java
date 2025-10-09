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

public class ContractorandEmployer extends Report {
    AndroidDriver driver;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@resource-id=\"Contractor & Employer\"]")
    public WebElement contractorandemployertab;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"History\"]")
    public WebElement historybutton;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@resource-id=\"history-back\"]/android.widget.ImageView")
    public WebElement historybackbutton;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@resource-id=\"back-button\"]")
    public WebElement contractorbackbutton;


    public ContractorandEmployer() throws MalformedURLException {
        this.driver = SharedDriver.getCapabilities();
        PageFactory.initElements(driver, this);
    }

    public ContractorandEmployer ClickContractorandEmployerTab() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(contractorandemployertab));
        contractorandemployertab.click();
        return this;
    }
    public ContractorandEmployer ClickHistory() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(historybutton));
        historybutton.click();
        return this;
    }
    public ContractorandEmployer ClickBackButton() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(historybackbutton));
        historybackbutton.click();
        Thread.sleep(2000);
        contractorbackbutton.click();
        return this;
    }


}
