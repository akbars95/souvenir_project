package com.mtsmda.souvenir.testNG.test;

import org.testng.annotations.Test;

import java.io.FileNotFoundException;

/**
 * Created by dminzat on 5/3/2016.
 */
public class DemoTest {

    @Test
    public void test1001(){
        System.out.println("test1001");
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void test1002RuntimeExceptionExpected(){
        System.out.println("test1002RuntimeExceptionExpected");
        int div = 1 / 0;
    }

    @Test(expectedExceptions = {Exception.class})
    public void test1003CheckedExceptionExpected() throws Exception{
        System.out.println("test1003CheckedExceptionExpected");
        if(true){
            throw new Exception("");
        }else{
            throw new FileNotFoundException("");
        }
    }

    @Test(enabled = false)
    public void test1004Ignored(){
        System.out.println("test1004Ignored");
    }

    @Test(timeOut = 1200)
    public void test1005TimeOut() throws InterruptedException {
        System.out.println("test1005TimeOut");
        Thread.sleep(1500);
    }

}