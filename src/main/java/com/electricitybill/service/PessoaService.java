package com.electricitybill.service;

import com.electricitybill.entity.Pessoa;

import java.sql.SQLException;
import java.util.List;

public interface PessoaService {

    List<Pessoa> findAll();

    Pessoa findById(int id);

    Pessoa save(Pessoa entity);

    boolean update(int id, Pessoa entity) throws SQLException;

    boolean delete(int id) throws SQLException;
}
