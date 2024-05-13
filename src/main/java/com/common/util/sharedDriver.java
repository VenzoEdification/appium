package com.common.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;



public class sharedDriver extends EventFiringDecorator<WebDriver>{

    public static WebDriver driver;


    public sharedDriver() {
        this.driver = driver;
        driver=new ChromeDriver();
        driver.get("https://accounts.google.com/");
    }



}