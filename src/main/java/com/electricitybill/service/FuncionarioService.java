package com.electricitybill.service;

import com.electricitybill.entity.Funcionario;

import java.sql.SQLException;
import java.util.List;

public interface FuncionarioService {

    List<Funcionario> findFuncionarioHasPessoa();

    Funcionario findById(int id);

    Funcionario save(Funcionario entity);

    boolean update(int id, Funcionario entity) throws SQLException;

    boolean delete(int id) throws SQLException;
}
