package com.electricitybill.service;

import com.electricitybill.entity.Medidor;

import java.sql.SQLException;
import java.util.List;

public interface MedidorService {

    List<Medidor> findAll();

    Medidor findById(int id);

    Medidor save(Medidor entity);

    boolean update(int id, Medidor entity) throws SQLException;

    boolean delete(int id) throws SQLException;
}
