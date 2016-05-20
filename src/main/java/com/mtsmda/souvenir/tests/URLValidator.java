package com.mtsmda.souvenir.tests;

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
        }
    }

    public boolean validate(final String url){
        matcher = pattern.matcher(url);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println(new URLValidator(3).validate("/images/souvenirs/Бежевые свадебные бокалы/photo_1_12042016_115632137.jpeg"));
        ///images/souvenirs/Бежевые свадебные бокалы/photo_1_12042016_115632137.jpg
    }

}