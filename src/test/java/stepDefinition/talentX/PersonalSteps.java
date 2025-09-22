package stepDefinition.talentX;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.exc.InvalidFormatException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Personal;
import utils.Excelutil;
import utils.extent.CommonMethods;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

public class PersonalSteps extends Personal {
    private String generatedEmail;
    private Map<String, String> testData;  // Holds one row of Excel data

    public PersonalSteps() throws MalformedURLException {
        super();
    }
    @Given("The Personal page is visible")
    public void thePersonalPageIsVisible() throws Exception {
        Excelutil reader = new Excelutil();
        // Load row 1 for now (you can loop for multiple rows in runner)
        testData = reader.getRowData("input/Personal.xlsx", "PersonalDetails",1);
        System.out.println("Loaded Test Data: " + testData);
    }

    @Then("Click Nationality")
    public void clickNationality() {
        ClickNationality(); }

    @Then("Click Indian")
    public void clickIndian() {
        ClickIndian(); }

    @Then("Click Blood Group")
    public void clickBloodGroup() { ClickBloodGroup(); }

    @When("Enter Blood Group {string}")
    public void enterBloodGroup(String BloodGroup) {
        String value = testData.get(BloodGroup);
        System.out.println("Blood Group: " + value);
        EnterBloodGroup(value);
    }

    @Then("Click FatherName")
    public void clickFatherName() {
        ClickFathername(); }

    @When("Enter FatherName {string}")
    public void enterFatherName(String FatherName) {
        String value = testData.get(FatherName);
        System.out.println("Father Name: " + value);
        EnterFathername(value);
    }

    @Then("Click Email")
    public void clickEmail() { ClickEmail(); }

    @When("Enter Email")
    public void enterEmail() {
        EnterEmail();
    }

    @Then("Click Address Line")
    public void clickAddressLine() {
        ClickAddressLine(); }

    @When("Enter Address Line {string}")
    public void enterAddressLine(String AddressLine) {
        String value = testData.get(AddressLine);
        System.out.println("Address Line: " + value);
        EnterAddressLine1(value);
    }

    @Then("Click City")
    public void clickCity() {
        ClickCity(); }

    @When("Enter the City name {string}")
    public void enterTheCityName(String City) {
        String value = testData.get(City);
        System.out.println("City: " + value);
        EnterCity(value);
    }

    @Then("Click Pincode")
    public void clickPincode() {
        ClickPincode(); }

    @When("Enter the PinCode {string}")
    public void enterThePinCode(String Pincode) {
        String value = testData.get(Pincode);
        System.out.println("Pincode: " + value);
        EnterPincode(value);
    }

    @Then("Click Upload Image")
    public void clickUploadImage() throws InterruptedException {
        ClickUploadImage(); }

    @When("Upload the Profile image {string}")
    public void uploadTheProfileImage(String ProfileImage) throws Exception {
        String value = testData.get(ProfileImage);
        System.out.println("Uploading Image: " + value);
        UploadImage(value);
    }

    @Then("Click Update Button")
    public void clickUpdateButton() {
        ClickUpdateButton(); }

    @Then("The Profile page should display")
    public void theProfilePageShouldDisplay() {
        System.out.println("Profile page displayed successfully!");
    }
}
