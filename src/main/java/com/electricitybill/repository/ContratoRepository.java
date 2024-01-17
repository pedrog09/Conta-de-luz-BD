package com.electricitybill.repository;

import com.electricitybill.entity.Contrato;
import com.electricitybill.util.ConectDataBase;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContratoRepository extends ConectDataBase {

    private static final String SAVE = "INSERT INTO contrato (descricao, data_inicio, data_fim, medidor_id, classe_id, tipo_fase, cliente_id) VALUES(?, ?, ?, ?, ?, ?, ?);";
    private static final String FIND_BY_ID = "SELECT id, descricao, data_inicio, data_fim, medidor_id, classe_id, tipo_fase, cliente_id FROM contrato WHERE id = ?;";
    private static final String FIND_ALL = "SELECT * FROM contrato;";
    private static final String DELETE = "DELETE FROM contrato WHERE id = ?;";
    private static final String UPDATE = "UPDATE contrato SET descricao = ?, data_inicio = ?, data_fim = ?, medidor_id = ?, classe_id = ?, tipo_fase = ?, cliente_id = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM contrato;";

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

    public Contrato save(Contrato entity) {

        try (PreparedStatement preparedStatement = prepararSQL(SAVE)) {
            preparedStatement.setString(1, entity.getDescricao());
            preparedStatement.setDate(2, entity.getDataInicio());
            preparedStatement.setDate(3, entity.getDataFim());
            preparedStatement.setInt(4, entity.getMedidorId());
            preparedStatement.setInt(5, entity.getClasseId());
            preparedStatement.setInt(6, entity.getTipoFase());
            preparedStatement.setInt(7, entity.getClienteId());
            preparedStatement.executeUpdate();
            return entity;
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public Contrato findById(int id) {
        Contrato entity = null;
        try (PreparedStatement preparedStatement = prepararSQL(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String descricao = rs.getString("descricao");
                Date data_inicio = rs.getDate("data_inicio");
                Date data_fim = rs.getDate("data_fim");
                int medidor_id = rs.getInt("medidor_id");
                int classe_id = rs.getInt("classe_id");
                int tipo_fase = rs.getInt("tipo_fase");
                int cliente_id = rs.getInt("cliente_id");
                entity = new Contrato(id, descricao, data_inicio, data_fim, medidor_id, classe_id, tipo_fase, cliente_id);
                return entity;
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<Contrato> findAll() {
        List<Contrato> entityList = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(FIND_ALL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                Date data_inicio = rs.getDate("data_inicio");
                Date data_fim = rs.getDate("data_fim");
                int medidor_id = rs.getInt("medidor_id");
                int classe_id = rs.getInt("classe_id");
                int tipo_fase = rs.getInt("tipo_fase");
                int cliente_id = rs.getInt("cliente_id");
                entityList.add(new Contrato(id, descricao, data_inicio, data_fim, medidor_id, classe_id, tipo_fase, cliente_id));
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

    public boolean update(int id, Contrato entity) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE)) {
            statement.setString(1, entity.getDescricao());
            statement.setDate(2, (Date) entity.getDataInicio());
            statement.setDate(3, (Date) entity.getDataFim());
            statement.setInt(4, entity.getMedidorId());
            statement.setInt(5, entity.getClasseId());
            statement.setInt(6, entity.getTipoFase());
            statement.setInt(7, entity.getClienteId());
            statement.setInt(8, id);

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
