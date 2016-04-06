package com.mtsmda.souvenir.toggleFeature;

/**
 * Created by dminzat on 4/4/2016.
 */
public enum MyEnum {

    FIRST(false), SECOND(false);

    MyEnum(Boolean status){
        this.setStatus(status);
    }

    private Boolean status;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}