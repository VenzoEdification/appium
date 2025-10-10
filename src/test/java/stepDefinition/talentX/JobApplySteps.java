package stepDefinition.talentX;

import io.cucumber.java.en.Then;
import pages.JobApply;
import utils.Excelutil;
import utils.Report;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

public class JobApplySteps extends JobApply {
    private Map<String, String> testData;
    public JobApplySteps() throws MalformedURLException {

    }
    @Then("Click Job Tab")
    public void click_job_tab() throws IOException {
        try {
            ClickJobMenu();
             Report.logInfo("Job Menu is Clicked");
        } catch (Exception e) {
            Report.logFail("Failed to Job Menu: " + e.getMessage());
            throw e;
        }
        Excelutil reader = new Excelutil();
        testData = reader.getRowData("input/job.xlsx", "job", 1);
        System.out.println("Loaded Test Data: " + testData);
    }

    @Then("Enter Job in Search {string}")
    public void enter_job_in_search(String key) {
        try {

            String value = testData.get(key);
            Report.logInfo("Job Search  :" + value);
           JobSearch(value);
        } catch (Exception e) {
            Report.logInfo("Failed to enter Job Search " + e.getMessage());

        }


    }
    @Then("Click Job View Button")
    public void click_job_view_button() {
        try {
            ClickJobView();
            Report.logInfo("Job View is Clicked");
        } catch (Exception e) {
            Report.logFail("Failed to Job View: " + e.getMessage());
            throw e;
        }


    }
    @Then("Job Apply")
    public void job_apply() {
        try {
            ApplyJob();
            Report.logInfo("Job Applied Successfully");
        } catch (Exception e) {
            Report.logFail("Failed to Apply job: " + e.getMessage());
            throw e;
        }

    }

}
