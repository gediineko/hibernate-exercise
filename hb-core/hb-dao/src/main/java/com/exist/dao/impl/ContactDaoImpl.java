package com.exist.dao.impl;

import com.exist.dao.ContactDao;
import com.exist.model.entity.Contact;
import com.exist.util.ClosableSession;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ggolong on 8/11/16.
 */
public class ContactDaoImpl extends BaseDaoImpl<Contact, Long> implements ContactDao{

    @SuppressWarnings("unchecked")
    @Override
    public List<Contact> findAllByPerson(Long personId) {
        try (ClosableSession session = getClosableSession()) {
            Criteria criteria = session.getSession().createCriteria(clazz)
                    .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                    .createAlias("person", "p")
                    .add(Restrictions.eq("p.id", personId));

            return new ArrayList<>((List<Contact>) criteria.list());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
