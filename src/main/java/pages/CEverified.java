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
import io.appium.java_client.AppiumBy;

import java.net.MalformedURLException;
import java.time.Duration;

public class CEverified extends Report {
    private AndroidDriver driver;

    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[starts-with@resource-id ,'Employed']")
    public WebElement Employed;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@resource-id=\"Verified-talents\"]")
    public WebElement verified;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@resource-id=\"Employed0\"]")
    public WebElement Employedname;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@resource-id=\"availble0\"]")
    public WebElement availabletalentname;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@resource-id=\"Profile-back\"]/android.widget.ImageView")
    public WebElement profilebackbutton;
    public CEverified()throws MalformedURLException {
        this.driver = SharedDriver.getCapabilities(); // Initialize the driver
        PageFactory.initElements(driver, this);
    }

    public CEverified ClickEmployed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement employedTab = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.view.ViewGroup[starts-with(@content-desc, 'Employed')]")));

        employedTab.click();
        return this;
    }

    public CEverified ClickVerified() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.elementToBeClickable(verified));
        verified.click();
        return this;
    }
    public CEverified CLickEmployedName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(Employedname));
        Employedname.click();
        return this;
    }
    public CEverified ClickAvailable() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement employedTab = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.view.ViewGroup[@resource-id='Available')]")));

        employedTab.click();
        return this;
    }
    public CEverified CLickAvailableTalentName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(availabletalentname));
        availabletalentname.click();
        return this;
    }
    public CEverified CLickProfileBackButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(profilebackbutton));
        profilebackbutton.click();
        return this;
    }


}
