package com.godel.java.task.dao;

import java.util.List;

/**
 * Interface CrudDao.
 * create 15.04.2019.
 *
 * @author Pavel Cherkasov
 */
public interface CrudDao<T> {
    T find(Integer id);
    void save (T model);
    void update(T model);
    void delete(Integer id);
    List<T> findAll();
}
