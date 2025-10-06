package stepDefinition.talentX;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.NomineeInformation;
import utils.Excelutil;
import utils.Report;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

public class NomineeSteps extends NomineeInformation {
    public NomineeSteps() throws MalformedURLException {


    }
    private Map<String, String> testData;


    @Then("Click Nominee Tab")
    public void click_nominee_tab() throws IOException {
            try{
               ClickNomineeTab();
                Report.logInfo("Nominee Tab is Clicked");
            }catch (Exception e){
                Report.logFail("Failed to Click Nominee Tab:" +e.getMessage());
            }
            Excelutil reader = new Excelutil();
            testData = reader.getRowData("input/Profile.xlsx", "Nominee", 1);
            System.out.println("Loaded Test Data: " + testData);
        }



    @Then("Click Nominee Name")
    public void click_nominee_name() {
        try{
            ClickNomineeName();
            Report.logInfo("Nominee Name is Clicked");
        }catch (Exception e){
            Report.logFail("Failed to Click Nominee Name:" +e.getMessage());
        }


    }

    @When("Enter Nominee Name {string}")
    public void enter_nominee_name(String key) {
        try {

            String value = testData.get(key);
            Report.logInfo("Nominee Name :" + value);
            EnterNomineeName(value);
        } catch (Exception e) {
            Report.logInfo("Failed to enter Nominee Name "+ e.getMessage());
            throw e;
        }


    }

    @Then("Click Nominee Aadhar Number")
    public void click_nominee_aadhar_number() {
        try{
           ClickNomineeName();
            Report.logInfo("Nominee Name is Clicked");
        }catch (Exception e){
            Report.logFail("Failed to Click Nominee Name:" +e.getMessage());
        }

    }

    @When("Enter Nominee Aadhar Number {string}")
    public void enter_nominee_aadhar_number(String key) {
        try {

            String value = testData.get(key);
            Report.logInfo("Nominee Aadhar Number :" + value);
            EnterNomineeAadharNumber(value);
        } catch (Exception e) {
            Report.logInfo("Failed to enter Nominee Aadhar Number "+ e.getMessage());
            throw e;
        }

    }

    @Then("Click Relationship")
    public void click_relationship() {
        try{
           ClickRelationship();
            Report.logInfo("Relationship is Clicked");
        }catch (Exception e){
            Report.logFail("Failed to Click Relationship:" +e.getMessage());
        }

    }

    @Then("Select Relationship")
    public void select_relationship() {
        try{
          SelectRelationship();
            Report.logInfo("Relationship is selected :"+selectrelationship);
        }catch (Exception e){
            Report.logFail("Failed to  select relationship :" +e.getMessage());
        }

    }
}
