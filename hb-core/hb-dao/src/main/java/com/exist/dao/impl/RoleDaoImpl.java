package com.exist.dao.impl;

import com.exist.dao.RoleDao;
import com.exist.model.entity.Role;
import com.exist.util.ClosableSession;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ggolong on 8/11/16.
 */
public class RoleDaoImpl extends BaseDaoImpl<Role, Long> implements RoleDao {

    @SuppressWarnings("unchecked")
    @Override
    public Set<Role> findAllByPerson(Long personId) {
        try (ClosableSession session = getClosableSession()) {
            Criteria criteria = session.getSession().createCriteria(clazz)
                    .setCacheable(true)
                    .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                    .createAlias("person", "p")
                    .add(Restrictions.eq("p.id", personId));

            return new HashSet<>((List<Role>) criteria.list());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new HashSet<>();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Set<Role> findAllNotIn(List<Long> roleIds) {
        try (ClosableSession session = getClosableSession()) {
            Criteria criteria = session.getSession().createCriteria(clazz)
                    .setCacheable(true)
                    .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

            if (roleIds != null && roleIds.size() > 0) {
                    criteria.add(Restrictions.not(Restrictions.in("id", roleIds)));
            }
            return new HashSet<>((List<Role>) criteria.list());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new HashSet<>();
    }
}
