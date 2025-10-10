package stepDefinition.talentX;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.CEWithAadhar;
import utils.Excelutil;
import utils.Report;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

public class CEWithAadharSteps extends CEWithAadhar {
    private Map<String, String> testData;

    public CEWithAadharSteps() throws MalformedURLException {
    }

    @Given("Home Page is Visible")
    public void home_page_is_visible() throws IOException {
        try {
            Report.logInfo("Home Page is Visible");
        } catch (Exception e) {
            Report.logFail("App launch log failed: " + e.getMessage());
            throw e;
        }
        Excelutil reader = new Excelutil();
        testData = reader.getRowData("input/Contractor.xlsx", "CEWithAadhar", 1);
        System.out.println("Loaded Test Data: " + testData);


    }
    @Then("Click Add Talent Icon")
    public void click_add_talent_icon() {
        try {
            ClickAddTalentButton();
            Report.logInfo("Add Talent Icon is Clicked");
        } catch (Exception e) {
            Report.logFail("Failed to Click add talent: " + e.getMessage());
            throw e;
        }

    }
    @Then("Enter MobileNumber {string}")
    public void enter_mobile_number(String key) throws InterruptedException {
        try{
        String value = testData.get(key);
        Report.logInfo("Entered Mobile Number :" + value);
        EnterMobileNumber(value);
    } catch (Exception e) {
            Report.logInfo("Failed to enter mobile number: + e.getMessage()");
            throw e;
        }


    }
    @Then("Enter AadharNumber {string}")
    public void enter_aadhar_number(String key) throws InterruptedException {
        try{
            String value = testData.get(key);
            Report.logInfo("Entered Aadhar Number :" + value);
            EnterAadharNumber(value);
        } catch (Exception e) {
            Report.logInfo("Failed to enter aadhar number: + e.getMessage()");
            throw e;
        }




    }
    @Then("Click Verify Button")
    public void click_verify_button() {
        try {

            Report.logInfo("Add Talent Icon is Clicked");
        } catch (Exception e) {
            Report.logFail("Failed to Click add talent: " + e.getMessage());
            throw e;
        }

    }
    @Then("Click Confirm Button")
    public void click_confirm_button() throws InterruptedException {
        try {
           ClickConfirmButton();
            Report.logInfo("Confirm Button is Clicked");
        } catch (Exception e) {
            Report.logFail("Failed to Click confirm: " + e.getMessage());
            throw e;
        }

    }
    @Then("CLick With Aadhar Button")
    public void c_lick_with_aadhar_button() {
        try {
            ClickWithAadhar();
            Report.logInfo("With Aadhar Button is Clicked");
        } catch (Exception e) {
            Report.logFail("Failed to Click with aadhar: " + e.getMessage());
            throw e;
        }

    }

    }


