package com.electricitybill.repository;

import com.electricitybill.entity.Funcionario;
import com.electricitybill.service.impl.PessoaServiceImpl;
import com.electricitybill.util.ConectDataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioRepository extends ConectDataBase {

    private static final String SAVE = "INSERT INTO funcionario (codigo_funcional, pessoa_id) VALUES(?, ?);";

    private static final String FIND_BY_ID = "SELECT id, codigo_funcional, pessoa_id FROM funcionario WHERE id = ?;";

    private static final String DELETE = "DELETE FROM funcionario WHERE id = ?;";

    private static final String UPDATE = "UPDATE funcionario SET codigo_funcional = ?, pessoa_id = ? WHERE id = ?;";

    private static final String TOTAL = "SELECT count(1) FROM funcionario;";

    private static final String FUNCIONARIO_HAS_PESSOA = "select * from funcionario inner join pessoa on funcionario.pessoa_id  = pessoa.id;";

    PessoaRepository pessoaRepository = new PessoaRepository();

    PessoaServiceImpl pessoaService = new PessoaServiceImpl(pessoaRepository);


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

    public Funcionario save(Funcionario entity) {

        try (PreparedStatement preparedStatement = prepararSQL(SAVE)) {
            preparedStatement.setString(1, entity.getCodigoFuncional());
            preparedStatement.setInt(2, entity.getPessoa().getId());
            preparedStatement.executeUpdate();
            return entity;
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public Funcionario findById(int id) {
        Funcionario entity = null;
        try (PreparedStatement preparedStatement = prepararSQL(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String codigoFuncional = rs.getString("codigo_funcional");
                int pessoaId = rs.getInt("pessoa_id");
                var pessoa = pessoaService.findById(pessoaId);
                entity = new Funcionario(id, codigoFuncional, pessoa);
                return entity;
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<Funcionario> findFuncionarioHasPessoa() {
        List<Funcionario> entityList = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(FUNCIONARIO_HAS_PESSOA)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String codigoFuncional = rs.getString("codigo_funcional");
                int pessoaId = rs.getInt("pessoa_id");
                var pessoa = pessoaService.findById(pessoaId);
                entityList.add(new Funcionario(id, codigoFuncional, pessoa));
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

    public boolean update(int id, Funcionario entity) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE)) {
            statement.setString(1, entity.getCodigoFuncional());
            statement.setInt(2, entity.getPessoa().getId());
            statement.setInt(3, id);

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
