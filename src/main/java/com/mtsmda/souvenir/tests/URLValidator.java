package com.mtsmda.souvenir.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dminzat on 4/28/2016.
 */
public class URLValidator {

    private Pattern pattern;
    private Matcher matcher;

    private static final String URL_PATTERN_UPLOAD = "/participant/[\\w]*/upload";
    private static final String URL_PATTERN_SUSPEND = "/participant/[\\w]*/[un]{0,2}suspend/[\\w]*";
    private static final String SINGLE_DOUBLE_QUOTES = "[\\w]*[\'\"]{0,2}";
    private static final String IMAGE = "^[/]{1}[\\w\\p{Punct}\\p{Blank}А-Яа-я]*(\\.(?i)(jpg|png|gif|bmp|jpeg))$";//^([\|/]{1})[\w]*.$     ([jpg|png|jpeg|gif]{1})
    private static final String WADL = "^[\\w\\p{Punct}]*[?_]?wadl$";//
    private static final String TAXID = "^[\\d]{13}$";

    public URLValidator(){
        pattern = Pattern.compile(URL_PATTERN_UPLOAD);
    }

    public URLValidator(Integer type){
        if(type == 0){
            pattern = Pattern.compile(URL_PATTERN_UPLOAD);
        }else if(type == 1){
            pattern = Pattern.compile(URL_PATTERN_SUSPEND);
        }else if(type == 2){
            pattern = Pattern.compile(SINGLE_DOUBLE_QUOTES);
        }else if(type == 3){
            pattern = Pattern.compile(IMAGE);
        }else if(type == 4){
            pattern = Pattern.compile(WADL);
        }else if(type == 5){
            pattern = Pattern.compile(TAXID);
        }
    }

    public boolean validate(final String url){
        matcher = pattern.matcher(url);
        return matcher.matches();
    }

    public static void main(String[] args) {
//        System.out.println(new URLValidator(3).validate("/images/souvenirs/Бежевые свадебные бокалы/photo_1_12042016_115632137.jpeg"));
        ///images/souvenirs/Бежевые свадебные бокалы/photo_1_12042016_115632137.jpg
//        System.out.println(new URLValidator(4).validate(""));
//        System.out.println(new URLValidator(4).validate("?_wadl"));
//        System.out.println(new URLValidator(4).validate("?wadl"));
//        System.out.println(new URLValidator(4).validate("?wadldfdf"));
//        System.out.println(new URLValidator(4).validate("wadl"));
//        testWADL();

        List<String> taxId = Arrays.asList("0123456789123", "0123456789AB_", "0123456789Ac", "3200544005666");
        test(taxId, 5);
    }

    private static void testWADL(){
        List<String> wadls = Arrays.asList("http://localhost:9090/mpp-registration-engine/v1.0/sdfsdf?_wadl", "?_wadl", "?wadl",
                "_wadl", "_?wadl", "?wadldfdf", "wadl");
        URLValidator urlValidator = new URLValidator(4);
        for(String wadl : wadls){
            System.out.println(wadl + " ----- " + urlValidator.validate(wadl));
        }
    }


    private static void test(List<String> testTypes, int type){
        URLValidator urlValidator = new URLValidator(type);
        for(String testType : testTypes){
            System.out.println(testType + " ----- " + urlValidator.validate(testType));
        }
    }

}