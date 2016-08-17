package com.exist.model.entity;

import com.exist.model.base.BaseEntity;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;


@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Contact extends BaseEntity {

    private static final long serialVersionUID = -1772785729825786403L;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PERSON_ID")
    private Person person;

    @Column
    private String contactInfo;

    @Column
    private String contactType;

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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }


}
