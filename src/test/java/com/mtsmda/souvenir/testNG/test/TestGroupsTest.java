package com.mtsmda.souvenir.testNG.test;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

/**
 * Created by dminzat on 5/4/2016.
 */
public class TestGroupsTest {

    private static final String DB_GROUP = "database";
    private static final String UNIT_TEST = "unitTest";

    @BeforeGroups(DB_GROUP)
    public void setUpDB(){
        System.out.println("setUpDB");
    }

    @Test(groups = DB_GROUP)
    public void testDB1(){
        System.out.println("testDB1");
    }

    @Test(groups = DB_GROUP)
    public void testDB2(){
        System.out.println("testDB2");
    }

    @AfterGroups(DB_GROUP)
    public void cleanDB(){
        System.out.println("cleanDB");
    }

    @Test(groups = UNIT_TEST)
    public void testUnit1(){
        System.out.println("testUnit1");
    }

    @Test(groups = UNIT_TEST)
    public void testUnit2(){
        System.out.println("testUnit2");
    }

    @AfterGroups(groups = UNIT_TEST)
    public void afterUnitGroups(){
        System.out.println("afterUnitGroups");
    }

    @Test(dependsOnGroups = {UNIT_TEST, DB_GROUP})
    public void runFinal(){
        System.out.println("runFinal");
    }


}