package com.electricitybill.service.impl;

import com.electricitybill.entity.Cliente;
import com.electricitybill.repository.ClienteRepository;
import com.electricitybill.service.Generic;
import com.electricitybill.service.Generic;
import jdk.jfr.Category;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
public class GenericImpl implements Generic<Category> {

    private final ClienteRepository clienteRepository;

    @Override
    public List<Category> findAll() {
        return Category.findAll();
    }

    @Override
    public Category findById(int id) {
        return Category.findById(id);
    }

    @Override
    public Category save(Category entity) {
        return CategoryRepository.save(entity);
    }

    @Override
    public boolean update(int id, Cliente entity) throws SQLException {
        return CategoryRepository.update(id, entity);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return CategoryRepository.delete(id);
    }
}
