package com.electricitybill.service.impl;

import com.electricitybill.entity.Pessoa;
import com.electricitybill.repository.PessoaRepository;
import com.electricitybill.service.PessoaService;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
public class PessoaServiceImpl implements PessoaService {

    private final PessoaRepository pessoaRepository;

    @Override
    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    @Override
    public Pessoa findById(int id) {
        return pessoaRepository.findById(id);
    }

    @Override
    public Pessoa save(Pessoa entity) {
        return pessoaRepository.save(entity);
    }

    @Override
    public boolean update(int id, Pessoa entity) throws SQLException {
        return pessoaRepository.update(id, entity);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return pessoaRepository.delete(id);
    }
}
