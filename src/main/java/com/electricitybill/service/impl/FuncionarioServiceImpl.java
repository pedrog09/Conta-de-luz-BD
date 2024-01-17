package com.electricitybill.service.impl;

import com.electricitybill.entity.Funcionario;
import com.electricitybill.repository.FuncionarioRepository;
import com.electricitybill.service.FuncionarioService;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
public class FuncionarioServiceImpl implements FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    @Override
    public List<Funcionario> findFuncionarioHasPessoa() {
        return funcionarioRepository.findFuncionarioHasPessoa();
    }

    @Override
    public Funcionario findById(int id) {
        return funcionarioRepository.findById(id);
    }

    @Override
    public Funcionario save(Funcionario entity) {
        return funcionarioRepository.save(entity);
    }

    @Override
    public boolean update(int id, Funcionario entity) throws SQLException {
        return funcionarioRepository.update(id, entity);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return funcionarioRepository.delete(id);
    }
}
