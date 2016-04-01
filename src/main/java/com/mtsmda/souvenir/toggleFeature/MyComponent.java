package com.mtsmda.souvenir.toggleFeature;

import org.springframework.stereotype.Component;

/**
 * Created by dminzat on 4/1/2016.
 */
@Component
public class MyComponent {

    public boolean testF1(){
        System.out.println(My3Feature.FEATURE_ONE.isActive());
        return My3Feature.FEATURE_ONE.isActive();
    }

    public boolean testF2(){
        System.out.println(My3Feature.FEATURE_TWO.isActive());
        return My3Feature.FEATURE_TWO.isActive();
    }
}