package com.mtsmda.souvenir.model;

import com.mtsmda.souvenir.model.constant.Gender;
import com.mtsmda.souvenir.model.security.User;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by dminzat on 6/10/2016.
 */
public class UserDetail {

    private User user;
    private String firstname;
    private String lastname;
    private String patronymic;
    private Gender gender;
    private LocalDate dateOfBirth;
    private String email;
    private String phoneNumber;
    private List<Address> addresses;

    public UserDetail(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public UserDetail(String firstname, String lastname, String patronymic, Gender gender, LocalDate dateOfBirth, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.patronymic = patronymic;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    public UserDetail(User user, String firstname, String lastname, String patronymic, Gender gender, LocalDate dateOfBirth, String email, String phoneNumber, List<Address> addresses) {
        this.user = user;
        this.firstname = firstname;
        this.lastname = lastname;
        this.patronymic = patronymic;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.addresses = addresses;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}