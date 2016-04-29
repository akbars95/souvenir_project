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

    public URLValidator(){
        pattern = Pattern.compile(URL_PATTERN_UPLOAD);
    }

    public URLValidator(Integer type){
        if(type == 0){
            pattern = Pattern.compile(URL_PATTERN_UPLOAD);
        }else if(type == 1){
            pattern = Pattern.compile(URL_PATTERN_SUSPEND);
        }
    }

    public boolean validate(final String url){
        matcher = pattern.matcher(url);
        return matcher.matches();

    }

}