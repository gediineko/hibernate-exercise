package com.exist.services;


import com.exist.dto.ContactDto;
import com.exist.dto.PersonDto;

import java.util.List;

public interface PersonService {
    PersonDto findOne(Long id);
    List<PersonDto> findAll(String field, String orderStr);
    void delete(Long id);
    void add(PersonDto person);
    void update(PersonDto person);
    void addRole(Long personId, Long roleId);
    void removeRole(Long personId, Long roleId);
    void removeContact(Long personId, Long contactId);
    void addContact(Long personId, ContactDto contactDto);
    void updateContact(Long personId, Long contactId, ContactDto contactDto);
}
