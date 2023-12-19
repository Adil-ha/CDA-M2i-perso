package org.example.dao;

import org.example.models.BankAccount;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BankAccountDAO extends BaseDAO<BankAccount> {

    public BankAccountDAO(Connection connection) {
        super(connection);
    }


    public boolean save(BankAccount bankAccount) throws SQLException {
        String query = "INSERT INTO T_BANK_ACCOUNT (client_id) VALUES (?)";
        statement = _connection.prepareStatement(query);
        statement.setInt(1, bankAccount.getClient().getId());
        int rowsAffected = statement.executeUpdate();
        return rowsAffected > 0;
    }










}
