package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionDB {
    private static final String URL = "jdbc:mysql://localhost:3306/tp_vendredi_swing";
    private static final String UTILISATEUR = "root";
    private static final String MOT_DE_PASSE = "root";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, UTILISATEUR, MOT_DE_PASSE);
    }
}

