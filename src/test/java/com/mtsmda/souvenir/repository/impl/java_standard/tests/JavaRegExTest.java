package com.mtsmda.souvenir.repository.impl.java_standard.tests;

import com.mtsmda.souvenir.tests.URLValidator;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dminzat on 4/28/2016.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JavaRegExTest {

    private static URLValidator urlValidator;

    @BeforeClass
    public static void init(){
        urlValidator = new URLValidator();
    }

    @Test
    public void test1000(){
        Assert.assertTrue(urlValidator.validate("/participant/RGB/upload"));
    }

    @Test
    public void test1001(){
        Assert.assertTrue(urlValidator.validate("/participant/1/upload"));
    }

    @Test
    public void test1002(){
        Assert.assertTrue(urlValidator.validate("/participant//upload"));
    }

    @Test
    public void test1003(){
        Assert.assertFalse(urlValidator.validate("/participant/upload"));
    }

    @Test
    public void test1004(){
        Assert.assertFalse(urlValidator.validate("/participant/@/upload"));
    }

    @Test
    public void test1005(){
        urlValidator = new URLValidator(1);
        Assert.assertTrue(urlValidator.validate("/participant/paypal/suspend/"));
    }

    @Test
    public void test1006(){
        urlValidator = new URLValidator(1);
        Assert.assertTrue(urlValidator.validate("/participant/sdfksd/unsuspend/"));
    }

    @Test
    public void test1007SingleAndDoubleQuotes(){
        urlValidator = new URLValidator(2);
        Assert.assertTrue(urlValidator.validate("participant\'\""));
    }

    @Test
    public void test1008Image(){
        urlValidator = new URLValidator(3);
        Assert.assertTrue(urlValidator.validate("/images/souvenirs/Бежевые свадебные бокалы/photo_1_12042016_115632137.jpg"));
    }

}