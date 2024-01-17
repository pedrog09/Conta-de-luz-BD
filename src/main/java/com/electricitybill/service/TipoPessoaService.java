package com.electricitybill.service;

import com.electricitybill.entity.TipoPessoa;

import java.sql.SQLException;
import java.util.List;

public interface TipoPessoaService {

    List<TipoPessoa> findAll();

    TipoPessoa findById(int id);

    TipoPessoa save(TipoPessoa entity);

    boolean update(int id, TipoPessoa entity) throws SQLException;

    boolean delete(int id) throws SQLException;
}
