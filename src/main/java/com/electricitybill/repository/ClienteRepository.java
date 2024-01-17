package com.electricitybill.repository;

import com.electricitybill.entity.Cliente;
import com.electricitybill.util.ConectDataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository extends ConectDataBase {

    private static final String SAVE = "INSERT INTO cliente (num_documento, num_cliente, pessoa_id) VALUES(?, ?, ?);";
    private static final String FIND_BY_ID = "SELECT id, num_documento, num_cliente, pessoa_id FROM cliente WHERE id = ?;";
    private static final String FIND_ALL = "SELECT * FROM cliente;";
    private static final String DELETE = "DELETE FROM cliente WHERE id = ?;";
    private static final String UPDATE = "UPDATE cliente SET num_documento = ?, num_cliente = ? , pessoa_id = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM cliente;";

    public Integer count() {
        Integer count = 0;
        try (PreparedStatement preparedStatement = prepararSQL(TOTAL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    public Cliente save(Cliente entity) {

        try (PreparedStatement preparedStatement = prepararSQL(SAVE)) {
            preparedStatement.setString(1, entity.getNumDocumento());
            preparedStatement.setString(2, entity.getNumCliente());
            preparedStatement.setInt(3, entity.getPessoaId());
            preparedStatement.executeUpdate();
            return entity;
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public Cliente findById(int id) {
        Cliente entity = null;
        try (PreparedStatement preparedStatement = prepararSQL(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String numDocumento = rs.getString("num_documento");
                String numCliente = rs.getString("num_cliente");
                int pessoaId = rs.getInt("pessoa_id");
                entity = new Cliente(id, numDocumento, numCliente, pessoaId);
                return entity;
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<Cliente> findAll() {
        List<Cliente> entityList = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(FIND_ALL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String numDocumento = rs.getString("num_documento");
                String numCliente = rs.getString("num_cliente");
                int pessoaId = rs.getInt("pessoa_id");
                entityList.add(new Cliente(id, numDocumento, numCliente, pessoaId));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entityList;
    }

    public boolean delete(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean update(int id, Cliente entity) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE)) {
            statement.setString(1, entity.getNumDocumento());
            statement.setString(2, entity.getNumCliente());
            statement.setInt(3, entity.getPessoaId());
            statement.setInt(4, id);

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
