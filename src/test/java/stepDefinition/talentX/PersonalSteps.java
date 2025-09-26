package stepDefinition.talentX;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
    public void click_personal_tab() throws Exception {
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
            Report.logInfo("Nationality is Clicked");
        } catch (Exception e) {
            Report.logFail("Failed to click Nationality: " + e.getMessage());
            throw e;
        }
    }

    @Then("Click Indian")
    public void clickIndian() {
        try {
            ClickIndian();
            Report.logInfo("Nationality is Selected");
        } catch (Exception e) {
            Report.logFail("Failed to select Indian nationality: " + e.getMessage());
            throw e;
        }
    }

    @Then("Click Blood Group")
    public void clickBloodGroup() {
        try {
            ClickBloodGroup();
            Report.logInfo("Blood Group is Clicked");
        } catch (Exception e) {
            Report.logFail("Failed to click Blood Group: " + e.getMessage());
            throw e;
        }
    }

    @Then("Click Blood Group Type")
    public Personal clickBloodGroupType()  {
        try {
            ClickBloodGroupType();
            Report.logInfo("Blood Group Type is Selected");
        } catch (Exception e) {
            Report.logFail("Failed to enter Blood Group: " + e.getMessage());
            throw e;
        }
        return this;
    }

    @Then("Click FatherName")
    public void clickFatherName() {
        try {
            ClickFathername();
            Report.logInfo("Father Name field is Clicked");
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
            Report.logInfo("Email is Clicked");
        } catch (Exception e) {
            Report.logFail("Failed to click Email: " + e.getMessage());
            throw e;
        }
    }

    @When("Enter Email")
    public void enterEmail() {
        try {
            EnterEmail();
            Report.logInfo("Entered Email as: "+ CommonMethods.generateRandomEmail());
        } catch (Exception e) {
            Report.logFail("Failed to enter Email: " + e.getMessage());
            throw e;
        }
    }

    @Then("Click Address Line")
    public void clickAddressLine() {
        try {
            ClickAddressLine();
            Report.logInfo("Address Line is Clicked");
        } catch (Exception e) {
            Report.logFail("Failed to click Address Line: " + e.getMessage());
            throw e;
        }
    }

    @When("Enter Address Line {string}")
    public void enterAddressLine(String key) throws InterruptedException {
        try {
            String value = testData.get(key);
            EnterAddressLine1(value);
            Report.logInfo("Entered Address Line as: " + value);
        } catch (Exception e) {
            Report.logFail("Failed to enter Address Line: " + e.getMessage());
            throw e;
        }
    }

    @Then("Click City")
    public void clickCity() throws InterruptedException {
        try {
            ClickCity();
            Report.logInfo("City is Clicked");
        } catch (Exception e) {
            Report.logFail("Failed to click City: " + e.getMessage());
            throw e;
        }
    }

    @When("Enter the City name {string}")
    public void enterTheCityName(String key) throws InterruptedException {

        try {
            String value = testData.get(key);
            EnterCity(value);
            Report.logInfo("Entered City as: " + value);
        } catch (Exception e) {
            Report.logFail("Failed to enter City: " + e.getMessage());
            throw e;
        }
    }

    @Then("Click Pincode")
    public void clickPincode() {
        try {
            ClickPincode();
            Report.logInfo("Pincode is Clicked");
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
            Report.logInfo("Entered Pincode as: " + value);
        } catch (Exception e) {
            Report.logFail("Failed to enter Pincode: " + e.getMessage());
            throw e;
        }
    }

    @Then("Click Upload Image")
    public void clickUploadImage() throws InterruptedException {
        try {
            UploadImage();
            Report.logInfo("Upload Profile Image is Clicked");
        } catch (Exception e) {
            Report.logFail("Failed to click Upload Image: " + e.getMessage());
            throw e;
        }
    }


    @Then("Click Update Button")
    public void clickUpdateButton() {
        try {
            ClickUpdateButton();
            Report.logInfo("Update Button is Clicked");
        } catch (Exception e) {
            Report.logFail("Failed to click Update button: " + e.getMessage());
            throw e;
        }
    }

    @Then("The Profile page should display")
    public void theProfilePageShouldDisplay() {
        try {
            Report.logInfo("Profile page displayed successfully");
        } catch (Exception e) {
            Report.logFail("Profile page validation failed: " + e.getMessage());
            throw e;
        }
    }


    @Then("Click Camera")
    public void clickCamera() throws InterruptedException {
        try {
            ClickCamera();
            Report.logInfo("CameraOption is Clicked");
        } catch (Exception e) {
            Report.logFail("Failed to click Camera: " + e.getMessage());
            throw e;
        }

    }

    @Then("Click Camera Button")
    public void clickCameraButton() throws InterruptedException {
        try {
            ClickTakePicture();
            Report.logInfo("CameraButton is Clicked");
        } catch (Exception e) {
            Report.logFail("Failed to click Camera: " + e.getMessage());
            throw e;
        }
    }

    @Then("Click Ok Button")
    public void clickOkButton() throws InterruptedException {
        try {
            ClickCameraOkButton();
            Report.logInfo("Ok Button is Clicked");
        } catch (Exception e) {
            Report.logFail("Failed to click Ok Button: " + e.getMessage());
            throw e;
        }
    }

    @Then("Click Crop Button")
    public void clickCropButton() throws InterruptedException {
        try {
            ClickEditCrop();
            Report.logInfo("Ok Button is Clicked");
        } catch (Exception e) {
            Report.logFail("Failed to click Ok Button: " + e.getMessage());
            throw e;
        }
    }

    @Then("Click Date of Birth")
    public void clickDateOfBirth() throws InterruptedException {
        try {

            CLickDateofBirth();
            Report.logInfo("Entered DOB successfully");
        } catch (Exception e) {
            Report.logFail("Failed to enter DOB: " + e.getMessage());
            throw e;
        }
    }

    @Then("Click Search City")
    public void clickSearchCity() throws InterruptedException {
        try {

            SearchCity();
            Report.logInfo("Entered City Name");
        } catch (Exception e) {
            Report.logFail("Failed to click search city: " + e.getMessage());
            throw e;
        }
    }

    @Then("Click Select City")
    public void clickSelectCity() throws InterruptedException {
        try {

            ClickCityName();
            Report.logInfo("Entered City Name");
        } catch (Exception e) {
            Report.logFail("Failed to click city name: " + e.getMessage());
            throw e;
        }
    }
}


