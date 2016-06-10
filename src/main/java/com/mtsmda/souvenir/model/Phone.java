package com.mtsmda.souvenir.model;

import com.mtsmda.souvenir.model.constant.PhoneAddressType;
import com.mtsmda.souvenir.model.security.User;

/**
 * Created by dminzat on 6/10/2016.
 */
public class Phone {

    private Integer phoneId;
    private String phoneNumber;
    private PhoneAddressType phoneAddressType;
    private User user;

    public Phone() {

    }

    public Phone(String phoneNumber, PhoneAddressType phoneAddressType) {
        this.phoneNumber = phoneNumber;
        this.phoneAddressType = phoneAddressType;
    }

    public Phone(String phoneNumber, PhoneAddressType phoneAddressType, User user) {
        this.phoneNumber = phoneNumber;
        this.phoneAddressType = phoneAddressType;
        this.user = user;
    }

    public Phone(Integer phoneId, String phoneNumber, PhoneAddressType phoneAddressType, User user) {
        this.phoneId = phoneId;
        this.phoneNumber = phoneNumber;
        this.phoneAddressType = phoneAddressType;
        this.user = user;
    }

    public Integer getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(Integer phoneId) {
        this.phoneId = phoneId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public PhoneAddressType getPhoneAddressType() {
        return phoneAddressType;
    }

    public void setPhoneAddressType(PhoneAddressType phoneAddressType) {
        this.phoneAddressType = phoneAddressType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}