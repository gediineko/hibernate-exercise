package com.exist.dto;

import org.apache.commons.lang3.StringUtils;

public class AddressDto {
    private String streetNumber;
    private String barangay;
    private String city;
    private String zipCode;

    public AddressDto() {
    }

    public AddressDto(String streetNumber, String barangay, String city, String zipCode) {
        this.streetNumber = streetNumber;
        this.barangay = barangay;
        this.city = city;
        this.zipCode = zipCode;
    }

    public String getStreetNumber() {
        return StringUtils.isBlank(streetNumber) ? "" : streetNumber + " ";
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getBarangay() {
        return StringUtils.isBlank(barangay) ? "" : barangay + " ";
    }

    public void setBarangay(String barangay) {
        this.barangay = barangay;
    }

    public String getCity() {
        return StringUtils.isBlank(city) ? "" : city + " ";
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return StringUtils.isBlank(zipCode) ? "" : zipCode + " ";
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString(){
        return getStreetNumber()
                + getBarangay()
                + getCity()
                + getZipCode();
    }
}
