package com.electricitybill.service.impl;

import com.electricitybill.entity.TipoFase;
import com.electricitybill.repository.TipoFaseRepository;
import com.electricitybill.service.TipoFaseService;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
public class TipoFaseServiceImpl implements TipoFaseService {

    private final TipoFaseRepository tipoFaseRepository;

    @Override
    public List<TipoFase> findAll() {
        return tipoFaseRepository.findAll();
    }

    @Override
    public TipoFase findById(int id) {
        return tipoFaseRepository.findById(id);
    }

    @Override
    public TipoFase save(TipoFase entity) {
        return tipoFaseRepository.save(entity);
    }

    @Override
    public boolean update(int id, TipoFase entity) throws SQLException {
        return tipoFaseRepository.update(id, entity);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return tipoFaseRepository.delete(id);
    }
}
