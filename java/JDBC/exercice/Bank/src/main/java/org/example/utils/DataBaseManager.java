package org.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseManager {
    private static final String URI = "jdbc:mysql://localhost:3306/BANK";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private static DataBaseManager instance;


    private DataBaseManager() {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static synchronized DataBaseManager getInstance() {
        if (instance == null) {
            instance = new DataBaseManager();
        }
        return instance;
    }


    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URI, USER, PASSWORD);
    }
}
