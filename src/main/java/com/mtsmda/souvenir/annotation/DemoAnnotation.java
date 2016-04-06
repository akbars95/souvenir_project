package com.mtsmda.souvenir.annotation;

import com.mtsmda.souvenir.toggleFeature.My2Feature;

import java.lang.annotation.*;

/**
 * Created by dminzat on 4/6/2016.
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DemoAnnotation {
    public My2Feature value() default My2Feature.FEATURE_ONE;
}