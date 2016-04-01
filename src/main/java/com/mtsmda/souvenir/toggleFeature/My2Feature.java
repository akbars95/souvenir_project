package com.mtsmda.souvenir.toggleFeature;

import org.springframework.stereotype.Component;

/**
 * Created by dminzat on 3/31/2016.
 */
@Deprecated
public enum My2Feature implements Feature{

    FEATURE_ONE(false, "FEATURE_ONE"), FEATURE_TWO(false, "FEATURE_TWO");

    My2Feature(Boolean active, String name) {
        this.active = active;
        this.name = name;
    }

    private Boolean active;

    private String name;

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean value){
        this.active = value;
    }

    public String getName() {
        return name;
    }

}