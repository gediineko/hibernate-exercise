package com.exist.util;

import com.exist.services.ContactService;
import com.exist.services.PersonService;
import com.exist.services.RoleService;
import com.exist.services.impl.ContactServiceImpl;
import com.exist.services.impl.PersonServiceImpl;
import com.exist.services.impl.RoleServiceImpl;

public class ServiceFactory {
    private static PersonService personService;
    private static ContactService contactService;
    private static RoleService roleService;

    public static PersonService getPersonService() {
        return personService == null ? new PersonServiceImpl() : personService ;
    }

    public static ContactService getContactService() {
        return contactService == null ? new ContactServiceImpl() : contactService;
    }

    public static RoleService getRoleService() {
        return roleService == null ? new RoleServiceImpl() : roleService;
    }
}
