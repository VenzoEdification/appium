package stepDefinition.talentX;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginUI;
import utils.Excelutil;
import utils.Report;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

public class LoginSteps extends LoginUI {


    private Map<String, String> testData;

    public LoginSteps() throws MalformedURLException {
        super();

    }

    @Given("the TALENTx app is launched")
    public void the_TALENTx_app_is_launched() throws IOException {
        try {
            Report.logInfo("TALENTx app launched successfully.");
        } catch (Exception e) {
            Report.logFail("App launch log failed: " + e.getMessage());
            throw e;
        }
        Excelutil reader = new Excelutil();
        testData = reader.getRowData("input/Login.xlsx", "Login", 1);
        System.out.println("Loaded Test Data: " + testData);
    }


 /*   @Then("click allow button")
    public LoginSteps click_allow_button() throws InterruptedException {
        try {
            ClickAllownotification();
            Report.logInfo("Clicked Allow button.");
        } catch (Exception e) {
            Report.logFail("Failed to click Allow button: " + e.getMessage());
            throw e;
        }

        return this;
    }*/

    @When("enter the value {string}")
    public void enter_the_value_(String phoneNumber) {
        try {

            String value = testData.get(phoneNumber);
            Report.logInfo("Entered Mobile Number :" + value);
            EnterMobileNumber(value);
        } catch (Exception e) {
            Report.logInfo("Failed to enter mobile number: + e.getMessage()");
            throw e;
        }

    }


    @When("click Terms and Agreement")
    public void click_Terms_and_Agreement() {
        try {
            ClickTermsCheckBox();
            Report.logInfo("Clicked Terms and Agreement checkbox.");
        } catch (Exception e) {
            Report.logFail("Failed to click Terms and Agreement: " + e.getMessage());
            throw e;
        }
    }

    @Then("click Send Code")
    public void click_SendCode() {

        try {
            ClicksendCode();
            Report.logInfo("Clicked Send Code button.");
        } catch (Exception e) {
            Report.logFail("Failed to click Send Code: " + e.getMessage());
            throw e;
        }

    }

    @Then("enter otp")
    public void enter_otp() throws InterruptedException {
        try {
            EnterOTP();
            Report.logInfo("Entered OTP: ");
        } catch (Exception e) {
            Report.logFail("Failed to enter OTP: " + e.getMessage());
            throw e;
        }

    }

    @Then("click verify")
    public void click_verify() throws InterruptedException {
        try {
            ClickVerifyButton();

            Report.logInfo("Clicked Verify button.");
        } catch (Exception e) {
            Report.logFail("Failed to click Verify button: " + e.getMessage());
            throw e;
        }
    }
    @Then("Click myaccount")
    public void click_my_account() throws InterruptedException {
        try {
            ClickMyAccount();

            Report.logInfo("Clicked My Account.");
        } catch (Exception e) {
            Report.logFail("Failed to click Verify button: " + e.getMessage());
            throw e;
        }


    }



}


