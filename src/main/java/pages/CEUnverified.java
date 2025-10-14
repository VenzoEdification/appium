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

public class CEUnverified  extends Report {
    private AndroidDriver driver;

    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@resource-id=\"Unverified-talents\"]")
    public WebElement unverified;
    @FindBy(how = How.XPATH, using = "//android.view.View[@content-desc=\"Incomplete (166)\"]/android.view.ViewGroup")
    public WebElement incomplete;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text=\"Yet To Verified (1)\"]")
    public WebElement yettoverified;

    public CEUnverified()throws MalformedURLException {
        this.driver = SharedDriver.getCapabilities(); // Initialize the driver
        PageFactory.initElements(driver, this);
    }
    public CEUnverified ClickUnVerified() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.elementToBeClickable(unverified));
        unverified.click();
        return this;
    }
    public CEUnverified ClickIncomplete() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.elementToBeClickable(incomplete));
        incomplete.click();
        return this;
    }
    public CEUnverified ClickyettoVerified() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.elementToBeClickable(yettoverified));
        yettoverified.click();
        return this;
    }
}
