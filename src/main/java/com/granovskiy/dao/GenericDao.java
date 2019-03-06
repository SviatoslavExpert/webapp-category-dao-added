package com.granovskiy.dao;

import java.util.List;

public interface GenericDao<T, ID> {

    T create(T t);

    T getById(ID id);

    List<T> getAll();

    T update(T t);

    void delete(ID id);

}
