package stepDefinition.talentX;

import io.cucumber.java.en.Then;
import pages.CEUnverified;
import utils.Report;

import java.net.MalformedURLException;

public class CEUnverifiedSteps extends CEUnverified {
    public CEUnverifiedSteps() throws MalformedURLException {
    }
    @Then("Click UnVerified Menu")
    public void click_un_verified_menu() {
        try {
            ClickUnVerified();
            Report.logInfo("UnVerified Talents Menu is Clicked");
        } catch (Exception e) {
            Report.logFail("Failed to click unverified Talent: " + e.getMessage());
            throw e;
        }

    }
    @Then("CLick Incomplete Tab")
    public void c_lick_incomplete_tab() {
        try {
            ClickIncomplete();

            Report.logInfo("Incomplete Tab is Clicked");
        } catch (Exception e) {
            Report.logFail("Failed to click employed: " + e.getMessage());
            throw e;
        }

    }
    @Then("Click Yet to be verified tab")
    public void click_yet_to_be_verified_tab() {
        try {
            ClickyettoVerified();

            Report.logInfo("Yet to Verfied Tab is Clicked");
        } catch (Exception e) {
            Report.logFail("Failed to click yet to verified: " + e.getMessage());
            throw e;
        }


    }

    @Then("CLick IncompleteTalentName")
    public void clickIncompleteTalentName() {
        try {
          Clickincompletetalentname();

            Report.logInfo("Incomplete Talent Name is Clicked");
        } catch (Exception e) {
            Report.logFail("Failed to click incomplete talent name: " + e.getMessage());
            throw e;
        }
        
    }

    @Then("CLick Yet to Verified TalentName")
    public void clickYetToVerifiedTalentName() {
        try {
          ClickyettoVerifiedtalentname();

            Report.logInfo("Yet to Verfied Talent name is Clicked");
        } catch (Exception e) {
            Report.logFail("Failed to click yet to verified: " + e.getMessage());
            throw e;
        }

    }
}
