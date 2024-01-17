package com.electricitybill.repository;

import com.electricitybill.entity.Cobranca;
import com.electricitybill.util.ConectDataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CobrancaRepository extends ConectDataBase {

    private static final String SAVE = "INSERT INTO cobranca (mes_referencia, ano_referencia, tarifa_id, medicao_id) VALUES(?, ?, ?, ?);";
    private static final String FIND_BY_ID = "SELECT id, mes_referencia, ano_referencia, tarifa_id, medicao_id FROM cobranca WHERE id = ?;";
    private static final String FIND_ALL = "SELECT * FROM cobranca;";
    private static final String DELETE = "DELETE FROM cobranca WHERE id = ?;";
    private static final String UPDATE = "UPDATE cobranca SET mes_referencia = ?, ano_referencia = ?, tarifa_id = ?, medicao_id = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM cobranca;";

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

    public Cobranca save(Cobranca entity) {

        try (PreparedStatement preparedStatement = prepararSQL(SAVE)) {
            preparedStatement.setString(1, entity.getMesReferencia());
            preparedStatement.setString(2, entity.getAnoReferencia());
            preparedStatement.setInt(3, entity.getTarifaId());
            preparedStatement.setInt(4, entity.getMedicaoId());
            preparedStatement.executeUpdate();
            return entity;
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public Cobranca findById(int id) {
        Cobranca entity = null;
        try (PreparedStatement preparedStatement = prepararSQL(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String mes_referencia = rs.getString("mes_referencia");
                String ano_referencia = rs.getString("ano_referencia");
                int tarifa_id = rs.getInt("tarifa_id");
                int medicao_id = rs.getInt("medicao_id");
                entity = new Cobranca(id, mes_referencia, ano_referencia, tarifa_id, medicao_id);
                return entity;
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<Cobranca> findAll() {
        List<Cobranca> entityList = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(FIND_ALL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String mes_referencia = rs.getString("mes_referencia");
                String ano_referencia = rs.getString("ano_referencia");
                int tarifa_id = rs.getInt("tarifa_id");
                int medicao_id = rs.getInt("medicao_id");
                entityList.add(new Cobranca(id, mes_referencia, ano_referencia, tarifa_id, medicao_id));
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

    public boolean update(int id, Cobranca entity) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE)) {
            statement.setString(1, entity.getMesReferencia());
            statement.setString(2, entity.getAnoReferencia());
            statement.setInt(3, entity.getTarifaId());
            statement.setInt(4, entity.getMedicaoId());
            statement.setInt(5, id);

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
