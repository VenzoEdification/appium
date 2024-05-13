package com.cucumber.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;



public class loginUI {

    protected final WebDriver driver;

    public loginUI(WebDriver driver) {
    	PageFactory.initElements(driver, this);
        this.driver = driver;
    }
	
    @FindBy(how = How.XPATH, using = "(//div[.='Use another account'])[last()]")
    protected WebElement useranotheracc;    
    
    @FindBy(how = How.XPATH, using = "//input[@type='email']")
    public WebElement email;
}
