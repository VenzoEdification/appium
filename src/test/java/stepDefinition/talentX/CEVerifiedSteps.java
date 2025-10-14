package stepDefinition.talentX;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.CEverified;
import utils.Report;

import java.net.MalformedURLException;

public class CEVerifiedSteps extends CEverified {

    public CEVerifiedSteps() throws MalformedURLException {
    }

    @Given("Homepage should displayed")
    public void homepage_should_displayed() {

    }
    @Then("Click Verified Menu")
    public void click_verified_menu() {
        try {
           ClickVerified();
            Report.logInfo("Verified Talents Menu is Clicked");
        } catch (Exception e) {
            Report.logFail("Failed to click verified Talent: " + e.getMessage());
            throw e;
        }

    }
    @Then("Click Employed tab")
    public void click_employed_tab() {
        try {
           ClickEmployed();
            Report.logInfo("Employed Tab is Clicked");
        } catch (Exception e) {
            Report.logFail("Failed to click employed: " + e.getMessage());
            throw e;
        }

    }
    @Then("CLick TalentName")
    public void c_lick_talent_name() {
        try {
           CLickEmployedName();
            Report.logInfo("Talent Name is Clicked ");
        } catch (Exception e) {
            Report.logFail("Failed to click Talent Name : " + e.getMessage());
            throw e;
        }

    }

    @Then("CLick Available Tab")
    public void clickAvailableTab() {
        try {
          ClickAvailable();
            Report.logInfo("Available Tab is CLicked");
        } catch (Exception e) {
            Report.logFail("Failed to click available tab: " + e.getMessage());
            throw e;
        }

    }
}
