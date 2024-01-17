package com.electricitybill.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConectDataBase {

    private static final String dbName = "postgres 2";
    private static final String dbURL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String username = "postgres";
    private static final String password = "1006";

    public static Connection conexaoDB() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection conexaoDB = DriverManager.getConnection(dbURL, username, password);

        if (conexaoDB != null) {
            return conexaoDB;
        } else {
            throw new RuntimeException("Ops! Erro ao conectar com o banco de dados. :(");
        }
    }

    public static PreparedStatement prepararSQL(String sql) throws SQLException, ClassNotFoundException {
        return conexaoDB().prepareStatement(sql);
    }

    public void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("Estado do SQL: " + ((SQLException) e).getSQLState());
                System.err.println("Codigo do ERRO: " + ((SQLException) e).getErrorCode());
                System.err.println("Messagem: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Causa: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
