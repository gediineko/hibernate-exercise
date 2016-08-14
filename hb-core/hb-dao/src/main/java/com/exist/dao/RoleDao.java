package com.exist.dao;

import com.exist.model.entity.Role;

import java.util.List;
import java.util.Set;

/**
 * Created by ggolong on 8/11/16.
 */
public interface RoleDao extends BaseDao<Role, Long> {

    Set<Role> findAllByPerson(Long personId);

    Set<Role> findAllNotIn(List<Long> roleIds);
}
