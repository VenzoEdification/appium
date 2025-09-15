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
import java.util.List;

public class PersonalSteps extends Personal {
    private String generatedEmail;

    public PersonalSteps() throws MalformedURLException {
        super();
    }

    @Given("The Personal page is visible")
    public void thePersonalPagIsVisible() {
    }

    @Then("Click Nationality")
    public void clickNationality() {
        ClickNationality();
    }

    @Then("CLick Indian")
    public void clickIndian() {
        ClickIndian();
    }

    @When("Enter Blood Group {string}")
    public void enterBloodGroup(String BloodGroup) throws InvalidFormatException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
        Excelutil reader = new Excelutil();
        List<String> columnData = reader.getColumnData("input/PersonalDetails.xlsx", "PersonalDetails",BloodGroup);

        for (String value : columnData) {
            System.out.println("Value New Method: " + value);
            // Example action for each value
            EnterBloodGroup(value);
        }
    }

    @When("Enter FatherName {string}")
    public void enterFatherName(String Fathername)throws InvalidFormatException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
        Excelutil reader = new Excelutil();
        List<String> columnData = reader.getColumnData("input/PersonalDetails.xlsx", "PersonalDetails",Fathername);

        for (String value : columnData) {
            System.out.println("Value New Method: " + value);
            // Example action for each value
            EnterFathername(value);
        }
    }

    @Then("CLick Email")
    public void clickEmail() {
        ClickEmail();
    }

    @When("Enter Email")
    public void enterEmail() {
        generatedEmail = CommonMethods.generateRandomEmail();
        // Enter the generatedEmail into the email field on the page
        System.out.println("Generated Email: " + generatedEmail);
    }

    @When("Enter Address Line {string}")
    public void enterAddressLine(String Address) throws InvalidFormatException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
        Excelutil reader = new Excelutil();
        List<String> columnData = reader.getColumnData("input/PersonalDetails.xlsx", "PersonalDetails",Address);

        for (String value : columnData) {
            System.out.println("Value New Method: " + value);
            // Example action for each value
            EnterAddressLine1(value);
        }
    }

    @Then("Click City")
    public void clickCity() {
        ClickCity();
    }

    @When("Enter the City name {string}")
    public void enterTheCityName(String City) throws InvalidFormatException, IOException,org.apache.poi.openxml4j.exceptions.InvalidFormatException {
        Excelutil reader = new Excelutil();
        List<String> columnData = reader.getColumnData("input/PersonalDetails.xlsx", "PersonalDetails",City);

        for (String value : columnData) {
            System.out.println("Value New Method: " + value);
            // Example action for each value
            EnterCity(value);
        }
    }

    @When("Enter the PinCode {string}")
    public void enterThePinCode(String Pincode)throws IOException,org.apache.poi.openxml4j.exceptions.InvalidFormatException {
        Excelutil reader = new Excelutil();
        List<String> columnData = reader.getColumnData("input/PersonalDetails.xlsx", "PersonalDetails",Pincode);

        for (String value : columnData) {
            System.out.println("Value New Method: " + value);
            // Example action for each value
            EnterPincode(value);
        }

    }



    @When("Upload the Profile image {string}")
    public void uploadTheProfileImage(String userName) throws IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
        Excelutil reader = new Excelutil();
        String imagePath = reader.getImagePathFromExcel("input/PersonalDetails.xlsx", "PersonalDetails", "Image");
        UploadImage(imagePath);
    }

    @Then("Click Update Button")
    public void clickUpdateButton() {
        ClickUpdateButton();
    }

    @Then("The Profile page should display")
    public void theProfilePageShouldDisplay() {
    }

    @Then("Click Blood Group")
    public void clickBloodGroup() {
        ClickBloodGroup();
    }

    @Then("Click FatherName")
    public void clickFatherName() {
        ClickFathername();
    }

    @Then("Click Address Line")
    public void clickAddressLine() {
        ClickAddressLine();

    }

    @Then("Click Pincode")
    public void clickPincode() {
        ClickPincode();
    }

    @Then("Click Upload Image")
    public void clickUploadImage() throws InterruptedException {
        ClickUploadImage();
    }
}