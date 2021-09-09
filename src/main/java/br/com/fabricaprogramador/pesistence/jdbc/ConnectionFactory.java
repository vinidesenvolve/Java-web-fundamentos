package br.com.fabricaprogramador.pesistence.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/fabricaweb", "postgres", "qwer");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
