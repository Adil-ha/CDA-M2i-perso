package org.example.dao;

import org.example.models.BankAccount;
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
        statement = _connection.prepareStatement(query, statement.RETURN_GENERATED_KEYS);
        statement.setString(1, client.getLastName());
        statement.setString(2, client.getFirstName());
        statement.setString(3, client.getPhoneNumber());

        int rowsAffected = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();

        if(resultSet.next()) {
            client.setId(resultSet.getInt(1));
        }
        return rowsAffected > 0;
    }

    public Client getClientById(int clientId) throws SQLException {
        String query = "SELECT * FROM T_CLIENT WHERE client_id = ?";
        statement = _connection.prepareStatement(query);
        statement.setInt(1, clientId);

        resultSet = statement.executeQuery();

        if (resultSet.next()) {
            Client client = new Client();
            client.setId(resultSet.getInt("client_id"));
            client.setLastName(resultSet.getString("last_name"));
            client.setFirstName(resultSet.getString("first_name"));
            client.setPhoneNumber(resultSet.getString("phone_number"));

            return client;
        } else {

            return null;
        }
    }


    public boolean delete(int clientId) throws SQLException {
        String query = "DELETE FROM T_CLIENT WHERE client_id = ?";
        statement = _connection.prepareStatement(query);
        statement.setInt(1, clientId);

        int rowsAffected = statement.executeUpdate();
        return rowsAffected > 0;
    }





}
