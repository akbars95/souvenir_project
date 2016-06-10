package com.mtsmda.souvenir.model.constant;

/**
 * Created by dminzat on 6/10/2016.
 */
public enum PhoneAddressType {

    HOME(1), WORK(2), MOBILE(3);

    private Integer code;

    PhoneAddressType() {

    }

    PhoneAddressType(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}