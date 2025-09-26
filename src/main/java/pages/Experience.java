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

public class Experience extends Report {
    private AndroidDriver driver;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@resource-id=\"Experience\"]")
    public WebElement Experience;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@resource-id=\"Experience\"]")
    public WebElement Experienceinyears;

    public Experience() throws MalformedURLException {
        this.driver = SharedDriver.getCapabilities();
        PageFactory.initElements(driver, this);
    }
    public Experience ClickExperienceTab() {
        Experience.click();
        return this;
    }
    public Experience ClickExperienceinYears() {
        Experienceinyears.click();
        return this;
    }

}

