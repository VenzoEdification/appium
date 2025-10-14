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
    @FindBy(how = How.XPATH, using = "//android.view.View[contains(@content-desc, 'Incomplete')]/android.view.ViewGroup")
    public WebElement incomplete;

    @FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@text, 'Yet To Verified')]")
    public WebElement yettoverified;

    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@resource-id=\"yet-to-verified0\"]")
    public WebElement yettoverifiedtalentname;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@resource-id=\"incomplete0\"]")
    public WebElement IncompleteTalentName;

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
    public CEUnverified ClickyettoVerifiedtalentname() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.elementToBeClickable(yettoverifiedtalentname));
        yettoverifiedtalentname.click();
        return this;
    }
    public CEUnverified Clickincompletetalentname() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.elementToBeClickable(IncompleteTalentName));
        IncompleteTalentName.click();
        return this;
    }
}
