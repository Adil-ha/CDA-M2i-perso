package org.example.dao;

import org.example.models.Client;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO extends BaseDAO<Client> {

    public ClientDAO(Connection connection) {
        super(connection);
    }


    public boolean save(Client client) throws SQLException {
        String query = "INSERT INTO T_CLIENT (last_name, first_name, phone_number) VALUES (?, ?, ?)";
        statement = _connection.prepareStatement(query);
        statement.setString(1, client.getLastName());
        statement.setString(2, client.getFirstName());
        statement.setString(3, client.getPhoneNumber());
        int rowsAffected = statement.executeUpdate();
        return rowsAffected > 0;
    }




    public Client getClientById(int id) throws SQLException {
        String query = "SELECT * FROM T_CLIENT WHERE client_id=?";
        statement = _connection.prepareStatement(query);
        statement.setInt(1, id);
        resultSet = statement.executeQuery();
        Client client = null;
        if (resultSet.next()) {
            client = new Client(
                    resultSet.getInt("client_id"),
                    resultSet.getString("last_name"),
                    resultSet.getString("first_name"),
                    resultSet.getString("phone_number")
            );
        }
        return client;
    }



}
