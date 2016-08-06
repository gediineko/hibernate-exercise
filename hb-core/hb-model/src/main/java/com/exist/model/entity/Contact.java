package com.exist.model.entity;

import com.exist.model.base.BaseEntity;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import javax.persistence.Entity;


@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Contact extends BaseEntity {

    private static final long serialVersionUID = -1772785729825786403L;

    @ManyToOne
    @JoinColumn(name = "PERSON_ID")
    private Person person;

    @Column
    private String landLine;

    @Column
    private String mobileNumber;

    @Column
    private String email;

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
