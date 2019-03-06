package com.granovskiy.dao;

import java.sql.Connection;
import java.util.List;

public abstract class AbstractDao<T, ID> implements GenericDao<T, ID> {

    private Connection connection;

    public AbstractDao(Connection connection) {
        this.connection = connection;
    }


    @Override
    public T create(T t) {
        return null;
    }

    @Override
    public T getById(ID id) {
        return null;
    }

    @Override
    public List<T> getAll() {
        return null;
    }

    @Override
    public T update(T t) {
        return null;
    }

    @Override
    public void delete(ID id) {

    }
}
