package com.exist.services;

import com.exist.dto.RoleDto;

import java.util.List;
import java.util.Set;

/**
 * Created by ggolong on 8/12/16.
 */
public interface RoleService {
    RoleDto findOne(Long id);
    Set<RoleDto> findAll(); //add parameter?
    void delete(Long id);
    void add(RoleDto role);
    void update(RoleDto role);

    Set<RoleDto> findAllByPerson(Long personId);

    Set<RoleDto> findAllNotIn(List<Long> roleId);
}
