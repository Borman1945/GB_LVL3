package ru.geekbrains.java2.server.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDBServise {

    private ConnectionDBServise() {
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","postgres");
    }

}
