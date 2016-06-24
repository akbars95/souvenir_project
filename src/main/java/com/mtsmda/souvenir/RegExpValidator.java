package com.mtsmda.souvenir;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dminzat on 6/14/2016.
 */
public class RegExpValidator {

    private Pattern pattern;
    private Matcher matcher;

    private static final String URL_PATTERN_UPLOAD = "/participant/[\\w]*/upload";
    private static final String URL_PATTERN_SUSPEND = "/participant/[\\w]*/[un]{0,2}suspend/[\\w]*";
    private static final String SINGLE_DOUBLE_QUOTES = "[\\w]*[\'\"]{0,2}";
    private static final String IMAGE = "^[/]{1}[\\w\\p{Punct}\\p{Blank}А-Яа-я]*(\\.(?i)(jpg|png|gif|bmp|jpeg))$";//^([\|/]{1})[\w]*.$     ([jpg|png|jpeg|gif]{1})
    private static final String WADL = "^[\\w\\p{Punct}]*[?_]?wadl$";//
    private static final String TAXID = "^[\\d]{13}$";
    private static final String EMAIL = "^()?{6,128}$";
    private static final String USERNAME = "^([\\w\\.]){7,50}$";//^(?=.{7,50})(([A-Z])+([a-z])+([\d])+([\w\.])+)+$
    private static final String PASSWORD = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{7,50})";

    public RegExpValidator(){

    }

    public RegExpValidator(Integer type){
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
        }else if(type == 6){
            pattern = Pattern.compile(USERNAME);
        }else if(type == 7){
            pattern = Pattern.compile(PASSWORD);
        }

    }

    public boolean validate(final String url){
        matcher = pattern.matcher(url);
        return matcher.matches();
    }

    public static void main(String[] args) {
        //false
        /*info(0);
        test(Arrays.asList("Iva9", "IvanfI9254IvanfI9254IvanfI9254IvanfI9254IvanfI9254FIvanfI9254IvanfI9254IvanfI9254IvanfI9254IvanfI9254F"), 6);
        //true
        info(1);
        test(Arrays.asList("Ivanov.ivan9", "Ivan.I9"), 6);
        System.out.println("PASSWORD");
        info(0);
        test(Arrays.asList("ds"), 7);*/

        String clones[] = new String[]{"clone1", "clone2"};
        System.out.println(clones.clone());
        System.out.println(clones.hashCode() + " _______ " + clones.clone().hashCode());
    }

    private static void test(List<String> testTypes, int type){
        RegExpValidator urlValidator = new RegExpValidator(type);
        for(String testType : testTypes){
            System.out.println(testType + " ----- " + urlValidator.validate(testType));
        }
    }

    private static void info(int input){
        System.out.println("--------------------------------------------");
        System.out.println(input == 0 ? "false" : "true");
    }

    private static void testWADL(){
        List<String> wadls = Arrays.asList("http://localhost:9090/mpp-registration-engine/v1.0/sdfsdf?_wadl", "?_wadl", "?wadl",
                "_wadl", "_?wadl", "?wadldfdf", "wadl");
        RegExpValidator urlValidator = new RegExpValidator(4);
        for(String wadl : wadls){
            System.out.println(wadl + " ----- " + urlValidator.validate(wadl));
        }
    }

}