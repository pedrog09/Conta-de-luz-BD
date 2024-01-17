package com.electricitybill.repository;

import com.electricitybill.entity.TarefaRota;
import com.electricitybill.util.ConectDataBase;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TarefaRotaRepository extends ConectDataBase {

    private static final String SAVE = "INSERT INTO tarefa_rota (observacao, data_inicio, data_fim, rota_id) VALUES(?, ?, ?, ?);";
    private static final String FIND_BY_ID = "SELECT id, observacao, data_inicio, data_fim, rota_id FROM tarefa_rota WHERE id = ?;";
    private static final String FIND_ALL = "SELECT * FROM tarefa_rota;";
    private static final String DELETE = "DELETE FROM tarefa_rota WHERE id = ?;";
    private static final String UPDATE = "UPDATE tarefa_rota SET observacao = ?, data_inicio = ?, data_fim = ?, rota_id = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM tarefa_rota;";

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

    public TarefaRota save(TarefaRota entity) {

        try (PreparedStatement preparedStatement = prepararSQL(SAVE)) {
            preparedStatement.setString(1, entity.getObservacao());
            preparedStatement.setDate(2, entity.getDataInicio());
            preparedStatement.setDate(3, entity.getDataFim());
            preparedStatement.setInt(4, entity.getRotaId());
            preparedStatement.executeUpdate();
            return entity;
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public TarefaRota findById(int id) {
        TarefaRota entity = null;
        try (PreparedStatement preparedStatement = prepararSQL(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String observacao = rs.getString("observacao");
                Date data_inicio = rs.getDate("data_inicio");
                Date data_fim = rs.getDate("data_fim");
                int rota_id = rs.getInt("rota_id");
                entity = new TarefaRota(id, observacao, data_inicio, data_fim, rota_id);
                return entity;
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<TarefaRota> findAll() {
        List<TarefaRota> entityList = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(FIND_ALL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String observacao = rs.getString("observacao");
                Date data_inicio = rs.getDate("data_inicio");
                Date data_fim = rs.getDate("data_fim");
                int rota_id = rs.getInt("rota_id");
                entityList.add(new TarefaRota(id, observacao, data_inicio, data_fim, rota_id));
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

    public boolean update(int id, TarefaRota entity) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE)) {
            statement.setString(1, entity.getObservacao());
            statement.setDate(2, entity.getDataInicio());
            statement.setDate(3, entity.getDataFim());
            statement.setInt(4, entity.getRotaId());
            statement.setInt(5, id);

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
