package com.mtsmda.souvenir.model.constant;

/**
 * Created by dminzat on 6/10/2016.
 */
public enum Gender {

    MALE("m"), FEMALE("f");

    private String code;

    Gender() {

    }

    Gender(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}