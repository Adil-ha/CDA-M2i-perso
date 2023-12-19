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
        String query = "INSERT INTO T_BANK_ACCOUNT (balance, client_id) VALUES (?, ?)";
        statement = _connection.prepareStatement(query);
        statement.setDouble(1, bankAccount.getBalance());
        statement.setInt(2, bankAccount.getClient().getId());
        int rowsAffected = statement.executeUpdate();
        return rowsAffected > 0;
    }

    public boolean updateBalance(BankAccount bankAccount) throws SQLException {
        String query = "UPDATE T_BANK_ACCOUNT SET balance=? WHERE account_id=?";
        statement = _connection.prepareStatement(query);
        statement.setDouble(1, bankAccount.getBalance());
        statement.setInt(2, bankAccount.getId());
        int rowsAffected = statement.executeUpdate();
        return rowsAffected > 0;
    }

    public BankAccount getBankAccountByAccountNumber(int accountNumber) throws SQLException {
        String query = "SELECT * FROM T_BANK_ACCOUNT WHERE account_id=?";
        statement = _connection.prepareStatement(query);
        statement.setInt(1, accountNumber);
        resultSet = statement.executeQuery();
        BankAccount bankAccount = null;
        if (resultSet.next()) {
            bankAccount = new BankAccount(
                    resultSet.getInt("account_id"),
                    resultSet.getDouble("balance")
            );
        }
        return bankAccount;
    }










}
