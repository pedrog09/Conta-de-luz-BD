package com.electricitybill.service;

import com.electricitybill.entity.Rota;

import java.sql.SQLException;
import java.util.List;

public interface RotaService {

    List<Rota> findAll();

    Rota findById(int id);

    Rota save(Rota entity);

    boolean update(int id, Rota entity) throws SQLException;

    boolean delete(int id) throws SQLException;
}
