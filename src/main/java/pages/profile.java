package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Report;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class profile extends Report {
        WebDriver driver;

        @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"My Account, View more\"]")
        public WebElement clickmyaccount;
        @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Personal\"]")
        public WebElement clickpersonal;

        public profile(AndroidDriver driver) {
                super();
                this.driver = this.driver;
                PageFactory.initElements(this.driver, this);
        }
        public profile ClickMyAccount() throws InterruptedException {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
                wait.until(ExpectedConditions.elementToBeClickable(clickmyaccount));
                clickmyaccount.click();
                return this;
        }
        public profile ClickPersonaldetails()  {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
                wait.until(ExpectedConditions.elementToBeClickable(clickpersonal));
                clickpersonal.click();
                return this;
        }

}
