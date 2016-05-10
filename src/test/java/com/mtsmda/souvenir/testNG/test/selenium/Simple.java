package com.mtsmda.souvenir.testNG.test.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/**
 * Created by dminzat on 5/5/2016.
 */
public class Simple {

    @Test(invocationCount = 5, threadPoolSize = 3)
    public void loadWebSite(){
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("http://www.mkyong.com/unittest/testng-selenium-load-testing-example/");
        System.out.println("Google title - " + webDriver.getTitle());
        System.out.println("Thread ID - " + Thread.currentThread().getId());
        webDriver.quit();
    }

}