package com.exist.services.impl;

import com.exist.dao.PersonDao;
import com.exist.dao.impl.PersonDaoImpl;
import com.exist.dto.PersonDto;
import com.exist.model.ref.ResultOrder;
import com.exist.services.PersonService;

import java.util.List;


public class PersonServiceImpl implements PersonService {
    PersonDao personDao;

    public PersonServiceImpl(){
        personDao = new PersonDaoImpl();
    }

    @Override
    public void listPerson(String listBy, String listOrder){
        if (listOrder.equals("asc")){
            personDao.findAll(listBy, ResultOrder.ASC);
        } else if (listOrder.equals("desc")){
            personDao.findAll(listBy, ResultOrder.DESC);
        }

    }

}
