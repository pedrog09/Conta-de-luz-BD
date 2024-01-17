package com.electricitybill.service;

import com.electricitybill.entity.TimeRota;

import java.sql.SQLException;
import java.util.List;

public interface TimeRotaService {

    List<TimeRota> findAll();

    TimeRota findById(int id);

    TimeRota save(TimeRota entity);

    boolean update(int id, TimeRota entity) throws SQLException;

    boolean delete(int id) throws SQLException;
}
