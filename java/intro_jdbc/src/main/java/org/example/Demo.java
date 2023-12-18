package org.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo {
    public static void main(String[] args) {
        try (Connection connection = DatabaseSingleton.getConnection();
             Statement stm = connection.createStatement()) {

            ResultSet resultSet = stm.executeQuery("SELECT * FROM user");

            while (resultSet.next()) {
                int rsId = resultSet.getInt(1);
                String rsUsername = resultSet.getString(2);
                String rsEmail = resultSet.getString("email");
                int rsConnectionNumber = resultSet.getInt("connectionNumber");

                System.out.printf("%d : %s %s - %d\n", rsId, rsUsername, rsEmail, rsConnectionNumber);
            }

            resultSet.close();

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
