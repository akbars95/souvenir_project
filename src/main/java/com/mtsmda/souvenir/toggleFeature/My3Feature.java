package com.mtsmda.souvenir.toggleFeature;

/**
 * Created by dminzat on 4/1/2016.
 */
public enum My3Feature implements Feature {

    FEATURE_ONE, FEATURE_TWO;

    public Boolean isActive() {
        return PropertiesFileEditor.isActive(this);
    }


}