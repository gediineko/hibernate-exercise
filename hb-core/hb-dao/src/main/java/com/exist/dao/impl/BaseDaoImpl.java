package com.exist.dao.impl;

import com.exist.dao.BaseDao;
import com.exist.model.base.BaseEntity;
import com.exist.model.ref.ResultOrder;
import com.exist.util.ClosableSession;
import com.exist.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;


public class BaseDaoImpl<E extends BaseEntity, ID extends Serializable> implements BaseDao<E, ID> {
    protected Class<? extends E> clazz;
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @SuppressWarnings("unchecked")
    public BaseDaoImpl() {
        Type type = getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) type;
        clazz = (Class) parameterizedType.getActualTypeArguments()[0];
    }

    protected Session getSession() {
        return sessionFactory.openSession();
    }

    protected ClosableSession getClosableSession() {
        return new ClosableSession(sessionFactory.openSession());
    }

    @SuppressWarnings("unchecked")
    @Override
    public E findOne(ID id) {
        try (ClosableSession session = getClosableSession()) {
            return (E) session.getSession().get(clazz, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<E> findAll() {
        return findAll("id", ResultOrder.ASC);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<E> findAll(String field, ResultOrder order) {
        try (ClosableSession session = getClosableSession()) {
            Criteria criteria = session.getSession().createCriteria(clazz)
                    .setCacheable(true)
                    .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            if (order == ResultOrder.ASC) {
                criteria.addOrder(Order.asc(field));
            } else {
                criteria.addOrder(Order.desc(field));
            }

            return (List<E>) criteria.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(E entity) {
        Transaction transaction = null;
        try (ClosableSession session = getClosableSession()) {
            transaction = session.getSession().beginTransaction();

            session.getSession().save(entity);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void delete(E entity) {
        Transaction transaction = null;
        try (ClosableSession session = getClosableSession()) {
            transaction = session.getSession().beginTransaction();

            session.getSession().delete(entity);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
