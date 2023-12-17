package org.example;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Demo {
    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("C:/Users/hanou/Desktop/CDA-M2i-perso/java/intro_jdbc/src/main/java/org/example/conf.properties")) {
            props.load(fis);
        }

        String jdbcUrl = props.getProperty("jdbc.url");
        String jdbcUser = props.getProperty("jdbc.login");
        String jdbcPassword = props.getProperty("jdbc.password");

        try (Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
             Statement stm = connection.createStatement()) {


                // Ajout user dans la table user

//            String strSql = "INSERT INTO user (username, email, password, connectionNumber) " +
//                    "VALUES ('Bourne', 'bourne@gmail.com', 'motdepasse6', 3)";
//
//            stm.executeUpdate(strSql);

            ResultSet resultSet = stm.executeQuery("SELECT * FROM user");


            while (resultSet.next()) {
                int rsId = resultSet.getInt(1);
                String rsUsername = resultSet.getString(2);
                String rsEmail = resultSet.getString("email");
                int rsConnectionNumber = resultSet.getInt("connectionNumber");

                System.out.printf("%d : %s %s - %d\n", rsId, rsUsername, rsEmail, rsConnectionNumber);
            }

            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
