package com.exist.services.impl;

import com.exist.dao.PersonDao;
import com.exist.dao.impl.PersonDaoImpl;
import com.exist.services.PersonService;

/**
 * Created by NazIsEvil on 06/08/2016.
 */
public class PersonServiceImpl implements PersonService {
    private static final PersonDao personDao = new PersonDaoImpl();

}
