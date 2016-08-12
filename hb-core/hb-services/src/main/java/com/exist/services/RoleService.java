package com.exist.services;

import com.exist.dao.RoleDao;
import com.exist.dto.RoleDto;

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
}
