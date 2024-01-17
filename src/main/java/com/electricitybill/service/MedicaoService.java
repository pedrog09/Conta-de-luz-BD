package com.electricitybill.service;

import com.electricitybill.entity.Medicao;

import java.sql.SQLException;
import java.util.List;

public interface MedicaoService {

    List<Medicao> findAll();

    Medicao findById(int id);

    Medicao save(Medicao entity);

    boolean update(int id, Medicao entity) throws SQLException;

    boolean delete(int id) throws SQLException;
}
