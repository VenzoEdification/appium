package com.cucumber.actions;

import org.openqa.selenium.WebDriver;

import com.cucumber.ui.loginUI;

public class testStepsActions extends loginUI{

	public testStepsActions(WebDriver driver) {
		super(driver);
	}
	
	public boolean verifyLoginPage() throws InterruptedException {
		Boolean isVerified=false;
		 Thread.sleep(2000);
		 
		isVerified = email.isDisplayed() ? true :false;
		
		return isVerified;

		//isVerified = email.isDisplayed() ? true :false;
		
	}

}
