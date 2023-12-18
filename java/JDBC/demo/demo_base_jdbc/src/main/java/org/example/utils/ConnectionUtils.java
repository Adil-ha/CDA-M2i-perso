package org.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
    public static Connection getMySQLConnection() throws SQLException {
        //avec MySql
        String url = "jdbc:mysql://localhost:3306/demo_jdbc";
        String username = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(url,username, password);
        return connection;

    }
}
