package com.exist.dao;

import com.exist.model.entity.Contact;

import java.util.List;

/**
 * Created by ggolong on 8/11/16.
 */
public interface ContactDao extends BaseDao<Contact, Long> {
    List<Contact> findAllByPerson(Long personId);
}
