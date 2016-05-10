package com.mtsmda.souvenir.testNG.test.group;

import org.testng.annotations.Test;

/**
 * Created by dminzat on 5/4/2016.
 */
@Test(groups = "jUnit")
public class JUnitTests {

    public void test1001(){
        System.out.println(this.getClass().getCanonicalName() + ".test1001");
    }

    public void test1002(){
        System.out.println(this.getClass().getCanonicalName() + ".test1002");
    }

    public void test1003(){
        System.out.println(this.getClass().getCanonicalName() + ".test1003");
    }

    public void test1004(){
        System.out.println(this.getClass().getCanonicalName() + ".test1004");
    }

}