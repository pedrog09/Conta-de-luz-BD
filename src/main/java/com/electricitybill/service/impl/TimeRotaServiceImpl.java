package com.electricitybill.service.impl;

import com.electricitybill.entity.TimeRota;
import com.electricitybill.repository.TimeRotaRepository;
import com.electricitybill.service.TimeRotaService;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
public class TimeRotaServiceImpl implements TimeRotaService {

    private final TimeRotaRepository timeRotaRepository;

    @Override
    public List<TimeRota> findAll() {
        return timeRotaRepository.findAll();
    }

    @Override
    public TimeRota findById(int id) {
        return timeRotaRepository.findById(id);
    }

    @Override
    public TimeRota save(TimeRota entity) {
        return timeRotaRepository.save(entity);
    }

    @Override
    public boolean update(int id, TimeRota entity) throws SQLException {
        return timeRotaRepository.update(id, entity);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return timeRotaRepository.delete(id);
    }
}
