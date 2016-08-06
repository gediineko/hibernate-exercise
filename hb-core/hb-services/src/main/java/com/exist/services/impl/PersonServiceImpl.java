package com.exist.services.impl;

import com.exist.dao.PersonDao;
import com.exist.dao.impl.PersonDaoImpl;
import com.exist.services.PersonService;


public class PersonServiceImpl implements PersonService {
    private static final PersonDao personDao = new PersonDaoImpl();

}
