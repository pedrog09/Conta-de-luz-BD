package com.electricitybill.service.impl;

import com.electricitybill.entity.Contrato;
import com.electricitybill.repository.ContratoRepository;
import com.electricitybill.service.ContratoService;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
public class ContratoServiceImpl implements ContratoService {

    private final ContratoRepository contratoRepository;

    @Override
    public List<Contrato> findAll() {
        return contratoRepository.findAll();
    }

    @Override
    public Contrato findById(int id) {
        return contratoRepository.findById(id);
    }

    @Override
    public Contrato save(Contrato entity) {
        return contratoRepository.save(entity);
    }

    @Override
    public boolean update(int id, Contrato entity) throws SQLException {
        return contratoRepository.update(id, entity);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return contratoRepository.delete(id);
    }
}
