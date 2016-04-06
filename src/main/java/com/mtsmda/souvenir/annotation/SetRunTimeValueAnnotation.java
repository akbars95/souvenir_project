package com.mtsmda.souvenir.annotation;

import com.mtsmda.souvenir.toggleFeature.My2Feature;
import com.mtsmda.souvenir.toggleFeature.My3Feature;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Created by dminzat on 4/6/2016.
 */
public class SetRunTimeValueAnnotation {

    @DemoAnnotation(value = My2Feature.FEATURE_ONE)
    private static String field;

    public static void main(String[] args) throws NoSuchFieldException {
        Field field = SetRunTimeValueAnnotation.class.getDeclaredField("field");
        My2Feature.FEATURE_ONE.setActive(true);
        Annotation[] declaredAnnotations = field.getDeclaredAnnotations();
        if(declaredAnnotations[0] instanceof DemoAnnotation){
            DemoAnnotation demoAnnotation = (DemoAnnotation) declaredAnnotations[0];
            System.out.println(demoAnnotation.value().isActive());
        }
    }

}