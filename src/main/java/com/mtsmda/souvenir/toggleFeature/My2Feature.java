package com.mtsmda.souvenir.toggleFeature;

/**
 * Created by dminzat on 3/31/2016.
 */
public enum My2Feature {

    FEATURE_ONE(false, "FEATURE_ONE"), FEATURE_TWO(false, "FEATURE_TWO");

    My2Feature(Boolean value, String name) {
        this.value = value;
        this.name = name;
    }

    private Boolean value;

    private String name;

    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

}