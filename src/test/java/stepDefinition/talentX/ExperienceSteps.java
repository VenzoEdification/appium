package stepDefinition.talentX;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Experience;
import utils.Report;

import java.net.MalformedURLException;

public class ExperienceSteps extends Experience {
    public ExperienceSteps() throws MalformedURLException {
    }

    @Then("Click Experience Tab")
    public void clickExperienceTab() {
        try{
            ClickExperienceTab();
            Report.logInfo("Experience Tab is Clicked");
        }catch (Exception e){
            Report.logFail("Failed yo Click Experience Tab:" +e.getMessage());
        }
    }

    @Then("Click Experience in years")
    public void clickExperienceInYears() {
        try{
            ClickExperienceTab();
            Report.logInfo("Experience Tab is Clicked");
        }catch (Exception e){
            Report.logFail("Failed yo Click Experience Tab:" +e.getMessage());
        }
    }

    @When("Enter Experience in years {string}")
    public void enterExperienceInYears(String arg0) {
    }

    @Then("Click Industry")
    public void clickIndustry() {
    }

    @Then("Select Industry")
    public void selectIndustry() {
    }

    @Then("Click Skill")
    public void clickSkill() {
    }

    @Then("Select Skill")
    public void selectSkill() {
    }
}
