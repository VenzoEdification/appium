package stepDefinition.talentX;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginUI;
import utils.Excelutil;

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
        Excelutil reader = new Excelutil();
        // 🔹 Load row 1 (you can make it dynamic in runner for multiple rows)
        testData = reader.getRowData("input/Login.xlsx", "Login", 1);
        System.out.println("Loaded Test Data: " + testData);
    }


    @Then("click allow button")
    public LoginSteps click_allow_button() throws InterruptedException {
        ClickAllownotification();
        return this;
    }

    @When("enter the value {string}")
    public LoginSteps enter_the_value_(String phoneNumber) {
        String value = testData.get(phoneNumber);
        EnterMobileNumber(value);
        return this;
    }

    @When("click Terms and Agreement")
    public LoginSteps click_Terms_and_Agreement() {

        ClickTermsCheckBox();
        return this;
    }
    @Then("click Send Code")
    public LoginSteps click_SendCode() {
        ClicksendCode();
        return this;
    }

    @Then("enter otp")
    public LoginSteps enter_otp() throws InterruptedException {
        EnterOTP();
        return this;

    }

    @Then("click verify")
    public LoginSteps click_verify() {
        ClickVerifyButton();
        return this;
    }
}

