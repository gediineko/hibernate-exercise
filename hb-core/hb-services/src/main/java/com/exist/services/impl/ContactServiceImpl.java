package com.exist.services.impl;

import com.exist.dao.ContactDao;
import com.exist.dto.ContactDto;
import com.exist.model.entity.Contact;
import com.exist.services.ContactService;
import com.exist.util.DaoFactory;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ggolong on 8/11/16.
 */
public class ContactServiceImpl extends BaseServiceImpl implements ContactService{

    private ContactDao contactDao;

    public ContactServiceImpl(){
        contactDao = DaoFactory.getContactDao();
    }

    @Override
    public ContactDto findOne(Long id){
        Contact contact = contactDao.findOne(id);
        if (contact != null){
            return mapper.map(contact, ContactDto.class);
        }
        return null;
    }

    @Override
    public List<ContactDto> findAll(){ //add parameter?
        List<Contact> contactList = contactDao.findAll();
        return contactList
                .stream()
                .map(p -> mapper.map(p, ContactDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ContactDto> findAllByPerson(Long personId) {
        List<Contact> contacts = contactDao.findAllByPerson(personId);
        return contacts.stream()
                .map(r -> mapper.map(r, ContactDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id){
        contactDao.delete(id);
    }

    @Override
    public void add(ContactDto contactDto){
        Contact contact = mapper.map(contactDto, Contact.class);
        contactDao.save(contact);
    }

    @Override
    public void update(ContactDto contactDto){
        Contact contact = contactDao.findOne(contactDto.getId());
        mapper.map(contactDto, contact);
        contactDao.save(contact);
    }

}
