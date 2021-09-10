package br.com.fabricaprogramador.pesistence.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection() {
        try {
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/fabricaweb", "postgres", "qwer");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
