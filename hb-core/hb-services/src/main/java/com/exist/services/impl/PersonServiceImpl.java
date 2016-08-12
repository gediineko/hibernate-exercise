package com.exist.services.impl;

import com.exist.dao.PersonDao;
import com.exist.dao.impl.PersonDaoImpl;
import com.exist.dto.PersonDto;
import com.exist.model.entity.Person;
import com.exist.model.ref.ResultOrder;
import com.exist.services.PersonService;
import com.exist.util.DaoFactory;

import java.util.List;
import java.util.stream.Collectors;


public class PersonServiceImpl extends BaseServiceImpl implements PersonService{
    PersonDao personDao;

    public PersonServiceImpl(){
        personDao = DaoFactory.getPersonDao();
    }

    @Override
    public PersonDto findOne(Long id){
        Person person = personDao.findOne(id);
        if (person != null){
            return mapper.map(person, PersonDto.class);
        }
        return null;

    }

    @Override
    public List<PersonDto> findAll(String field, String orderStr){
        ResultOrder order = orderStr.equals("asc") ? ResultOrder.ASC : ResultOrder.DESC;
        List<Person> personList = personDao.findAll(field, order);
        return personList
                .stream()
                .map(p -> mapper.map(p, PersonDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id){
        personDao.delete(id);
    }

    @Override
    public void add(PersonDto personDto){
        Person person = mapper.map(personDto, Person.class);
        personDao.save(person);
    }

    @Override
    public void update(PersonDto personDto){
        Person person = personDao.findOne(personDto.getId());
        mapper.map(personDto, person);
        personDao.save(person);
    }

}
