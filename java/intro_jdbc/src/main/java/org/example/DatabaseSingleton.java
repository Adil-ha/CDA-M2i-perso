
package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseSingleton {

    private static volatile Connection connection;
    private static final String PROPERTIES_FILE_PATH = "C:/Users/hanou/Desktop/CDA-M2i-perso/java/intro_jdbc/src/main/java/org/example/conf.properties";

    private DatabaseSingleton() {
        // private constructor to prevent instantiation
    }

    public static Connection getConnection() throws SQLException, IOException {
        if (connection == null || connection.isClosed()) {
            synchronized (DatabaseSingleton.class) {
                if (connection == null || connection.isClosed()) {
                    initializeConnection();
                }
            }
        }
        return connection;
    }

    private static void initializeConnection() throws SQLException, IOException {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream(PROPERTIES_FILE_PATH)) {
            props.load(fis);
        }

        String jdbcUrl = props.getProperty("jdbc.url");
        String jdbcUser = props.getProperty("jdbc.login");
        String jdbcPassword = props.getProperty("jdbc.password");

        connection = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
    }
}
