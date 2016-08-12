package com.exist.util;

import com.exist.dao.ContactDao;
import com.exist.dao.PersonDao;
import com.exist.dao.RoleDao;
import com.exist.dao.impl.ContactDaoImpl;
import com.exist.dao.impl.PersonDaoImpl;
import com.exist.dao.impl.RoleDaoImpl;

/**
 * Created by ggolong on 8/11/16.
 */
public class DaoFactory {
    private static PersonDao personDao;
    private static ContactDao contactDao;
    private static RoleDao roleDao;

    public static PersonDao getPersonDao() {
        return personDao == null ? new PersonDaoImpl() : personDao;
    }

    public static ContactDao getContactDao() {
        return contactDao == null ? new ContactDaoImpl() : contactDao;
    }

    public static RoleDao getRoleDao() {
        return roleDao == null ? new RoleDaoImpl() : roleDao;
    }
}
