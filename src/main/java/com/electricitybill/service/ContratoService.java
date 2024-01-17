package com.electricitybill.service;

import com.electricitybill.entity.Contrato;

import java.sql.SQLException;
import java.util.List;

public interface ContratoService {

    List<Contrato> findAll();

    Contrato findById(int id);

    Contrato save(Contrato entity);

    boolean update(int id, Contrato entity) throws SQLException;

    boolean delete(int id) throws SQLException;
}
