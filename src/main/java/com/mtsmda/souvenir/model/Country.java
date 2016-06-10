package com.mtsmda.souvenir.model;

/**
 * Created by dminzat on 6/10/2016.
 */
public class Country {

    private Integer countryId;
    private String countryName;

    public Country() {

    }

    public Country(String countryName) {
        this.countryName = countryName;
    }

    public Country(Integer countryId, String countryName) {
        this.countryId = countryId;
        this.countryName = countryName;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}