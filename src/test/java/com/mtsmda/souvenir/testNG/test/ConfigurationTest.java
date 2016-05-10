package com.mtsmda.souvenir.testNG.test;

import org.testng.annotations.*;

/**
 * Created by dminzat on 5/3/2016.
 */
public class ConfigurationTest {

    private static final String FIRST_GROUP = "firstGroup";

    @BeforeGroups(FIRST_GROUP)
    public void beforeGroups(){
        System.out.println("@BeforeGroups");
    }

    @AfterGroups(FIRST_GROUP)
    public void afterGroups(){
        System.out.println("@AfterGroups");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("@BeforeClass");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("@AfterClass");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("@BeforeMethod");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("@AfterMethod");
    }

    @Test(groups = FIRST_GROUP)
    public void testFirstGroup1001(){
        System.out.println("testFirstGroup1001");
    }

    @Test()
    public void test1001(){
        System.out.println("test1001");
    }

}