package com.electricitybill.repository;

import com.electricitybill.entity.Medidor;
import com.electricitybill.util.ConectDataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedidorRepository extends ConectDataBase {
    private static final String SAVE = "INSERT INTO medidor (descricao, id_poste, id_rota) VALUES(?, ?, ?);";
    private static final String FIND_BY_ID = "SELECT id, descricao, id_poste, id_rota FROM medidor WHERE id = ?;";
    private static final String FIND_ALL = "SELECT * FROM medidor;";
    private static final String DELETE = "DELETE FROM medidor WHERE id = ?;";
    private static final String UPDATE = "UPDATE medidor SET descricao = ?, id_poste = ?, id_rota = ? WHERE id= ?;";
    private static final String TOTAL = "SELECT count(1) FROM medidor;";

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

    public Medidor save(Medidor entity) {

        try (PreparedStatement preparedStatement = prepararSQL(SAVE)) {
            preparedStatement.setString(1, entity.getDescricao());
            preparedStatement.setInt(2, entity.getIdPoste());
            preparedStatement.setInt(3, entity.getIdRota());
            preparedStatement.executeUpdate();
            return entity;
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public Medidor findById(int id) {
        Medidor entity = null;
        try (PreparedStatement preparedStatement = prepararSQL(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String descricao = rs.getString("descricao");
                int id_poste = rs.getInt("id_poste");
                int id_rota = rs.getInt("id_rota");
                entity = new Medidor(id, descricao, id_poste, id_rota);
                return entity;
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<Medidor> findAll() {
        List<Medidor> entityList = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(FIND_ALL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                int id_poste = rs.getInt("id_poste");
                int id_rota = rs.getInt("id_rota");
                entityList.add(new Medidor(id, descricao, id_poste, id_rota));
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

    public boolean update(int id, Medidor entity) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE)) {
            statement.setString(1, entity.getDescricao());
            statement.setInt(2, entity.getIdPoste());
            statement.setInt(3, entity.getIdRota());
            statement.setInt(4, id);

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
