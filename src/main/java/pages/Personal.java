package pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
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

public class Personal extends Report {
    AndroidDriver driver;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@resource-id=\"nationality-select\"]")
    public WebElement nationality;
    @FindBy(how = How.XPATH,using = "//android.widget.TextView[@text=\"Indian\"]")
    public WebElement Indian;
    @FindBy(how = How.XPATH,using = "//android.view.ViewGroup[@resource-id=\"personal-blood-group-select\"]")
    public WebElement BloodGroup;
    @FindBy(how = How.XPATH,using = "//android.widget.EditText[@resource-id=\"personal-father-input\"]")
    public WebElement Fathername;
    @FindBy(how = How.XPATH,using = "//android.widget.EditText[@resource-id=\"personal-email-input\"]")
    public WebElement Email;
    @FindBy(how = How.XPATH,using = "//android.widget.EditText[@text=\"Address Line 1\"]")
    public WebElement Address;
    @FindBy(how = How.XPATH,using = "//android.view.ViewGroup[@resource-id=\"city-input\"]")
    public WebElement City;
    @FindBy(how = How.XPATH,using = "//android.widget.EditText[@text=\"Pincode\"]")
    public WebElement Pincode;
    @FindBy(how = How.XPATH,using = "//android.view.ViewGroup[@content-desc=\"Update\"]")
    public WebElement Update;
    @FindBy(how = How.XPATH,using = "//android.view.ViewGroup[@resource-id=\"profile-edit-button\"]")
    public WebElement Uploadimage;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@text=\"Personal\"]")
    public WebElement clickpersonal;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@resource-id=\"option-A-\"]")
    public WebElement bloodgrouptype;
    @FindBy(how = How.XPATH, using = "//android.widget.EditText[@resource-id=\"search-text\"]")
    public WebElement searchcity;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@resource-id=\"personal-dob-button\"]")
    public WebElement dob;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@resource-id=\"android:id/date_picker_header_year\"]")
    public WebElement year;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@resource-id=\"android:id/date_picker_header_date\"]")
    public WebElement day;
    @FindBy(how = How.XPATH, using = "//android.widget.TextView[@resource-id=\"android:id/date_picker_header_year\"]")
    public WebElement month;
    @FindBy(how = How.XPATH, using = "//android.widget.Button[@resource-id=\"android:id/button1\"]")
    public WebElement ok;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@resource-id=\"camera-button\"]")
    public WebElement camera;
    @FindBy(how = How.XPATH, using = "//android.widget.ImageButton[@content-desc=\"Take picture\"]")
    public WebElement takepicture;
    @FindBy(how = How.XPATH, using = "//android.widget.Button[@content-desc=\"OK\"]")
    public WebElement cameraok;
    @FindBy(how = How.XPATH, using = "//android.widget.Button[@content-desc=\"Crop\"]")
    public WebElement editcrop;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Chennai\"]/android.widget.TextView[0]")
    public WebElement cityname;


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
    public Personal ClickBloodGroupType() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(bloodgrouptype));
        bloodgrouptype.click();

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
        Fathername.clear();
        Fathername.sendKeys(fathername);
        driver.hideKeyboard();
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
        Email.clear();
        Email.sendKeys(generatedEmail);
        driver.hideKeyboard();

        return this;
    }
    public Personal ClickAddressLine() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(Address));
        Address.clear();
        Address.click();
        return this;
    }
    public Personal EnterAddressLine1(String AddressLine1) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(Address));
        Address.clear();
        Address.sendKeys(AddressLine1);
        driver.hideKeyboard();
        Thread.sleep(4000);
        return this;
    }
    public Personal ClickCity() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(City));
        City.click();
        Thread.sleep((7000));
        return this;
    }
    public Personal SearchCity() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(searchcity));
        searchcity.click();
        Thread.sleep((7000));
        return this;
    }
    public Personal EnterCityName() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(cityname));
        cityname.click();
        Thread.sleep((6000));
        return this;
    }

    public Personal EnterCity(String city) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(searchcity));
        Thread.sleep(5000);
        searchcity.sendKeys(city);
        driver.hideKeyboard();
        return this;
    }

    public Personal ClickPincode() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(Pincode));
        Pincode.clear();
        Pincode.click();
        return this;
    }

    public Personal EnterPincode(String pincode) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(Pincode));
        Pincode.sendKeys(pincode);
        driver.hideKeyboard();
        return this;
    }
    public Personal ClickUpdateButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(Update));
        Update.click();
        return this;
    }
    public Personal ClickCamera() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(camera));
        camera.click();
        return this;
    }
    public Personal ClickTakePicture() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(takepicture));
        takepicture.click();
        return this;
    }
    public Personal ClickCameraOkButton() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(cameraok));
        cameraok.click();
        return this;
    }
    public Personal ClickEditCrop() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(editcrop));
        editcrop.click();
        return this;
    }

    public Personal UploadImage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(Uploadimage));
        Uploadimage.click();
        return this;
    }
    public Personal CLickDateofBirth() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(dob));
        dob.click();
        Thread.sleep(4000);
        ok.click();
        return this;
    }

}