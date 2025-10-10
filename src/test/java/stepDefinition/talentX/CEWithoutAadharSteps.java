package stepDefinition.talentX;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.CEWithoutAadhar;
import utils.Excelutil;
import utils.Report;
import utils.extent.CommonMethods;

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
        try{
            EnterMobileNumber();
            Report.logInfo("Entered Mobile Number :" + CommonMethods.generateMobileNumber());

        } catch (Exception e) {
            Report.logInfo("Failed to enter mobile number: "+ e.getMessage());
            throw e;
        }


    }


    @Then("Enter aadharNumber")
    public void enter_aadhar_number() throws InterruptedException {
        try{
            EnterAadharNumber();
            Report.logInfo("Entered Aadhar Number :" +CommonMethods.generateAadhaarNumber() );

        } catch (Exception e) {
            Report.logInfo("Failed to enter aadhar number: "+ e.getMessage());
            throw e;
        }
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


    @Then("Click Without AadharNumber")
    public void click_without_aadhar_number() {
        try{
         ClickWithoutAadhar();
            Report.logInfo("Without Aadhar number is Clicked " );

        } catch (Exception e) {
            Report.logInfo("Failed to click without aadhar number:"+ e.getMessage());
            throw e;
        }

    }
}
