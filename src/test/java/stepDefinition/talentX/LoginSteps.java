package stepDefinition.talentX;

import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.exc.InvalidFormatException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginUI;
import utils.ExcelUtilUpdated;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

public class LoginSteps extends LoginUI {

//    private ActionClass actionClass;
    private ExtentTest test;

    AndroidDriver driver;
    private LoginUI loginUI;

    public LoginSteps() throws MalformedURLException {
        super();
    }

    @Given("the TALENTx app is launched")
    public void the_TALENTx_app_is_launched() {
        CheckLogo();

    }

    @When("enter the value {string}")
    public void enter_the_value_(String phoneNumber) throws InvalidFormatException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
        ExcelUtilUpdated reader = new ExcelUtilUpdated();
        List<String> columnData = reader.getColumnData("input/TalentX.xlsx", "TalentX", phoneNumber);

        for (String value : columnData) {
            System.out.println("Value New Method: " + value);
            // Example action for each value
            EnterMobileNumber(value);
        }
    }

    @When("click Terms and Agreement")
    public void click_Terms_and_Agreement() {
//            System.out.println("check:");
        ClickTermsCheckBox();
    }

    @Then("click Send Code")
    public void click_SendCode() {
        ClicksendCode();

    }


    @Then("enter otp")
    public void enter_otp() throws InterruptedException {
        EnterOTP();

    }
    @Then("click verify")
    public void click_verify() {
        ClickVerifyButton();


    }


//    @When("click Captcha Box")
//    public void Click_Captcha_Box() {
//
//        ClickCaptchaBox();
//
//    }



}







