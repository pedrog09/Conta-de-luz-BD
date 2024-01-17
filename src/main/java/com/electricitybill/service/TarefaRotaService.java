package com.electricitybill.service;

import com.electricitybill.entity.TarefaRota;

import java.sql.SQLException;
import java.util.List;

public interface TarefaRotaService {

    List<TarefaRota> findAll();

    TarefaRota findById(int id);

    TarefaRota save(TarefaRota entity);

    boolean update(int id, TarefaRota entity) throws SQLException;

    boolean delete(int id) throws SQLException;
}
