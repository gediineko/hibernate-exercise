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
        return StringUtils.isBlank(firstName) ? "" : firstName + " ";
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return StringUtils.isBlank(middleName) ? "" : middleName + " ";
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return StringUtils.isBlank(lastName) ? "" : lastName + " ";
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSuffix() {
        return StringUtils.isBlank(suffix) ? "" : suffix + " ";
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getTitle() {
        return StringUtils.isBlank(title) ? "" : title + " ";
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString(){
        return getTitle()
                + getFirstName()
                + getMiddleName()
                + getLastName()
                + getSuffix();
    }
}
