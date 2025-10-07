package stepDefinition.talentX;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.GovernmentIDs;
import utils.Excelutil;
import utils.Report;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

public class GovernmentIdSteps extends GovernmentIDs {
    public GovernmentIdSteps() throws MalformedURLException {
    }
    private Map<String, String> testData;


    @Then("Click Government ID's")
    public void click_government_ids() throws IOException {
        try {
           ClickGovernmentIDs();
            Report.logInfo("Government ID's Tab  is Clicked");
        } catch (Exception e) {
            Report.logFail("Failed to click Government ID's: " + e.getMessage());
            throw e;
        }
        Excelutil reader = new Excelutil();
        testData = reader.getRowData("input/Profile.xlsx", "GovernmentID's", 1);
        System.out.println("Loaded Test Data: " + testData);

    }

    @Then("Click Aadhar Number")
    public void click_aadhar_number() {
        try {
           ClickAadharNumber();
            Report.logInfo("Aadhar Number  is Clicked");
        } catch (Exception e) {
            Report.logFail("Failed to Aadhar Number: " + e.getMessage());
            throw e;
        }

    }

    @When("Enter Aadhar Number {string}")
    public void enter_Aadhar_Number(String key) {
        try {

            String value = testData.get(key);
            Report.logInfo("Aadhar Number  :" + value);
            EnterAadharNumber(value);
        } catch (Exception e) {
            Report.logInfo("Failed to enter Aadhar Number " + e.getMessage());


        }
    }


    @Then("Click PAN Number")
    public void click_pan_number() {
        try {
           ClickPAN();
            Report.logInfo("PAN Number  is Clicked");
        } catch (Exception e) {
            Report.logFail("Failed to PAN: " + e.getMessage());
            throw e;
        }

    }

    @When("Enter PAN Number {string}")
    public void enter_pan_number(String key) {
        try {

            String value = testData.get(key);
            Report.logInfo("PAN Number  :" + value);
            EnterPANnumber(value);
        } catch (Exception e) {
            Report.logInfo("Failed to enter PAN Number " + e.getMessage());

        }
    }

    @Then("Click Upload Aadhar")
    public void click_upload_aadhar() {
        try {
        ClickUploadAadhar();
            Report.logInfo("Aadhar Upload is Clicked");
        } catch (Exception e) {
            Report.logFail("Failed to Aadhar Upload: " + e.getMessage());
            throw e;
        }

    }

    @Then("Click Upload Pan")
    public void click_upload_pan() throws InterruptedException {
        try {
        ClickUploadPAN();
            Report.logInfo("PAN Document is  Uploaded");
        } catch (Exception e) {
            Report.logFail("Failed to PAN Upload: " + e.getMessage());
            throw e;
        }

    }

    @Then("Click Aadhar Verify")
    public void clickAadharVerify() throws InterruptedException {
        try {
            ClickAadharVerify();
            Report.logInfo("Aadhar Verify  is Clicked");
        } catch (Exception e) {
            Report.logFail("Failed to Aadhar Verify: " + e.getMessage());
            throw e;
        }
    }

    @Then("Click PAN Verify")
    public void clickPANVerify() throws InterruptedException {
        try {
            ClickPanVerify();
            Report.logInfo("Pan Verify  is Clicked");
        } catch (Exception e) {
            Report.logFail("Failed to Pan Verify: " + e.getMessage());
            throw e;
        }
    }

    @When("Enter and Verify Aadhar Number {string}")
    public void enterAndVerifyAadharNumber(String key) {
        try {

            String value = testData.get(key);
            Report.logInfo("Aadhar Number  :" + value);
            AadharFlow(value);
        } catch (Exception e) {
            Report.logInfo("Failed to enter Aadhar Number " + e.getMessage());

        }
    }

    @When("Enter and Verify PAN Number {string}")
    public void enterAndVerifyPANNumber(String key) {
        try {

            String value = testData.get(key);
            Report.logInfo("PAN Number  :" + value);
           PANFlow(value);
        } catch (Exception e) {
            Report.logInfo("Failed to enter PAN Number " + e.getMessage());

        }
    }

    @Then("Upload Aadhar")
    public void uploadAadhar() throws InterruptedException {
        try {
           UploadAadhar();
            Report.logInfo(" Aadhar Document is Uploaded");
        } catch (Exception e) {
            Report.logFail("Failed to Aadhar Upload: " + e.getMessage());
            throw e;
        }


    }

    @Then("Upload Pan")
    public void uploadPan() throws InterruptedException {
        try {
            UploadPAN();
            Report.logInfo("PAN Document is Uploaded");
        } catch (Exception e) {
            Report.logFail("Failed to PAN Upload: " + e.getMessage());
            throw e;
        }
    }
}
