package com.electricitybill.service.impl;

import com.electricitybill.entity.Tarifa;
import com.electricitybill.repository.TarifaRepository;
import com.electricitybill.service.TarifaService;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
public class TarifaServiceImpl implements TarifaService {

    private TarifaRepository tarifaRepository;

    @Override
    public List<Tarifa> findAll() {
        return tarifaRepository.findAll();
    }

    @Override
    public Tarifa findById(int id) {
        return tarifaRepository.findById(id);
    }

    @Override
    public Tarifa save(Tarifa entity) {
        return tarifaRepository.save(entity);
    }

    @Override
    public boolean update(int id, Tarifa entity) throws SQLException {
        return tarifaRepository.update(id, entity);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return tarifaRepository.delete(id);
    }
}
