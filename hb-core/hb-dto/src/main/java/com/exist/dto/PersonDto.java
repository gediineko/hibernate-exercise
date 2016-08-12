package com.exist.dto;

import com.exist.dto.base.BaseDto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PersonDto extends BaseDto {
    private NameDto name;
    private AddressDto address;
    private LocalDate birthDate;
    private Double gwa;
    private LocalDate dateHired;
    private Boolean currentlyEmployed;
    private List<ContactDto> contactInfo = new ArrayList<>();
    private Set<RoleDto> roles = new HashSet<>();

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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Double getGwa() {
        return gwa;
    }

    public void setGwa(Double gwa) {
        this.gwa = gwa;
    }

    public LocalDate getDateHired() {
        return dateHired;
    }

    public void setDateHired(LocalDate dateHired) {
        this.dateHired = dateHired;
    }

    public Boolean isCurrentlyEmployed() {
        return currentlyEmployed;
    }

    public void setCurrentlyEmployed(Boolean currentlyEmployed) {
        this.currentlyEmployed = currentlyEmployed;
    }

    public List<ContactDto> getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(List<ContactDto> contactInfo) {
        this.contactInfo = contactInfo;
    }

    public Set<RoleDto> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleDto> roles) {
        this.roles = roles;
    }

    @Override
    public String toString(){
        return getId().toString() + "\t" + name.toString() + "\t" + address.toString()
                + "\t" + birthDate.toString() + "\t" + gwa.toString()
                + "\t" + currentlyEmployed.toString() + "\t" + dateHired.toString() + "\t" ;
    }
}
