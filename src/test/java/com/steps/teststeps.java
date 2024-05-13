package com.steps;


import static org.testng.Assert.assertTrue;

import container.TestActionContainer;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class teststeps {

    private TestActionContainer testActionContainer;

    public teststeps(TestActionContainer testActionContainer) {
        this.testActionContainer = testActionContainer;
    }
	
	@Given("As a user i see a Login Page")
	public void as_a_user_i_see_a_login_page() throws InterruptedException {
		assertTrue(testActionContainer.loginActions.verifyLoginPage());
	}

	@Given("I enter (.*) and (.*)")
	public void i_enter_Username_and_pasword() {
		System.out.println("credentails");
	}

	@When("I click on Signin button")
	public void i_click_on_signin_button() {
		System.out.println("signin");
	}

	@Then("i see the Inbox page")
	public void i_see_the_inbox_page() {
		System.out.println("inbox");
	}
	
}
