package com.electricitybill.service;

import com.electricitybill.entity.TipoFase;

import java.sql.SQLException;
import java.util.List;

public interface TipoFaseService {

    List<TipoFase> findAll();

    TipoFase findById(int id);

    TipoFase save(TipoFase entity);

    boolean update(int id, TipoFase entity) throws SQLException;

    boolean delete(int id) throws SQLException;
}
