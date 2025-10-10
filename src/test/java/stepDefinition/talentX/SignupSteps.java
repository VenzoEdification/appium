package stepDefinition.talentX;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Signup;
import utils.Excelutil;
import utils.Report;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

public class SignupSteps extends Signup {
    private Map<String, String> testData;

    public SignupSteps() throws MalformedURLException {
    }

    @Given("The Talntx Application is launched")
    public void the_talntx_application_is_launched() throws IOException {
        try {
            Report.logInfo("TALNTx app launched successfully");
        } catch (Exception e) {
            Report.logFail("App launch log failed: " + e.getMessage());
            throw e;
        }
        Excelutil reader = new Excelutil();
        testData = reader.getRowData("input/Signup.xlsx", "signup", 1);
        System.out.println("Loaded Test Data: " + testData);


    }

    @Then("Click Signupbutton")
    public void click_signupbutton() {
        try {
            ClickSignupLink();
            Report.logInfo("Signup is Clicked");
        } catch (Exception e) {
            Report.logFail("Failed to click Signup:" + e.getMessage());
        }


    }

    @When("Enter Name {string}")
    public void enter_name(String key) {
        try {
            String value = testData.get(key);
            EnterName(value);
            Report.logInfo("Entered Name as: " + value);
        } catch (Exception e) {
            Report.logFail("Failed to enter Name: " + e.getMessage());
            throw e;
        }

    }

    @Then("CLick Send Code")
    public void c_lick_send_code() {
        try {
            ClickSendCodeButton();
            Report.logInfo("Send Code Button is CLicked");
        }catch (Exception e)
        {
            Report.logFail("Failed to CLick Send code" +e.getMessage());
        }

    }


    @Then("Enter Mobile Number {string}")
    public void enterMobileNumber(String key) {
        try {
            String value = testData.get(key);
            EnterMobileNumber(value);
            Report.logInfo("Mobile Number:" + value);
        }catch (Exception e){
            Report.logFail("Failed to Enter Mobile Number:"+e.getMessage());
        }

    }


    @Then("Enter Date of Birth {string}")
    public void enterDateOfBirth(String key) throws InterruptedException {
        try{
            String value = testData.get(key);
            ClickcalenderIcon();
            Report.logInfo("Calendar Icon is Clicked");
            SelectDate(value);
            Report.logInfo("Entered Date of Birth:" +value);
            ClickcalenderOk();
            Report.logInfo("Ok Button is clicked");
        }catch (Exception e){
            Report.logFail("Failed to Select Date of Birth:" +e.getMessage());
            throw e;
        }
    }

    @Then("Click Name")
    public void clickName() {
        try {
            ClickName();
            Report.logInfo("Name is Clicked");
        }catch (Exception e){
            Report.logFail("Failed to click Name:" +e.getMessage());
        }
    }

    @Then("Select Gender")
    public void selectGender() {
        try {

            ChooseGender();
            Report.logInfo("Gender is Selected");
        }catch (Exception e){
            Report.logFail("Failed to Select Gender:" +e.getMessage());
        }
    }

    @Then("Click Terms and Agreement")
    public void clickTermsAndAgreement() {
        try {

          ClickAgreeCheckBOx();
            Report.logInfo("Terms and Condition Check Box is Selected");
        }catch (Exception e){
            Report.logFail("Failed to Terms and Condition:" +e.getMessage());
        }
    }
}
