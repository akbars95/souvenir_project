package com.mtsmda.souvenir.spring.stereotype.object.request;

import com.mtsmda.souvenir.spring.validation.validators.constraints.*;
import com.mtsmda.souvenir.spring.validation.validators.sequence.FirstSequence;
import com.mtsmda.souvenir.spring.validation.validators.sequence.SecondSequence;
import org.hibernate.validator.constraints.Email;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

/**
 * Created by dminzat on 6/10/2016.
 */
public class RegistrationRO {

    @NotNull
    @Size(min = 3, max = 50, groups = FirstSequence.class)
    private String firstname;

    @NotNull
    @Size(min = 3, max = 50, groups = FirstSequence.class)
    private String lastname;

    @IfNotNullConstraint(min = 3, max = 75)
    private String patronymic;

    @NotNull
    @UserNameConstraint(groups = FirstSequence.class)
    private String username;

    @NotNull
    @PasswordConstraint(groups = FirstSequence.class)
    private String password;

    @NotNull
    @PasswordConstraint(groups = FirstSequence.class)
    private String passwordRepeat;

    @NotNull
    @GenderConstraint
    private String gender;

    @NotNull
    @DateValueConstraint(groups = FirstSequence.class)
    @Past(groups = SecondSequence.class)
    private String dateOfBirth;

    @NotNull
    @Size(min = 5, max = 50, groups = FirstSequence.class)
    @Email
    private String email;

    @NotNull
    @Size(min = 5, max = 50)
    private String phoneNumber;

    public RegistrationRO() {

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordRepeat() {
        return passwordRepeat;
    }

    public void setPasswordRepeat(String passwordRepeat) {
        this.passwordRepeat = passwordRepeat;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
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

    @Override
    public String toString() {
        return "RegistrationRO{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", passwordRepeat='" + passwordRepeat + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}