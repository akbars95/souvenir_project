package com.mtsmda.souvenir.testNG.test.selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by dminzat on 5/6/2016.
 */
public class JSCall {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "/Users/mkyong/Downloads/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=1024,768");

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        WebDriver driver = new ChromeDriver(capabilities);

        driver.get("http://google.com/");

        if (driver instanceof JavascriptExecutor) ((JavascriptExecutor) driver)
                .executeScript("alert('hello world');");
    }

}