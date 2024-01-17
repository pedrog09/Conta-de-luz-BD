package com.electricitybill.service;

import com.electricitybill.entity.Tarifa;

import java.sql.SQLException;
import java.util.List;

public interface TarifaService {

    List<Tarifa> findAll();

    Tarifa findById(int id);

    Tarifa save(Tarifa entity);

    boolean update(int id, Tarifa entity) throws SQLException;

    boolean delete(int id) throws SQLException;
}
