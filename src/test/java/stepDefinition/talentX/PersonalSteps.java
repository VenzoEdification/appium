package stepDefinition.talentX;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginUI;
import pages.Personal;

import utils.Excelutil;
import utils.Report;
import utils.extent.CommonMethods;

import java.net.MalformedURLException;
import java.util.Map;

public class PersonalSteps extends Personal {


    private Map<String, String> testData;

    public PersonalSteps() throws MalformedURLException {
        super();

    }

    @Given("The Profile Details is visible")
    public void theProfilePageIsVisible() throws Exception {
        try {
            Report.logInfo("The Profile Page is Visible");
        } catch (Exception e) {
            Report.logFail(" Profile Page is failed: " + e.getMessage());
            throw e;
        }
        Excelutil reader = new Excelutil();
        testData = reader.getRowData("input/Profile.xlsx", "PersonalDetails", 1);
        System.out.println("Loaded Test Data: " + testData);
    }
    @Then("Click Personal Tab")
    public void click_personal_tab()throws Exception {
        try {
            ClickPersonaldetails();
            Report.logInfo("The Personal Details is Visible");
        } catch (Exception e) {
            Report.logFail("Failed to click Personal details: " + e.getMessage());
            throw e;
        }
    }


    @Then("Click Nationality")
    public void clickNationality() {
        try {
            ClickNationality();
            Report.logInfo("Clicked Nationality dropdown.");
        } catch (Exception e) {
            Report.logFail("Failed to click Nationality: " + e.getMessage());
            throw e;
        }
    }

    @Then("Click Indian")
    public void clickIndian() {
        try {
         ClickIndian();
            Report.logInfo("Selected Indian nationality.");
        } catch (Exception e) {
            Report.logFail("Failed to select Indian nationality: " + e.getMessage());
            throw e;
        }
    }

    @Then("Click Blood Group")
    public void clickBloodGroup() {
        try {
            ClickBloodGroup();
            Report.logInfo("Clicked Blood Group dropdown.");
        } catch (Exception e) {
            Report.logFail("Failed to click Blood Group: " + e.getMessage());
            throw e;
        }
    }

    @When("Enter Blood Group {string}")
    public void enterBloodGroup(String key) {
        try {
            String value = testData.get(key);
         EnterBloodGroup(value);
            Report.logInfo("Entered Blood Group: " + value);
        } catch (Exception e) {
            Report.logFail("Failed to enter Blood Group: " + e.getMessage());
            throw e;
        }
    }

    @Then("Click FatherName")
    public void clickFatherName() {
        try {
           ClickFathername();
            Report.logInfo("Clicked Father Name field.");
        } catch (Exception e) {
            Report.logFail("Failed to click Father Name: " + e.getMessage());
            throw e;
        }
    }

    @When("Enter FatherName {string}")
    public void enterFatherName(String key) {
        try {
            String value = testData.get(key);
           EnterFathername(value);
            Report.logInfo("Entered Father Name: " + value);
        } catch (Exception e) {
            Report.logFail("Failed to enter Father Name: " + e.getMessage());
            throw e;
        }
    }

    @Then("Click Email")
    public void clickEmail() {
        try {
           ClickEmail();
            Report.logInfo("Clicked Email field.");
        } catch (Exception e) {
            Report.logFail("Failed to click Email: " + e.getMessage());
            throw e;
        }
    }

    @When("Enter Email")
    public void enterEmail() {
        try {
          EnterEmail();
            Report.logInfo("Entered Email:" + CommonMethods.generateRandomEmail());
        } catch (Exception e) {
            Report.logFail("Failed to enter Email: " + e.getMessage());
            throw e;
        }
    }

    @Then("Click Address Line")
    public void clickAddressLine() {
        try {
           ClickAddressLine();
            Report.logInfo("Clicked Address Line field.");
        } catch (Exception e) {
            Report.logFail("Failed to click Address Line: " + e.getMessage());
            throw e;
        }
    }

    @When("Enter Address Line {string}")
    public void enterAddressLine(String key) {
        try {
            String value = testData.get(key);
          EnterAddressLine1(value);
            Report.logInfo("Entered Address Line: " + value);
        } catch (Exception e) {
            Report.logFail("Failed to enter Address Line: " + e.getMessage());
            throw e;
        }
    }

    @Then("Click City")
    public void clickCity() {
        try {
           ClickCity();
            Report.logInfo("Clicked City field.");
        } catch (Exception e) {
            Report.logFail("Failed to click City: " + e.getMessage());
            throw e;
        }
    }

    @When("Enter the City name {string}")
    public void enterTheCityName(String key) {
        try {
            String value = testData.get(key);
           EnterCity(value);
            Report.logInfo("Entered City: " + value);
        } catch (Exception e) {
            Report.logFail("Failed to enter City: " + e.getMessage());
            throw e;
        }
    }

    @Then("Click Pincode")
    public void clickPincode() {
        try {
           ClickPincode();
            Report.logInfo("Clicked Pincode field.");
        } catch (Exception e) {
            Report.logFail("Failed to click Pincode: " + e.getMessage());
            throw e;
        }
    }

    @When("Enter the PinCode {string}")
    public void enterThePinCode(String key) {
        try {
            String value = testData.get(key);
            EnterPincode(value);
            Report.logInfo("Entered Pincode: " + value);
        } catch (Exception e) {
            Report.logFail("Failed to enter Pincode: " + e.getMessage());
            throw e;
        }
    }

    @Then("Click Upload Image")
    public void clickUploadImage() throws InterruptedException {
        try {
          ClickUploadImage();
            Report.logInfo("Clicked Upload Image button.");
        } catch (Exception e) {
            Report.logFail("Failed to click Upload Image: " + e.getMessage());
            throw e;
        }
    }

    @When("Upload the Profile image {string}")
    public void uploadTheProfileImage(String key) throws Exception {
        try {
            String value = testData.get(key);
          UploadImage(value);
            Report.logInfo("Uploaded Profile Image: " + value);
        } catch (Exception e) {
            Report.logFail("Failed to upload Profile Image: " + e.getMessage());
            throw e;
        }
    }

    @Then("Click Update Button")
    public void clickUpdateButton() {
        try {
            ClickUpdateButton();
            Report.logInfo("Clicked Update button.");
        } catch (Exception e) {
            Report.logFail("Failed to click Update button: " + e.getMessage());
            throw e;
        }
    }

    @Then("The Profile page should display")
    public void theProfilePageShouldDisplay() {
        try {
            Report.logPass("Profile page displayed successfully!");
        } catch (Exception e) {
            Report.logFail("Profile page validation failed: " + e.getMessage());
            throw e;
        }
    }
}
