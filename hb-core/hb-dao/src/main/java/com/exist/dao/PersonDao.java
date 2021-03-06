package com.exist.dao;

import com.exist.model.entity.Contact;
import com.exist.model.entity.Person;


public interface PersonDao extends BaseDao<Person, Long> {

    void addRole(Long personId, Long roleId);

    void removeRole(Long personId, Long roleId);

    void removeContact(Long personId, Long contactId);

    void addContact(Long personId, Contact contact);

    void updateContact(Long personId, Long contactId, Contact contact);
}
