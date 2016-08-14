package com.exist.dto;

import com.exist.dto.base.BaseDto;
import net.karneim.pojobuilder.GeneratePojoBuilder;

import java.util.Date;
@GeneratePojoBuilder
public class PersonDto extends BaseDto {
    private NameDto name;
    private AddressDto address;
    private Date birthDate;
    private Double gwa;
    private Date dateHired;
    private Boolean currentlyEmployed;

    public NameDto getName() {
        return name;
    }

    public void setName(NameDto name) {
        this.name = name;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Double getGwa() {
        return gwa;
    }

    public void setGwa(Double gwa) {
        this.gwa = gwa;
    }

    public Date getDateHired() {
        return dateHired;
    }

    public void setDateHired(Date dateHired) {
        this.dateHired = dateHired;
    }

    public Boolean getCurrentlyEmployed() {
        return currentlyEmployed;
    }

    public void setCurrentlyEmployed(Boolean currentlyEmployed) {
        this.currentlyEmployed = currentlyEmployed;
    }
}
