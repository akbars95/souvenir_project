package com.mtsmda.souvenir.testNG.test.dependencyTests;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by dminzat on 5/4/2016.
 */
public class AppDependencyMethod {

    @Test
    public void method1(){
        System.out.println("method1");
    }

    @Test(dependsOnMethods = {"method1"})
    public void method2(){
        System.out.println("method2");
    }

    @Test(dependsOnMethods = "method2")
    public void method3(){
        System.out.println("method3");
    }



    @Test()
    public void method4(){
        System.out.println("method4");
        Assert.assertTrue(false);
    }

    @Test(dependsOnMethods = "method4")
    public void method5(){
        System.out.println("method5");
    }


}