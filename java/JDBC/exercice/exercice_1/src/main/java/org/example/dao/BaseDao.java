package org.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao<T> {
    protected Connection _connection;

    protected PreparedStatement statement;

    protected String request;

    protected ResultSet resultSet;

    protected BaseDao(Connection connection){
        _connection = connection;
    }



    public abstract boolean addStudent(T element) throws SQLException;
    public abstract List<T> getAllStudents(T element) throws SQLException;
    public abstract List<T> getStudentsByClass(T element) throws SQLException;
    public abstract List<T> getStudentsByLastName(T element) throws SQLException;
    public abstract boolean deleteStudent(T element) throws SQLException;
}
