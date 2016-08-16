package com.exist.dto;

import com.exist.dto.base.BaseDto;
import net.karneim.pojobuilder.GeneratePojoBuilder;
@GeneratePojoBuilder
public class ContactDto extends BaseDto {
    private String contactInfo;
    private String contactType;

    public ContactDto() {
    }

    public ContactDto(String contactInfo, String contactType) {
        this.contactInfo = contactInfo;
        this.contactType = contactType;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }
}
