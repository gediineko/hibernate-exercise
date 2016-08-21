package com.exist.dto;

import com.exist.dto.base.BaseDto;
import net.karneim.pojobuilder.GeneratePojoBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
@GeneratePojoBuilder
public class RoleDto extends BaseDto {
    private String name;

    public RoleDto(){
    }

    public RoleDto(String name){
        this.name = name;
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

        RoleDto roleDto = (RoleDto) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(name, roleDto.name)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(name)
                .toHashCode();
    }

    @Override
    public String toString(){
        return getName();
    }
}
