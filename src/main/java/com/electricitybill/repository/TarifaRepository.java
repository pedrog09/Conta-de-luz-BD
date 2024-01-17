package com.electricitybill.repository;

import com.electricitybill.entity.Tarifa;
import com.electricitybill.util.ConectDataBase;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TarifaRepository extends ConectDataBase {

    private static final String SAVE = "INSERT INTO tarifa (taxa, classe_id, lei, data_inicio, data_fim, aliquota_ICMS) VALUES(?, ?, ?, ?, ?, ?);";
    private static final String FIND_BY_ID = "SELECT id, taxa, classe_id, lei, data_inicio, data_fim, aliquota_ICMS FROM tarifa WHERE id = ?;";
    private static final String FIND_ALL = "SELECT * FROM tarifa;";
    private static final String DELETE = "DELETE FROM tarifa WHERE id = ?;";
    private static final String UPDATE = "UPDATE tarifa SET taxa = ?, classe_id = ?, lei = ?, data_inicio = ?, data_fim = ?, aliquota_ICMS = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM tarifa;";

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

    public Tarifa save(Tarifa entity) {

        try (PreparedStatement preparedStatement = prepararSQL(SAVE)) {
            preparedStatement.setString(1, entity.getTaxa());
            preparedStatement.setInt(2, entity.getClasseId());
            preparedStatement.setString(3, entity.getLei());
            preparedStatement.setDate(4, entity.getDataInicio());
            preparedStatement.setDate(5, entity.getDataFim());
            preparedStatement.setString(6, entity.getAliquotaIcms());
            preparedStatement.executeUpdate();
            return entity;
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public Tarifa findById(int id) {
        Tarifa entity = null;
        try (PreparedStatement preparedStatement = prepararSQL(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String taxa = rs.getString("taxa");
                int classe_id = rs.getInt("classe_id");
                String lei = rs.getString("lei");
                Date data_inicio = rs.getDate("data_inicio");
                Date data_fim = rs.getDate("data_fim");
                String aliquota_ICMS = rs.getString("aliquota_ICMS");
                entity = new Tarifa(id, taxa, classe_id, lei, data_inicio, data_fim, aliquota_ICMS);
                return entity;
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<Tarifa> findAll() {
        List<Tarifa> entityList = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(FIND_ALL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String taxa = rs.getString("taxa");
                int classe_id = rs.getInt("classe_id");
                String lei = rs.getString("lei");
                Date data_inicio = rs.getDate("data_inicio");
                Date data_fim = rs.getDate("data_fim");
                String aliquota_ICMS = rs.getString("aliquota_ICMS");
                entityList.add(new Tarifa(id, taxa, classe_id, lei, data_inicio, data_fim, aliquota_ICMS));
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

    public boolean update(int id, Tarifa entity) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE)) {
            statement.setString(1, entity.getTaxa());
            statement.setInt(2, entity.getClasseId());
            statement.setString(3, entity.getLei());
            statement.setDate(4, entity.getDataInicio());
            statement.setDate(5, entity.getDataFim());
            statement.setString(6, entity.getAliquotaIcms());
            statement.setInt(7, id);

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
