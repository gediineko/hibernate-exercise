package com.exist.services.impl;

import com.exist.dao.RoleDao;
import com.exist.dto.RoleDto;
import com.exist.model.entity.Role;
import com.exist.services.RoleService;
import com.exist.util.DaoFactory;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.List;

/**
 * Created by ggolong on 8/12/16.
 */
public class RoleServiceImpl extends BaseServiceImpl implements RoleService{
    private RoleDao roleDao;

    public RoleServiceImpl(){
        roleDao = DaoFactory.getRoleDao();
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
    public Set<RoleDto> findAll(){
        List<Role> roleList = roleDao.findAll();
        return roleList
                .stream()
                .map(r -> mapper.map(r, RoleDto.class))
                .collect(Collectors.toSet());
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

    @Override
    public Set<RoleDto> findAllByPerson(Long personId) {
        Set<Role> roles = roleDao.findAllByPerson(personId);
        return roles.stream()
                .map(r -> mapper.map(r, RoleDto.class))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<RoleDto> findAllNotIn(List<Long> roleId) {
        Set<Role> roles = roleDao.findAllNotIn(roleId);
        return roles.stream()
                .map(r -> mapper.map(r, RoleDto.class))
                .collect(Collectors.toSet());
    }
}
