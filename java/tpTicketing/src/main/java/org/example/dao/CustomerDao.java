package org.example.dao;

import org.example.exception.CustomFormatException;
import org.example.model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao extends BaseDao<Customer> {
    public CustomerDao(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Customer customer) throws SQLException {
        String request = "INSERT INTO T_CLIENT (last_name, first_name, email) VALUES (?, ?, ?)";
        try (PreparedStatement statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, customer.getLastname());
            statement.setString(2, customer.getFirstname());
            statement.setString(3, customer.getEmail());

            int nbRow = statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if(resultSet.next()){
                customer.setId(resultSet.getInt(1));
            }
            return nbRow == 1;
        }
    }

    @Override
    public boolean update(Customer customer) throws SQLException {
        String request = "UPDATE T_CLIENT SET last_name=?, first_name=?, email=? WHERE id=?";
        try (PreparedStatement statement = _connection.prepareStatement(request)) {
            statement.setString(1, customer.getLastname());
            statement.setString(2, customer.getFirstname());
            statement.setString(3, customer.getEmail());
            statement.setInt(4, customer.getId());

            int nbRow = statement.executeUpdate();
            return nbRow == 1;
        }
    }

    @Override
    public boolean delete(Customer customer) throws SQLException {
        String request = "DELETE FROM T_CLIENT WHERE id=?";
        try (PreparedStatement statement = _connection.prepareStatement(request)) {
            statement.setInt(1, customer.getId());

            int nbRow = statement.executeUpdate();
            return nbRow == 1;
        }
    }

    @Override
    public Customer get(int id) throws SQLException, CustomFormatException {
        String request = "SELECT * FROM T_CLIENT WHERE id=?";
        try (PreparedStatement statement = _connection.prepareStatement(request)) {
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getInt("id"));
                customer.setLastname(resultSet.getString("last_name"));
                customer.setFirstname(resultSet.getString("first_name"));
                customer.setEmail(resultSet.getString("email"));
                return customer;
            } else {
                return null;
            }
        }
    }

    @Override
    public List<Customer> get() throws SQLException, CustomFormatException {
        List<Customer> customers = new ArrayList<>();
        String request = "SELECT * FROM T_CLIENT";
        try (PreparedStatement statement = _connection.prepareStatement(request)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getInt("id"));
                customer.setLastname(resultSet.getString("last_name"));
                customer.setFirstname(resultSet.getString("first_name"));
                customer.setEmail(resultSet.getString("email"));
                customers.add(customer);
            }
        }
        return customers;
    }
}


