package com.exist.dto;

import com.exist.dto.base.BaseDto;
import org.apache.commons.lang3.StringUtils;

public class ContactDto extends BaseDto {
    private String landLine;
    private String mobileNumber;
    private String email;

    public ContactDto(String landLine, String mobileNumber, String email) {
        this.landLine = landLine;
        this.mobileNumber = mobileNumber;
        this.email = email;
    }

    public String getLandLine() {
        return StringUtils.isBlank(landLine) ? "" : landLine;
    }

    public void setLandLine(String landLine) {
        this.landLine = landLine;
    }

    public String getMobileNumber() {
        return StringUtils.isBlank(mobileNumber) ? "" : mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return StringUtils.isBlank(email) ? "" : email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString(){
        return getLandLine() + "\t"
                + getMobileNumber() + "\t"
                + getEmail();
    }
}
