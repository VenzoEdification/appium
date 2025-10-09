package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.SharedDriver;
import utils.extent.CommonMethods;

import java.net.MalformedURLException;
import java.time.Duration;

public class BankAccount {
    private String generatedAccountNumber;
    AndroidDriver driver;
    @FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Bank Account\"]")
    public WebElement bankaccounttab;
    @FindBy(how = How.XPATH, using = "//android.widget.EditText[@resource-id=\"bank-name\"]")
    public WebElement bankname;
    @FindBy(how = How.XPATH, using = "//android.widget.EditText[@resource-id=\"account-Holder-name\"]")
    public WebElement accountholdername;
    @FindBy(how = How.XPATH, using = "//android.widget.EditText[@resource-id=\"branch-name\"]")
    public WebElement branchname;
    @FindBy(how = How.XPATH, using = "//android.widget.EditText[@resource-id=\"ifsc-code\"]")
    public WebElement ifsc;
    @FindBy(how = How.XPATH, using = "//android.widget.EditText[@resource-id=\"account-number\"]")
    public WebElement accountnumber;

    @FindBy(how = How.XPATH, using = "//android.widget.EditText[@resource-id=\"retype-account-number\"]")
    public WebElement retypeaccount;


    public BankAccount() throws MalformedURLException {
        this.driver = SharedDriver.getCapabilities();
        PageFactory.initElements(driver, this);
    }
    public BankAccount ClickBankAccount()  {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(bankaccounttab));
        bankaccounttab.click();
        return this;
    }
    public BankAccount ClickAccountHolderName()  {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(accountholdername));
        accountholdername.click();
        return this;
    }
    public BankAccount EnterAccountHolderName(String AccountHolderName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(accountholdername));
        accountholdername.clear();
        accountholdername.sendKeys(AccountHolderName);
        driver.hideKeyboard();
        return this;
    }


        public BankAccount ClickBankName()  {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(bankname));
        bankname.click();
        return this;
    }
    public BankAccount EnterBankName(String BankName)  {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(bankname));
        bankname.clear();
        bankname.sendKeys(BankName);
        driver.hideKeyboard();
        return this;
    }
    public BankAccount ClickBranchName()  {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(branchname));
        branchname.click();
        return this;
    }
    public BankAccount EnterBranchName(String BranchName)  {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(branchname));
        branchname.clear();
        branchname.sendKeys(BranchName);
        driver.hideKeyboard();
        return this;
    }
    public BankAccount ClickIFSC()  {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(ifsc));
        ifsc.click();
        return this;
    }
    public BankAccount EnterIFSC(String BranchName)  {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(ifsc));
        ifsc.clear();
        ifsc.sendKeys(BranchName);
        driver.hideKeyboard();
        return this;
    }
    public BankAccount ClickAccountNumber()  {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(accountnumber));
        accountnumber.click();
        return this;
    }
    public BankAccount EnterAccountNumber() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.elementToBeClickable(accountnumber));
            accountnumber.clear();
            generatedAccountNumber = CommonMethods.generateAccount(10);
            accountnumber.sendKeys(generatedAccountNumber);
            driver.hideKeyboard();
            return this;
        }

    public BankAccount ClickRetypeAccountNumber()  {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(retypeaccount));
        retypeaccount.click();
        return this;
    }
    public BankAccount EnterRetypeAccountNumber()  {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        retypeaccount.clear();
        wait.until(ExpectedConditions.elementToBeClickable(retypeaccount));
        retypeaccount.sendKeys(generatedAccountNumber);
        driver.hideKeyboard();
        return this;
    }


}
