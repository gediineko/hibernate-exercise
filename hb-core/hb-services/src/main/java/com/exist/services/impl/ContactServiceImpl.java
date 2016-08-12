package com.exist.services.impl;

import com.exist.dao.ContactDao;
import com.exist.dao.impl.ContactDaoImpl;
import com.exist.dto.ContactDto;
import com.exist.model.entity.Contact;
import com.exist.services.ContactService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ggolong on 8/11/16.
 */
public class ContactServiceImpl extends BaseServiceImpl implements ContactService{

    ContactDao contactDao;

    public ContactServiceImpl(){
        contactDao = new ContactDaoImpl();
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
        return new ArrayList<>(); //Change
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
