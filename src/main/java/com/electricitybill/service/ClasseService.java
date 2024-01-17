package com.electricitybill.service;

import com.electricitybill.entity.Classe;

import java.sql.SQLException;
import java.util.List;

public interface ClasseService {

    List<Classe> findAll();

    Classe findById(int id);

    Classe save(Classe entity);

    boolean update(int id, Classe entity) throws SQLException;

    boolean delete(int id) throws SQLException;
}
