package com.electricitybill.service;

import java.sql.SQLException;
import java.util.List;

public interface Generic<T> {

    List<T> findAll();

    T findById(int id);

    T save(T entity);

    boolean update(int id, T entity) throws SQLException;

    boolean delete(int id) throws SQLException;
}
