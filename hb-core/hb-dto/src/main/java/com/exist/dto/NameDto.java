package com.exist.dto;

import org.apache.commons.lang3.StringUtils;

public class NameDto {
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;
    private String title;

    public NameDto() {
    }

    public NameDto(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public NameDto(String firstName, String middleName, String lastName, String suffix, String title) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = suffix;
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString(){
        return (StringUtils.isBlank(title) ? "" : title + " ")
                + (StringUtils.isBlank(firstName) ? "" : firstName + " ")
                + (StringUtils.isBlank(middleName) ? "" : middleName + " ")
                + (StringUtils.isBlank(lastName) ? "" : lastName + " ")
                + (StringUtils.isBlank(suffix) ? "" : suffix + " ");
    }
}
