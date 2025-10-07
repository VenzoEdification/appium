package stepDefinition.talentX;


import io.cucumber.java.en.Then;
import pages.ContractorandEmployer;
import utils.Report;

import java.net.MalformedURLException;

public class CESteps extends ContractorandEmployer {

    public CESteps() throws MalformedURLException {
    }

    @Then("Click Contractor and Employer Tab")
    public void click_contractor_and_employer_tab() {
        try {
            ClickContractorandEmployerTab();
            Report.logInfo("Contractor and Employer Tab  is Clicked");
        } catch (Exception e) {
            Report.logFail("Failed to click Contractor and Employer Tab: " + e.getMessage());
            throw e;
        }

    }

    @Then("CLick History Button")
    public void click_history_button() {
        try {
            ClickHistory();
            Report.logInfo("History Button is Clicked");
        } catch (Exception e) {
            Report.logFail("Failed to click History Button: " + e.getMessage());
            throw e;
        }

    }

    @Then("CLick Back Button")
    public void clickBackButton() {

    }
}

