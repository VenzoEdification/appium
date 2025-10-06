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
import utils.extent.CommonMethods;

import java.net.MalformedURLException;
import java.time.Duration;

public class Experience extends Report {
    private AndroidDriver driver;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Experience\"]")
    public WebElement Experience;
    @FindBy(how = How.XPATH, using = "//android.widget.EditText[@resource-id=\"experience-input\"]")
    public WebElement Experienceinyears;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@resource-id=\"industry-input\"]")
    public WebElement Industry;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@resource-id=\"option-1\"]")
    public WebElement Industryfield;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@resource-id=\"skill-input\"]")
    public WebElement skill;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@resource-id=\"option-1\"]")
    public WebElement skillfield;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@resource-id=\"esic-input\"]")
    public WebElement esic;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Available\"]")
    public WebElement esicoption;
    @FindBy(how = How.XPATH, using = "//android.widget.EditText[@resource-id=\"esic-no-input\"]")
    public WebElement Enteresic;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@resource-id=\"pf-input\"]")
    public WebElement pf;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@resource-id=\"option-0\"]")
    public WebElement pfoption;
    @FindBy(how = How.XPATH, using = "//android.widget.EditText[@resource-id=\"pf-no-input\"]")
    public WebElement enterpf;



    public Experience() throws MalformedURLException {
        this.driver = SharedDriver.getCapabilities();
        PageFactory.initElements(driver, this);
    }
    public Experience ClickExperienceTab() {
        Experience.click();
        return this;
    }
    public Experience ClickExperienceinYears() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(Experienceinyears));
        Experienceinyears.click();
        return this;
    }
    public Experience EnterExperienceinYears(String experience ) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(Experienceinyears));
        Experienceinyears.clear();
        Experienceinyears.sendKeys(experience);
        driver.hideKeyboard();
        return this;
    }
    public Experience ClickIndustry() {
        Industry.click();
        return this;
    }
    public Experience SelectIndustry() throws InterruptedException {
        Industryfield.click();
        Thread.sleep(4000);
        return this;
    }
    public Experience ClickSkill() throws InterruptedException {
        skill.clear();
        skill.click();
        Thread.sleep(3000);
        return this;
    }
    public Experience SelectSkill() throws InterruptedException {
        skillfield.click();
        Thread.sleep(3000);
        return this;
    }
    public Experience ClickESIC() throws InterruptedException {
        esic.click();
        Thread.sleep(3000);
        return this;
    }
    public Experience SelectESIC() throws InterruptedException {
        esicoption.click();

        return this;
    }
    public Experience EnterESIC() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(Enteresic));
            String generateESIC = CommonMethods.generateRandomESIC();
            Enteresic.clear();
            Enteresic.sendKeys(generateESIC);
            driver.hideKeyboard();
        return this;
    }
    public Experience ClickPF() throws InterruptedException {
        pf.click();
        Thread.sleep(3000);
        return this;
    }
    public Experience SelectPF() {
        pfoption.click();
        return this;
    }
    public Experience EnterPF() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(enterpf));
        String generatePF = CommonMethods.generateRandomPF();
        enterpf.clear();
        enterpf.sendKeys(generatePF);
        driver.hideKeyboard();
        return this;
    }

}

