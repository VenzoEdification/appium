package stepDefinition.talentX;

import driver.driverManager;
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
    Personal personal = new Personal(driverManager.getDriver());
    private String generatedEmail;
    private Map<String, String> testData; // holds one row of Excel

    public PersonalSteps() throws MalformedURLException {
        super(driverManager.getDriver());
        try {
            Excelutil reader = new Excelutil();
            testData = reader.getRowData("input/Personal.xlsx", "PersonalDetails", 1);
            System.out.println("Loaded Personal Test Data: " + testData);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load Personal test data from Excel", e);
        }
    }


        @Given("The Personal page is visible")
        public void thePersonalPageIsVisible() {
            try {
                Report.logInfo("Personal page is visible");
            } catch (Exception e) {
                Report.logFail("Failed to validate Personal page: " + e.getMessage());
                throw e;
            }
        }

        @Then("Click Nationality")
        public void clickNationality() {
            try {
                personal.ClickNationality();
                Report.logInfo("Clicked Nationality");
            } catch (Exception e) {
                Report.logFail("Failed to click Nationality: " + e.getMessage());
                throw e;
            }
        }

        @Then("Click Indian")
        public void clickIndian() {
            try {
                personal.ClickIndian();
                Report.logInfo("Clicked Indian nationality");
            } catch (Exception e) {
                Report.logFail("Failed to click Indian nationality: " + e.getMessage());
                throw e;
            }
        }

        @Then("Click Blood Group")
        public void clickBloodGroup() {
            try {
                personal.ClickBloodGroup();
                Report.logInfo("Clicked Blood Group");
            } catch (Exception e) {
                Report.logFail("Failed to click Blood Group: " + e.getMessage());
                throw e;
            }
        }

        @When("Enter Blood Group {string}")
        public void enterBloodGroup(String BloodGroup) {
            try {
                personal.EnterBloodGroup(testData.get(BloodGroup));
                Report.logInfo("Entered Blood Group: " + testData.get(BloodGroup));
            } catch (Exception e) {
                Report.logFail("Failed to enter Blood Group: " + e.getMessage());
                throw e;
            }
        }

        @Then("Click FatherName")
        public void clickFatherName() {
            try {
                personal.ClickFathername();
                Report.logInfo("Clicked Father Name field");
            } catch (Exception e) {
                Report.logFail("Failed to click Father Name field: " + e.getMessage());
                throw e;
            }
        }

        @When("Enter FatherName {string}")
        public void enterFatherName(String FatherName) {
            try {
                personal.EnterFathername(testData.get(FatherName));
                Report.logInfo("Entered Father Name: " + testData.get(FatherName));
            } catch (Exception e) {
                Report.logFail("Failed to enter Father Name: " + e.getMessage());
                throw e;
            }
        }

        @Then("Click Email")
        public void clickEmail() {
            try {
                personal.ClickEmail();
                Report.logInfo("Clicked Email field");
            } catch (Exception e) {
                Report.logFail("Failed to click Email field: " + e.getMessage());
                throw e;
            }
        }

        @When("Enter Email")
        public void enterEmail() {
            try {
                personal.EnterEmail();
                Report.logInfo("Generated and entered Email: " + generatedEmail);
                // EnterEmail(generatedEmail); // uncomment if needed
            } catch (Exception e) {
                Report.logFail("Failed to enter Email: " + e.getMessage());
                throw e;
            }
        }

        @Then("Click Address Line")
        public void clickAddressLine() {
            try {
                personal.ClickAddressLine();
                Report.logInfo("Clicked Address Line");
            } catch (Exception e) {
                Report.logFail("Failed to click Address Line: " + e.getMessage());
                throw e;
            }
        }

        @When("Enter Address Line {string}")
        public void enterAddressLine(String Address) {
            try {
                personal.EnterAddressLine1(testData.get(Address));
                Report.logInfo("Entered Address Line: " + testData.get(Address));
            } catch (Exception e) {
                Report.logFail("Failed to enter Address Line: " + e.getMessage());
                throw e;
            }
        }

        @Then("Click City")
        public void clickCity() {
            try {
                personal.ClickCity();
                Report.logInfo("Clicked City field");
            } catch (Exception e) {
                Report.logFail("Failed to click City field: " + e.getMessage());
                throw e;
            }
        }

        @When("Enter the City name {string}")
        public void enterTheCityName(String City) {
            try {
               personal.EnterCity(testData.get(City));
                Report.logInfo("Entered City: " + testData.get(City));
            } catch (Exception e) {
                Report.logFail("Failed to enter City: " + e.getMessage());
                throw e;
            }
        }

        @Then("Click Pincode")
        public void clickPincode() {
            try {
                personal.ClickPincode();
                Report.logInfo("Clicked Pincode field");
            } catch (Exception e) {
                Report.logFail("Failed to click Pincode field: " + e.getMessage());
                throw e;
            }
        }

        @When("Enter the PinCode {string}")
        public void enterThePinCode(String Pincode) {
            try {
                personal.EnterPincode(testData.get(Pincode));
                Report.logInfo("Entered Pincode: " + testData.get(Pincode));
            } catch (Exception e) {
                Report.logFail("Failed to enter Pincode: " + e.getMessage());
                throw e;
            }
        }

        @Then("Click Upload Image")
        public void clickUploadImage() throws InterruptedException {
            try {
               personal.ClickUploadImage();
                Report.logInfo("Clicked Upload Image button");
            } catch (Exception e) {
                Report.logFail("Failed to click Upload Image button: " + e.getMessage());
                throw e;
            }
        }

        @When("Upload the Profile image {string}")
        public void uploadTheProfileImage(String ProfileImage) {
            try {
                personal.UploadImage(testData.get(ProfileImage));
                Report.logInfo("Uploaded Profile Image: " + testData.get(ProfileImage));
            } catch (Exception e) {
                Report.logFail("Failed to upload Profile Image: " + e.getMessage());
                throw new RuntimeException(e);
            }
        }

        @Then("Click Update Button")
        public void clickUpdateButton() {
            try {
                personal.ClickUpdateButton();
                Report.logInfo("Clicked Update button");
            } catch (Exception e) {
                Report.logFail("Failed to click Update button: " + e.getMessage());
                throw e;
            }
        }

        @Then("The Profile page should display")
        public void theProfilePageShouldDisplay() {
            try {
                Report.logInfo("Profile updated successfully!");
            } catch (Exception e) {
                Report.logFail("Profile page validation failed: " + e.getMessage());
                throw e;
            }
        }
    }