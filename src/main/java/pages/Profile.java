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

public class Profile extends Report {
    AndroidDriver driver;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Nationality\"]")
    public WebElement nationality;
    @FindBy(how = How.XPATH,using = "//android.widget.TextView[@text=\"Indian\"]")
    public WebElement Indian;
    @FindBy(how = How.XPATH,using = "//android.widget.EditText[@resource-id=\"personal-blood-group-input\"]")
    public WebElement BloodGroup;
    @FindBy(how = How.XPATH,using = "//android.widget.EditText[@resource-id=\"personal-father-input\"]")
    public WebElement Fathername;
    @FindBy(how = How.XPATH,using = "//android.widget.EditText[@resource-id=\"personal-email-input\"]")
    public WebElement Email;
    @FindBy(how = How.XPATH,using = "//android.widget.EditText[@text=\"Address Line 1\"]")
    public WebElement Address;
    @FindBy(how = How.XPATH,using = "//android.widget.EditText[@text=\"City\"]")
    public WebElement City;
    @FindBy(how = How.XPATH,using = "//android.widget.EditText[@text=\"Pincode\"]")
    public WebElement Pincode;
    @FindBy(how = How.XPATH,using = "//android.view.ViewGroup[@content-desc=\"Update\"]")
    public WebElement Update;
    @FindBy(how = How.XPATH,using = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.ImageView")
    public WebElement Uploadimage;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Personal\"]")
    public WebElement clickpersonal;

    public Personal() throws MalformedURLException {
        this.driver = SharedDriver.getCapabilities();
        PageFactory.initElements(driver, this);
    }

    public Personal ClickPersonaldetails()  {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(clickpersonal));
        clickpersonal.click();
        return this;
    }
    public Personal ClickNationality() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(nationality));
        nationality.click();
        return this;
    }
    public Personal ClickIndian() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(Indian));
        Indian.click();
        return this;
    }
    public Personal ClickBloodGroup() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(BloodGroup));
        BloodGroup.click();
        return this;
    }
    public Personal EnterBloodGroup(String Bloodgroup) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(BloodGroup));
        BloodGroup.sendKeys(Bloodgroup);
        return this;
    }
    public Personal ClickFathername() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(Fathername));
        Fathername.click();
        return this;
    }
    public Personal EnterFathername(String fathername) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(Fathername));
        Fathername.sendKeys(fathername);
        return this;
    }
    public Personal ClickEmail() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(Email));
        Email.click();
        return this;
    }
    public Personal EnterEmail() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(ExpectedConditions.elementToBeClickable(Email));
        String generatedEmail = CommonMethods.generateRandomEmail();
        Email.sendKeys(generatedEmail);

        return this;
    }
    public Personal ClickAddressLine() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(Address));
        Address.click();
        return this;
    }
    public Personal EnterAddressLine1(String AddressLine1) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(Address));
        Address.sendKeys(AddressLine1);
        return this;
    }
    public Personal ClickCity() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(City));
        City.click();
        return this;
    }
    public Personal EnterCity(String cityName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(City));
        City.sendKeys(cityName);
        return this;
    }
    public Personal ClickPincode() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(Pincode));
        Pincode.click();
        return this;
    }

    public Personal EnterPincode(String pincode) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(Pincode));
        Pincode.sendKeys(pincode);
        return this;
    }
    public Personal ClickUpdateButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(Update));
        Update.click();
        return this;
    }
    public Personal ClickUploadImage() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(Uploadimage));
        Uploadimage.click();
        return this;
    }

    public Personal UploadImage(String imagePath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(Uploadimage));
        Uploadimage.click();
        return this;
    }





}