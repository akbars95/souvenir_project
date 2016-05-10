package com.mtsmda.souvenir.testNG.test.group;

import org.testng.annotations.Test;

/**
 * Created by dminzat on 5/4/2016.
 */
public class MiscRunTest {

    @Test(groups = {"jUnit", "testNG"})
    public void testCommonTest(){
        System.out.println("testCommonTest");
    }

}