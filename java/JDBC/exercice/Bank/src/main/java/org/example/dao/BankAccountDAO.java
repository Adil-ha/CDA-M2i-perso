package org.example.dao;

import org.example.models.BankAccount;
import org.example.models.Client;

import java.sql.Connection;
import java.sql.SQLException;


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
        String query = "SELECT T_BANK_ACCOUNT.account_id, balance, last_name, first_name " +
                "FROM T_BANK_ACCOUNT " +
                "JOIN T_CLIENT ON T_BANK_ACCOUNT.client_id = T_CLIENT.client_id " +
                "WHERE T_BANK_ACCOUNT.account_id=?";

        statement = _connection.prepareStatement(query);
        statement.setInt(1, accountNumber);
        resultSet = statement.executeQuery();

        BankAccount bankAccount = null;
        if (resultSet.next()) {

            int accountId = resultSet.getInt("account_id");
            double balance = resultSet.getDouble("balance");

            String lastName = resultSet.getString("last_name");
            String firstName = resultSet.getString("first_name");

            Client client = new Client(lastName, firstName);
            bankAccount = new BankAccount(accountId, balance, client);
        }
        return bankAccount;
    }










}
