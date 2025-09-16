package stepDefinition.talentX;

import driver.driverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginUI;
import utils.Excelutil;
import utils.Report;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

public class LoginSteps  {

    LoginUI loginUI = new LoginUI(driverManager.getDriver());
    private Map<String, String> testData; // holds one row of Excel

    public LoginSteps() throws MalformedURLException {
        super();
        try {
            Excelutil reader = new Excelutil();
            testData = reader.getRowData("input/Login.xlsx", "Login", 1);
            System.out.println("Loaded Login Test Data: " + testData);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load test data from Excel", e);
        }
    }

    @Given("the TALENTx app is launched")
    public void the_TALENTx_app_is_launched() {
        try {
            Thread.sleep(5000);
            Report.logInfo("TALENTx app is launched successfully");
        } catch (Exception e) {
            Report.logFail("Failed to launch TALENTx app: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Then("click allow button")
    public void click_allow_button() {
        try {
            loginUI.ClickAllownotification();
            Report.logInfo("Clicked Allow button successfully");
        } catch (Exception e) {
            Report.logFail("Failed to click Allow button: " + e.getMessage());
            throw e;
        }
    }

    @When("enter the value {string}")
    public void enter_the_value_(String phoneNumber) {
        try {
            loginUI.EnterMobileNumber(testData.get(phoneNumber));
            Report.logInfo("Entered phone number: " + testData.get(phoneNumber));
        } catch (Exception e) {
            Report.logFail("Failed to enter phone number: " + e.getMessage());
            throw e;
        }
    }

    @When("click Terms and Agreement")
    public void click_Terms_and_Agreement() {
        try {
            loginUI.ClickTermsCheckBox();
            Report.logInfo("Clicked Terms and Agreement checkbox");
        } catch (Exception e) {
            Report.logFail("Failed to click Terms and Agreement checkbox: " + e.getMessage());
            throw e;
        }
    }

    @Then("click Send Code")
    public void click_SendCode() {
        try {
            loginUI.ClicksendCode();
            Report.logInfo("Clicked Send Code button");
        } catch (Exception e) {
            Report.logFail("Failed to click Send Code button: " + e.getMessage());
            throw e;
        }
    }

    @Then("enter otp")
    public void enter_otp() throws InterruptedException {
        try {
            loginUI.EnterOTP();
            Report.logInfo("Entered OTP successfully");
        } catch (Exception e) {
            Report.logFail("Failed to enter OTP: " + e.getMessage());
            throw e;
        }
    }

    @Then("click verify")
    public void click_verify() {
        try {
            loginUI.ClickVerifyButton();
            Report.logInfo("Clicked Verify button successfully");
        } catch (Exception e) {
            Report.logFail("Failed to click Verify button: " + e.getMessage());
            throw e;
        }
    }
}
