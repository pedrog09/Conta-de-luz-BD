package com.electricitybill.repository;

import com.electricitybill.entity.Classe;
import com.electricitybill.util.ConectDataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClasseRepository extends ConectDataBase {

    private static final String SAVE = "INSERT INTO classe (descricao, tipo_fase_id) VALUES(?, ?);";
    private static final String FIND_BY_ID = "SELECT id, descricao, tipo_fase_id FROM classe WHERE id = ?;";
    private static final String FIND_ALL = "SELECT * FROM classe;";
    private static final String DELETE = "DELETE FROM classe WHERE id = ?;";
    private static final String UPDATE = "UPDATE classe SET descricao = ?, tipo_fase_id = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM classe;";

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

    public Classe save(Classe entity) {

        try (PreparedStatement preparedStatement = prepararSQL(SAVE)) {
            preparedStatement.setString(1, entity.getDescricao());
            preparedStatement.setInt(2, entity.getTipoFaseId());
            preparedStatement.executeUpdate();
            return entity;
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public Classe findById(int id) {
        Classe entity = null;
        try (PreparedStatement preparedStatement = prepararSQL(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String descricao = rs.getString("descricao");
                int tipo_fase_id = rs.getInt("tipo_fase_id");
                entity = new Classe(id, descricao, tipo_fase_id);
                return entity;
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<Classe> findAll() {
        List<Classe> entityList = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(FIND_ALL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                int tipo_fase_id = rs.getInt("tipo_fase_id");
                entityList.add(new Classe(id, descricao, tipo_fase_id));
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

    public boolean update(int id, Classe entity) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE)) {
            statement.setString(1, entity.getDescricao());
            statement.setInt(2, entity.getTipoFaseId());
            statement.setInt(3, id);

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
