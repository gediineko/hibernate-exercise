package com.exist.services.impl;

import com.exist.dao.RoleDao;
import com.exist.dao.impl.RoleDaoImpl;
import com.exist.dto.RoleDto;
import com.exist.model.entity.Role;
import com.exist.services.RoleService;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ggolong on 8/12/16.
 */
public class RoleServiceImpl extends BaseServiceImpl implements RoleService{
    RoleDao roleDao;

    public RoleServiceImpl(){
        roleDao = new RoleDaoImpl();
    }

    @Override
    public RoleDto findOne(Long id){
        Role role = roleDao.findOne(id);
        if (role != null){
            return mapper.map(role, RoleDto.class);
        }
        return null;
    }

    @Override
    public Set<RoleDto> findAll(){ //add parameter?
        return new HashSet<>(); //Change
    }

    @Override
    public void delete(Long id){
        roleDao.delete(id);
    }

    @Override
    public void add(RoleDto roleDto){
        Role role = mapper.map(roleDto, Role.class);
        roleDao.save(role);
    }

    @Override
    public void update(RoleDto roleDto){
        Role role = roleDao.findOne(roleDto.getId());
        mapper.map(roleDto, role);
        roleDao.save(role);
    }
}
