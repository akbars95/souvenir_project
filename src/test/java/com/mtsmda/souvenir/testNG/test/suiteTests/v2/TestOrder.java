package com.mtsmda.souvenir.testNG.test.suiteTests.v2;

import org.testng.annotations.Test;

/**
 * Created by dminzat on 5/4/2016.
 */
public class TestOrder {

    private static final String ORDER_BO = "ORDER_BO";
    private static final String SAVE = "SAVE";

    @Test(groups = {ORDER_BO, SAVE})
    public void testMakeOrder(){
        System.out.println("testMakeOrder");
    }

    @Test(groups = {ORDER_BO, SAVE})
    public void testMakeEmptyOrder(){
        System.out.println("testMakeEmptyOrder");
    }

    @Test(groups = {ORDER_BO})
    public void testUpdateOrder(){
        System.out.println("testUpdateOrder");
    }

    @Test(groups = {ORDER_BO})
    public void testFindOrder(){
        System.out.println("testFindOrder");
    }

}