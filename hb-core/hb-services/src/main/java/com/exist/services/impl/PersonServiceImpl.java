package com.exist.services.impl;

import com.exist.dao.ContactDao;
import com.exist.dao.PersonDao;
import com.exist.dao.RoleDao;
import com.exist.dto.ContactDto;
import com.exist.dto.PersonDto;
import com.exist.model.entity.Contact;
import com.exist.model.entity.Person;
import com.exist.model.entity.Role;
import com.exist.model.ref.ResultOrder;
import com.exist.services.PersonService;
import com.exist.util.DaoFactory;

import java.util.List;
import java.util.stream.Collectors;


public class PersonServiceImpl extends BaseServiceImpl implements PersonService {
    private PersonDao personDao;
    private RoleDao roleDao;
    private ContactDao contactDao;

    public PersonServiceImpl() {
        personDao = DaoFactory.getPersonDao();
        roleDao = DaoFactory.getRoleDao();
        contactDao = DaoFactory.getContactDao();
    }

    @Override
    public PersonDto findOne(Long id) {
        Person person = personDao.findOne(id);
        if (person != null) {
            return mapper.map(person, PersonDto.class);
        }
        return null;

    }



    @Override
    public List<PersonDto> findAll(String field, String orderStr) {
        ResultOrder order = orderStr.equals("asc") ? ResultOrder.ASC : ResultOrder.DESC;
        if(field.equals("gwa")){
            List<Person> personList = personDao.findAll();
            return personList.stream()
                    .sorted((p1, p2) -> p1.getGwa().compareTo(p2.getGwa()) * order.getMultiplier())
                    .map(p -> mapper.map(p, PersonDto.class))
                    .collect(Collectors.toList());

        } else {
            List<Person> personList = personDao.findAll(field, order);
            return personList
                    .stream()
                    .map(p -> mapper.map(p, PersonDto.class))
                    .collect(Collectors.toList());
        }
    }

    @Override
    public void delete(Long id) {
        personDao.delete(id);
    }

    @Override
    public void add(PersonDto personDto) {
        Person person = mapper.map(personDto, Person.class);
        personDao.save(person);
    }

    @Override
    public void update(PersonDto personDto) {
        Person person = personDao.findOne(personDto.getId());
        mapper.map(personDto, person);
        personDao.save(person);
    }

    @Override
    public void addRole(Long personId, Long roleId) {
        Person person = personDao.findOne(personId);
        Role role = roleDao.findOne(roleId);
        if (person != null && role != null) {
            personDao.addRole(personId, roleId);
        }
    }

    @Override
    public void removeRole(Long personId, Long roleId) {
        Person person = personDao.findOne(personId);
        Role role = roleDao.findOne(roleId);
        if (person != null && role != null) {
            personDao.removeRole(personId, roleId);
        }
    }

    @Override
    public void removeContact(Long personId, Long contactId) {
        Person person = personDao.findOne(personId);
        Contact contact = contactDao.findOne(contactId);
        if (person != null && contact != null){
            personDao.removeContact(personId, contactId);
        }
    }

    @Override
    public void addContact(Long personId, ContactDto contactDto) {
        Person person = personDao.findOne(personId);
        Contact contact = mapper.map(contactDto, Contact.class);
        if(person != null){
            personDao.addContact(personId, contact);
        }
    }
}
