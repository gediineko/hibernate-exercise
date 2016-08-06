package com.exist.dao;

import com.exist.model.base.BaseEntity;
import com.exist.model.ref.ResultOrder;

import java.io.Serializable;
import java.util.List;


public interface BaseDao<E extends BaseEntity, ID extends Serializable> {

    E findOne(ID id);

    List<E> findAll();

    List<E> findAll(String field, ResultOrder order);

    void save(E entity);

    void delete(E entity);

}
