package com.mtsmda.souvenir.model;

/**
 * Created by dminzat on 6/10/2016.
 */
public class PhoneAddressType {

    private Integer phoneAddressTypeId;
    private String phoneAddressType;

    public PhoneAddressType() {

    }

    public PhoneAddressType(String phoneAddressType) {
        this.phoneAddressType = phoneAddressType;
    }

    public PhoneAddressType(Integer phoneAddressTypeId, String phoneAddressType) {
        this.phoneAddressTypeId = phoneAddressTypeId;
        this.phoneAddressType = phoneAddressType;
    }

    public Integer getPhoneAddressTypeId() {
        return phoneAddressTypeId;
    }

    public void setPhoneAddressTypeId(Integer phoneAddressTypeId) {
        this.phoneAddressTypeId = phoneAddressTypeId;
    }

    public String getPhoneAddressType() {
        return phoneAddressType;
    }

    public void setPhoneAddressType(String phoneAddressType) {
        this.phoneAddressType = phoneAddressType;
    }
}