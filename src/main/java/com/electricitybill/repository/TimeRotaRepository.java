package com.electricitybill.repository;

import com.electricitybill.entity.TimeRota;
import com.electricitybill.util.ConectDataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TimeRotaRepository extends ConectDataBase {

    private static final String SAVE = "INSERT INTO time_rota (funcionario_id, tarefa_rota_id) VALUES(?, ?);";
    private static final String FIND_BY_ID = "SELECT id, funcionario_id, tarefa_rota_id FROM time_rota WHERE id = ?;";
    private static final String FIND_ALL = "SELECT * FROM time_rota;";
    private static final String DELETE = "DELETE FROM time_rota WHERE id = ?;";
    private static final String UPDATE = "UPDATE time_rota SET funcionario_id = ?, tarefa_rota_id = ? WHERE id= ?;";
    private static final String TOTAL = "SELECT count(1) FROM time_rota;";

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

    public TimeRota save(TimeRota entity) {

        try (PreparedStatement preparedStatement = prepararSQL(SAVE)) {
            preparedStatement.setInt(1, entity.getFuncionarioId());
            preparedStatement.setInt(2, entity.getTarefaRotaId());
            preparedStatement.executeUpdate();
            return entity;
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public TimeRota findById(int id) {
        TimeRota entity = null;
        try (PreparedStatement preparedStatement = prepararSQL(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int funcionario_id = rs.getInt("funcionario_id");
                int tarefa_rota_id = rs.getInt("tarefa_rota_id");
                entity = new TimeRota(id, funcionario_id, tarefa_rota_id);
                return entity;
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<TimeRota> findAll() {
        List<TimeRota> entityList = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(FIND_ALL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int funcionario_id = rs.getInt("funcionario_id");
                int tarefa_rota_id = rs.getInt("tarefa_rota_id");
                entityList.add(new TimeRota(id, funcionario_id, tarefa_rota_id));
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

    public boolean update(int id, TimeRota entity) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE)) {
            statement.setInt(1, entity.getFuncionarioId());
            statement.setInt(2, entity.getTarefaRotaId());
            statement.setInt(3, id);

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
