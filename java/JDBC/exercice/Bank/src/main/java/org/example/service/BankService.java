package org.example.service;

import org.example.dao.BankAccountDAO;
import org.example.dao.ClientDAO;
import org.example.models.BankAccount;
import org.example.models.Client;
import org.example.utils.DataBaseManager;

import java.sql.Connection;

import java.sql.SQLException;

public class BankService {
    private  ClientDAO clientDAO;
    private BankAccountDAO bankAccountDAO;
    private Connection connection;

    public BankService() {
        try {
            connection = DataBaseManager.getInstance().getConnection();
            clientDAO = new ClientDAO(connection);
            bankAccountDAO = new BankAccountDAO(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public boolean addClient(String lastName,String firstname,String phoneNumber) {
        Client client = new Client();
        client.setLastName(lastName);
        client.setFirstName(firstname);
        client.setPhoneNumber(phoneNumber);

        try {

            return clientDAO.save(client);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




    public Client getClientById(int clientId) {
        try {
            return clientDAO.getClientById(clientId);
        } catch (SQLException e) {
            // Handle the exception or log it
            e.printStackTrace();
            return null;
        }
    }


}

