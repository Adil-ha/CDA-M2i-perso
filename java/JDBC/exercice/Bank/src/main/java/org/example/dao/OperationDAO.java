package org.example.dao;

import org.example.models.Operation;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OperationDAO extends BaseDAO<Operation> {

    public OperationDAO(Connection connection) {
        super(connection);
    }


    public boolean save(Operation operation) throws SQLException {
        String query = "INSERT INTO T_TRANSACTION (transaction_type, amount) VALUES (?, ?)";
        statement = _connection.prepareStatement(query);
        statement.setString(1, operation.getTransactionType().toString());
        statement.setDouble(2, operation.getAmount());
        int rowsAffected = statement.executeUpdate();
        return rowsAffected > 0;
    }








}