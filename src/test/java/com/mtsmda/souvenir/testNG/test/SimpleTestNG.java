package com.mtsmda.souvenir.testNG.test;

import org.testng.annotations.Test;

/**
 * Created by dminzat on 5/5/2016.
 */
public class SimpleTestNG {

    private static int count = 0;

    @Test(invocationCount = 1000)
    public void testSimple(){
        System.out.println("testSimple - " + ++count);
    }

}