package stepDefinition.talentX;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.CEWithoutAadhar;
import utils.Excelutil;
import utils.Report;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

public class CEWithoutAadharSteps extends CEWithoutAadhar {
    private Map<String, String> testData;


    public CEWithoutAadharSteps() throws MalformedURLException {

    }
    @Given("HomePage is Visible")
    public void home_page_is_visible() throws IOException {
        try {

            Report.logInfo("Contractor Profile Page is Launched ");
        } catch (Exception e) {
            Report.logInfo("Failed to launch Profile page:" + e.getMessage());
            throw e;
        }
        Excelutil reader = new Excelutil();
        testData = reader.getRowData("input/Contractor.xlsx", "CEWithoutAadhar", 1);
        System.out.println("Loaded Test Data: " + testData);
    }



    @Then("Enter mobileNumber")
    public void enter_mobile_number() throws IOException, InterruptedException {

            EnterMobileNumber();


    }


    @Then("Enter aadharNumber")
    public void enter_aadhar_number() throws InterruptedException {
            EnterAadharNumber();

        }
    @Then("Enter TalentName {string}")
    public void enter_talent_name(String key) throws InterruptedException {
        try{
            String value = testData.get(key);

            Report.logInfo("Entered Name :" +value );
            EnterName(value);

        } catch (Exception e) {
            Report.logInfo("Failed to enter name :" + e.getMessage());
            throw e;
        }


    }
    @Then("Enter DateofBirth {string}")
    public void enter_dateof_birth(String key) throws InterruptedException {
        try{
            String value = testData.get(key);
            Report.logInfo("Calendar Icon is Clicked");
            enterDOB(value);
            Report.logInfo("Entered Date of Birth:" +value);
            ClickcalenderOk();
            Report.logInfo("Ok Button is clicked");
        }catch (Exception e){
            Report.logFail("Failed to Select Date of Birth:" +e.getMessage());
            throw e;
        }

    }


    @Then("Click Without AadharNumber")
    public void click_without_aadhar_number() throws InterruptedException {
        try{
         clickWithoutAadhar();
            Report.logInfo("Without Aadhar number is Clicked " );

        } catch (Exception e) {
            Report.logInfo("Failed to click without aadhar number:"+ e.getMessage());
            throw e;
        }

    }

    @Then("Validate talent Added")
    public void validateTalentAdded() {

            ValidateTalent();


    }

    @Then("Select gender")
    public void selectGender() {
        try{
            Selectgender();
            Report.logInfo("Gender is Selected");

        } catch (Exception e) {
            Report.logInfo("Failed to select gender:"+ e.getMessage());
            throw e;
        }

    }

    @Then("Click WithoutConfirm Button")
    public void clickWithoutConfirmButton() throws InterruptedException {
        try {
            ClickConfirmButton();
            Report.logInfo("Confirm Button is Clicked");
        } catch (Exception e) {
            Report.logFail("Failed to Click confirm: " + e.getMessage());
            throw e;
        }

    }
}
