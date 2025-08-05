package stepDefinition.talentX;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.profile;

import java.net.MalformedURLException;


public class ProfileSteps extends profile {
    public ProfileSteps() throws MalformedURLException {
        super();
    }

    @Given("The dashboard is visible")
    public void the_dashboard_is_visible() {

    }

    @Then("Click myaccount")
    public void click_my_account() throws InterruptedException {
        ClickMyAccount();

    }

    @Then("Profile page should visible")
    public void profile_page_should_visible() {

    }

    @Then("Click Personal Tab")
    public void click_personal_tab() {
        ClickPersonaldetails();

    }
}

