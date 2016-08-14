package com.exist.dao.impl;

import com.exist.dao.PersonDao;
import com.exist.model.entity.Person;
import com.exist.model.entity.Role;
import com.exist.util.ClosableSession;
import org.hibernate.Transaction;


public class PersonDaoImpl extends BaseDaoImpl<Person, Long> implements PersonDao {
    @Override
    public void addRole(Long personId, Long roleId) {
        Transaction transaction = null;
        try (ClosableSession session = getClosableSession()) {
            transaction = session.getSession().beginTransaction();
            Person person = (Person) session.getSession().get(clazz, personId);
            Role role = (Role) session.getSession().get(Role.class, roleId);

            person.getRoles().add(role);

            session.getSession().update(person);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void removeRole(Long personId, Long roleId) {
        Transaction transaction = null;
        try (ClosableSession session = getClosableSession()) {
            transaction = session.getSession().beginTransaction();
            Person person = (Person) session.getSession().get(clazz, personId);
            Role role = (Role) session.getSession().get(Role.class, roleId);

            person.getRoles().remove(role);

            session.getSession().update(person);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
