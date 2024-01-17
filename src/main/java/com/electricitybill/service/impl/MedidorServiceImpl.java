package com.electricitybill.service.impl;

import com.electricitybill.entity.Medidor;
import com.electricitybill.repository.MedidorRepository;
import com.electricitybill.service.MedidorService;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
public class MedidorServiceImpl implements MedidorService {

    private final MedidorRepository medidorRepository;

    @Override
    public List<Medidor> findAll() {
        return medidorRepository.findAll();
    }

    @Override
    public Medidor findById(int id) {
        return medidorRepository.findById(id);
    }

    @Override
    public Medidor save(Medidor entity) {
        return medidorRepository.save(entity);
    }

    @Override
    public boolean update(int id, Medidor entity) throws SQLException {
        return medidorRepository.update(id, entity);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return medidorRepository.delete(id);
    }
}
