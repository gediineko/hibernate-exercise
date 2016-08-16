package com.exist.services;

import com.exist.dto.ContactDto;

import java.util.List;

/**
 * Created by ggolong on 8/12/16.
 */
public interface ContactService {
    ContactDto findOne(Long id);
    List<ContactDto> findAll();
    List<ContactDto> findAllByPerson(Long personId);
    void delete(Long id);
    void add(ContactDto contact);
    void update(ContactDto contact);
}
