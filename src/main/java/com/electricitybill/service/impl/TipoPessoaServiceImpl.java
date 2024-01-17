package com.electricitybill.service.impl;

import com.electricitybill.entity.TipoPessoa;
import com.electricitybill.repository.TipoPessoaRepository;
import com.electricitybill.service.TipoPessoaService;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
public class TipoPessoaServiceImpl implements TipoPessoaService {

    private final TipoPessoaRepository tipoPessoaRepository;

    @Override
    public List<TipoPessoa> findAll() {
        return tipoPessoaRepository.findAll();
    }

    @Override
    public TipoPessoa findById(int id) {
        return tipoPessoaRepository.findById(id);
    }

    @Override
    public TipoPessoa save(TipoPessoa entity) {
        return tipoPessoaRepository.save(entity);
    }

    @Override
    public boolean update(int id, TipoPessoa entity) throws SQLException {
        return tipoPessoaRepository.update(id, entity);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return tipoPessoaRepository.delete(id);
    }
}
