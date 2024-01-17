package com.electricitybill.service;

import com.electricitybill.entity.Poste;

import java.sql.SQLException;
import java.util.List;

public interface PosteService {

    List<Poste> findAll();

    Poste findById(int id);

    Poste save(Poste entity);

    boolean update(int id, Poste entity) throws SQLException;

    boolean delete(int id) throws SQLException;
}
