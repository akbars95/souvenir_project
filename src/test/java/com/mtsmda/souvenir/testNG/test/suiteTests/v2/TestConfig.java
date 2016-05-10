package com.mtsmda.souvenir.testNG.test.suiteTests.v2;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

/**
 * Created by dminzat on 5/4/2016.
 */
public class TestConfig {

    @BeforeSuite
    public void testBeforeSuite(){
        System.out.println("testBeforeSuite");
    }

    @AfterSuite
    public void testAfterSuite(){
        System.out.println("testAfterSuite");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("beforeTest");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("afterTest");
    }

}