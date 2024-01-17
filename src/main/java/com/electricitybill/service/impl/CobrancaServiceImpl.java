package com.electricitybill.service.impl;

import com.electricitybill.entity.Cobranca;
import com.electricitybill.repository.CobrancaRepository;
import com.electricitybill.service.CobrancaService;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
public class CobrancaServiceImpl implements CobrancaService {

    private final CobrancaRepository cobrancaRepository;

    @Override
    public List<Cobranca> findAll() {
        return cobrancaRepository.findAll();
    }

    @Override
    public Cobranca findById(int id) {
        return cobrancaRepository.findById(id);
    }

    @Override
    public Cobranca save(Cobranca entity) {
        return cobrancaRepository.save(entity);
    }

    @Override
    public boolean update(int id, Cobranca entity) throws SQLException {
        return cobrancaRepository.update(id, entity);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return cobrancaRepository.delete(id);
    }
}
