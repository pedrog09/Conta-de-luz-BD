package com.electricitybill.service;

import com.electricitybill.entity.Cobranca;

import java.sql.SQLException;
import java.util.List;

public interface CobrancaService {

    List<Cobranca> findAll();

    Cobranca findById(int id);

    Cobranca save(Cobranca entity);

    boolean update(int id, Cobranca entity) throws SQLException;

    boolean delete(int id) throws SQLException;
}
