package org.example.dao;

import org.example.models.Operation;

import java.sql.Connection;
import java.sql.SQLException;


public class OperationDAO extends BaseDAO<Operation> {

    public OperationDAO(Connection connection) {
        super(connection);
    }


    public boolean save(Operation operation) throws SQLException {
        String query = "INSERT INTO T_TRANSACTION (transaction_type, amount, account_id) VALUES (?, ?, ?)";
        statement = _connection.prepareStatement(query);
        statement.setString(1, operation.getTransactionType().toString());
        statement.setDouble(2, operation.getAmount());
        statement.setInt(3, operation.getAccount().getId());
        int rowsAffected = statement.executeUpdate();
        return rowsAffected > 0;
    }


}