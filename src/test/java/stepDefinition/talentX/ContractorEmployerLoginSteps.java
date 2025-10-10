package stepDefinition.talentX;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.CELogin;
import utils.Excelutil;
import utils.Report;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

public class ContractorEmployerLoginSteps extends CELogin {
    private Map<String, String> testData;
    public ContractorEmployerLoginSteps() throws MalformedURLException {
    }
    @Then("Enter Mobile number {string}")
    public void enter_mobile_number(String key) throws IOException {
        try {


            String value = testData.get(key);
            Report.logInfo("Entered Mobile Number :" + value);
            EnterMobileNumber(value);
        } catch (Exception e) {
            Report.logInfo("Failed to enter mobile number: + e.getMessage()");
            throw e;
        }

    }


    @Given("Talntx Application is launched")
    public void talntxApplicationIsLaunched() throws IOException {
        try {
            Report.logInfo("TALNTx app launched successfully");
        } catch (Exception e) {
            Report.logFail("App launch log failed: " + e.getMessage());
            throw e;
        }
        Excelutil reader = new Excelutil();
        testData = reader.getRowData("input/Login.xlsx", "CELogin", 1);
        System.out.println("Loaded Test Data: " + testData);

    }

    @Then("Enter otp")
    public void enterOtp() throws InterruptedException {
        try {
            EnterOTP();
            Report.logInfo("The Otp has been Entered Successfully ");
        } catch (Exception e) {
            Report.logFail("Failed to enter OTP: " + e.getMessage());
            throw e;
        }
    }
    @Then("Click verify")
    public void click_verify() throws InterruptedException {
        try {
            ClickVerifyButton();
            Report.logInfo("Verify Button is CLicked");
        } catch (Exception e) {
            Report.logFail("failed to Click Verify Button: " + e.getMessage());
            throw e;
        }

    }
}
