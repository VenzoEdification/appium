package stepDefinition.talentX;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Experience;
import utils.Excelutil;
import utils.Report;
import utils.extent.CommonMethods;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

public class ExperienceSteps extends Experience {
    public ExperienceSteps() throws MalformedURLException {

    }
    private Map<String, String> testData;



    @Then("Click Experience Tab")
    public void clickExperienceTab() throws IOException {
        try{
            ClickExperienceTab();
            Report.logInfo("Experience Tab is Clicked");
        }catch (Exception e){
            Report.logFail("Failed to Click Experience Tab:" +e.getMessage());
        }
        Excelutil reader = new Excelutil();
        testData = reader.getRowData("input/Profile.xlsx", "Experience", 1);
        System.out.println("Loaded Test Data: " + testData);
    }

    @Then("Click Experience in years")
    public void clickExperienceInYears() {
        try{
            ClickExperienceinYears();
            Report.logInfo("Experience Tab is Clicked");
        }catch (Exception e){
            Report.logFail("Failed yo Click Experience Tab:" +e.getMessage());
        }
    }

    @When("Enter Experience in years {string}")
    public void enterExperienceInYears(String key) throws IOException {
        try {

            String value = testData.get(key);
            Report.logInfo("Experience in Years :" + value);
           EnterExperienceinYears(value);
        } catch (Exception e) {
            Report.logInfo("Failed to enter experience "+ e.getMessage());
            throw e;
        }

    }

    @Then("Click Industry")
    public void clickIndustry() {
        try{
            ClickIndustry();
            Report.logInfo("Industry Field is Clicked");
        }catch (Exception e){
            Report.logFail("Failed to Click Industry:" +e.getMessage());
        }
    }

    @Then("Select Industry")
    public void selectIndustry() {
        try{
            SelectIndustry();
            Report.logInfo("Industry  is Selected");
        }catch (Exception e){
            Report.logFail("Failed to select Industry:" +e.getMessage());
        }
    }

    @Then("Click Skill")
    public void clickSkill() {
        try{
           ClickSkill();
            Report.logInfo("Skill  is Clicked");
        }catch (Exception e){
            Report.logFail("Failed to click Industry:" +e.getMessage());
        }
    }

    @Then("Select Skill")
    public void selectSkill() {
        try{
            SelectSkill();
            Report.logInfo("Skill  is Selected");
        }catch (Exception e){
            Report.logFail("Failed to select skill:" +e.getMessage());
        }
    }

    @Then("Click ESIC")
    public void clickESIC() {
        try{
            ClickESIC();
            Report.logInfo("ESIC  is Clicked");
        }catch (Exception e){
            Report.logFail("Failed to click ESIC:" +e.getMessage());
        }
    }

    @Then("Select ESIC Option")
    public void selectESICOption() {
        try{
            SelectESIC();
            Report.logInfo("ESIC  is Selected");
        }catch (Exception e){
            Report.logFail("Failed to select esic:" +e.getMessage());
        }
    }

    @When("Enter ESIC")
    public void enterESIC() {

        try {
            EnterESIC();
            Report.logInfo("Enter ESIC as: " + CommonMethods.generateRandomESIC());
        } catch (Exception e) {
            Report.logFail("Failed to enter Email: " + e.getMessage());
            throw e;
        }
    }





    @Then("Click PF")
    public void clickPF() {
        try{
            ClickPF();
            Report.logInfo("PF  is Clicked");
        }catch (Exception e){
            Report.logFail("Failed to click PF:" +e.getMessage());
        }
    }

    @Then("Select PF option")
    public void selectPFOption() {
        try{
        SelectPF();
            Report.logInfo("PF  is Selected");
        }catch (Exception e){
            Report.logFail("Failed to select PF:" +e.getMessage());
        }
    }

    @When("Enter PF")
    public void enterPF() {
        try {
            EnterPF();
            Report.logInfo("Enter PF as: "+ CommonMethods.generateRandomPF());
        } catch (Exception e) {
            Report.logFail("Failed to enter Email: " + e.getMessage());
            throw e;
        }
    }
}
