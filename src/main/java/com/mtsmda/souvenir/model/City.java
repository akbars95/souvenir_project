package com.mtsmda.souvenir.model;

/**
 * Created by dminzat on 6/10/2016.
 */
public class City {

    private Integer cityId;
    private String cityName;
    private Country country;

    public City() {

    }

    public City(String cityName) {
        this.cityName = cityName;
    }

    public City(String cityName, Country country) {
        this.cityName = cityName;
        this.country = country;
    }

    public City(Integer cityId, String cityName, Country country) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.country = country;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}