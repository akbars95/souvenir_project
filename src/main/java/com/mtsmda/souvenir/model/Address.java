package com.mtsmda.souvenir.model;

/**
 * Created by dminzat on 6/10/2016.
 */
public class Address {

    private Integer addressId;
    private City city;
    private String villageName;
    private String streetName;
    private String houseNumber;
    private Integer flatNumber;

    public Address() {

    }

    public Address(City city, String streetName, String houseNumber, Integer flatNumber) {
        this.city = city;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.flatNumber = flatNumber;
    }

    public Address(Integer addressId, City city, String streetName, String houseNumber, Integer flatNumber) {
        this.addressId = addressId;
        this.city = city;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.flatNumber = flatNumber;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public Integer getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(Integer flatNumber) {
        this.flatNumber = flatNumber;
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }
}