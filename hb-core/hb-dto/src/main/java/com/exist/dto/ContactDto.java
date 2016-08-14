package com.exist.dto;

import com.exist.dto.base.BaseDto;
import net.karneim.pojobuilder.GeneratePojoBuilder;
@GeneratePojoBuilder
public class ContactDto extends BaseDto {
    private String landLine;
    private String mobileNumber;
    private String email;

    public ContactDto() {
    }

    public ContactDto(String landLine, String mobileNumber, String email) {
        this.landLine = landLine;
        this.mobileNumber = mobileNumber;
        this.email = email;
    }

    public String getLandLine() {
        return landLine;
    }

    public void setLandLine(String landLine) {
        this.landLine = landLine;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
