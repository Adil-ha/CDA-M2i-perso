package org.example;

import org.example.utils.ConnectionUtils;

import java.sql.*;
import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        // test Connection

//        try {
//            Connection connection = ConnectionUtils.getMySQLConnection();
//            if (connection != null){
//                System.out.println("connection réussi");
//            }else{
//                System.out.println("connection echoué");
//            }
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//
//        }

        Scanner scaner = new Scanner(System.in);
        Connection connection = null;
        try{
            connection = ConnectionUtils.getMySQLConnection();
//

//            String request = "INSERT INTO person (first_name, last_name) VALUES (?, ?);";
//
//            PreparedStatement statement = connection.prepareStatement(request);
//
//            statement.setString(1,firstname);
//            statement.setString(2,lastname);
//
//            int rows = statement.executeUpdate();
//            System.out.println(rows + " ligne(s) insérée(s) avec succès.");

            //récuperation id
//            String request = "INSERT INTO person (first_name, last_name) VALUES (?, ?);";
//            PreparedStatement stm = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
//
//            stm.setString(1,firstname);
//            stm.setString(2,lastname);
//            int rows = stm.executeUpdate();
//            ResultSet resultSet = stm.getGeneratedKeys();
//            System.out.println(rows + " ligne(s) insérée(s) avec succès.");
//            if(resultSet.next()){
//                System.out.println(resultSet.getInt(1));
//            }

            // Avec une requte de lecture

            String request = "SELECT * FROM person;";
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(request);

            while (resultSet.next()) {
                int rsId = resultSet.getInt(1);
                String rsFirstname = resultSet.getString(2);
                String rsLastname = resultSet.getString(3);


                System.out.printf("%d : %s %s\n", rsId, rsFirstname, rsLastname);
            }

            resultSet.close();

        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            //fermer la connexion a la bdd
            if (connection!= null){
                try{
                    connection.close();
                }catch(SQLException e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
