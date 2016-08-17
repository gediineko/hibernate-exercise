package com.exist.dao;

import com.exist.model.entity.Person;


public interface PersonDao extends BaseDao<Person, Long> {

    void addRole(Long personId, Long roleId);

    void removeRole(Long personId, Long roleId);

    void removeContact(Long personId, Long contactId);
}
