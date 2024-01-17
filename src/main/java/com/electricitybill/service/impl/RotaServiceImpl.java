package com.electricitybill.service.impl;

import com.electricitybill.entity.Rota;
import com.electricitybill.repository.RotaRepository;
import com.electricitybill.service.RotaService;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
public class RotaServiceImpl implements RotaService {

    private RotaRepository rotaRepository;

    @Override
    public List<Rota> findAll() {
        return rotaRepository.findAll();
    }

    @Override
    public Rota findById(int id) {
        return rotaRepository.findById(id);
    }

    @Override
    public Rota save(Rota entity) {
        return rotaRepository.save(entity);
    }

    @Override
    public boolean update(int id, Rota entity) throws SQLException {
        return rotaRepository.update(id, entity);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return rotaRepository.delete(id);
    }
}
