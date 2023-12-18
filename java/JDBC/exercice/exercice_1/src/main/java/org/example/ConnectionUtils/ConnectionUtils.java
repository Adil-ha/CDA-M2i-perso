package org.example.ConnectionUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
    private static ConnectionUtils instance;
    private Connection connection;

    private ConnectionUtils() {

    }

    public static synchronized ConnectionUtils getInstance() {
        if (instance == null) {
            instance = new ConnectionUtils();
        }
        return instance;
    }

    public Connection getMySQLConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            String url = "jdbc:mysql://localhost:3306/college";
            String username = "root";
            String password = "root";
            try {
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                System.err.println("Erreur lors de la connexion à la base de données.");
                throw e;
            }
        }
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Erreur lors de la fermeture de la connexion.");
            } finally {
                connection = null;
            }
        }
    }
}
