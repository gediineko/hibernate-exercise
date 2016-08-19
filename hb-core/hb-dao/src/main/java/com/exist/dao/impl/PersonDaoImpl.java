package com.exist.dao.impl;

import com.exist.dao.PersonDao;
import com.exist.model.entity.Contact;
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

    @Override
    public void removeContact(Long personId, Long contactId) {
        Transaction transaction = null;
        try (ClosableSession session = getClosableSession()){
            transaction = session.getSession().beginTransaction();
            Person person = (Person) session.getSession().get(clazz, personId);
            Contact contact = (Contact) session.getSession().get(Contact.class, contactId);

            person.getContactInfo().remove(contact);
            contact.setPerson(null);

            session.getSession().update(contact);

            transaction.commit();
        } catch (Exception e){
            e.printStackTrace();
            if (transaction != null){
                transaction.rollback();
            }
        }
    }

    @Override
    public void addContact(Long personId, Contact contact) {
        Transaction transaction = null;
        try (ClosableSession session = getClosableSession()) {
            transaction = session.getSession().beginTransaction();
            Person person = (Person) session.getSession().get(clazz, personId);

            contact.setPerson(person);

            session.getSession().save(contact);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void updateContact(Long personId, Long contactId, Contact newContact){
        Transaction transaction = null;
        try (ClosableSession session = getClosableSession()){
            transaction = session.getSession().beginTransaction();
            Person person = (Person) session.getSession().get(clazz, personId);
            Contact contact = (Contact) session.getSession().get(Contact.class, contactId);

            System.out.println(newContact.getContactType() + " " + newContact.getContactInfo());
            contact.setPerson(person);
            contact.setContactInfo(newContact.getContactInfo());
            contact.setContactType(newContact.getContactType());
            session.getSession().update(contact);

            transaction.commit();
        } catch (Exception e){
            e.printStackTrace();
            if (transaction != null){
                transaction.rollback();
            }
        }
    }
}
