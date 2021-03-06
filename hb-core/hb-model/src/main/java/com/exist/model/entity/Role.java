package com.exist.model.entity;

import com.exist.model.base.BaseEntity;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.util.List;


@Entity
public class Role extends BaseEntity {

    private static final long serialVersionUID = 1068681731270573784L;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "PERSON_ROLE",
            joinColumns = @JoinColumn(name = "ROLE_ID"),
            inverseJoinColumns = @JoinColumn(name = "PERSON_ID"))
    private List<Person> person;

    @Column
    private String name;

    public List<Person> getPerson() {
        return person;
    }

    public void setPerson(List<Person> person) {
        this.person = person;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Role role1 = (Role) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(name, role1.name)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(name)
                .toHashCode();
    }
}
