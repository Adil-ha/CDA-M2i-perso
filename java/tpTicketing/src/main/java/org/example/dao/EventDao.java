package org.example.dao;

import jdk.jshell.spi.ExecutionControl;
import org.example.exception.CustomFormatException;
import org.example.model.Event;
import org.example.model.Place;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EventDao extends BaseDao<Event> {
    public EventDao(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Event event) throws SQLException {
        String request = "INSERT INTO T_EVENT (name, date, time, place_id, price, tickets_sold) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = _connection.prepareStatement(request)) {
            statement.setString(1, event.getName());
            statement.setDate(2, java.sql.Date.valueOf(event.getDate()));
            statement.setTime(3, java.sql.Time.valueOf(event.getTime()));
            statement.setInt(4, event.getPlace().getId());
            statement.setBigDecimal(5, java.math.BigDecimal.valueOf(event.getPrice()));
            statement.setInt(6, event.getTicketsSoldNumber());

            int nbRow = statement.executeUpdate();
            return nbRow == 1;
        }
    }

    @Override
    public boolean update(Event event) throws SQLException {
        String request = "UPDATE T_EVENT SET name=?,date=?, time=?,place_id=?, price=?, tickets_sold=? WHERE id=?";
        try (PreparedStatement statement = _connection.prepareStatement(request)) {
            statement.setString(1, event.getName());
            statement.setDate(2, java.sql.Date.valueOf(event.getDate()));
            statement.setTime(3, java.sql.Time.valueOf(event.getTime()));
            statement.setInt(4, event.getPlace().getId());
            statement.setBigDecimal(5, java.math.BigDecimal.valueOf(event.getPrice()));
            statement.setInt(6, event.getTicketsSoldNumber());
            statement.setInt(7, event.getId());

            int nbRow = statement.executeUpdate();
            return nbRow == 1;
        }
    }

    @Override
    public boolean delete(Event event) throws SQLException {
        String request = "DELETE FROM T_EVENT WHERE id=?";
        try (PreparedStatement statement = _connection.prepareStatement(request)) {
            statement.setInt(1, event.getId());

            int nbRow = statement.executeUpdate();
            return nbRow == 1;
        }
    }

    @Override
    public Event get(int id) throws SQLException, CustomFormatException {
        String request = "SELECT * FROM T_EVENT WHERE id=?";
        try (PreparedStatement statement = _connection.prepareStatement(request)) {
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Event event = new Event();
                event.setId(resultSet.getInt("id"));
                event.setName(resultSet.getString("name"));
                event.setDate(resultSet.getDate("date").toLocalDate());
                event.setPrice(resultSet.getBigDecimal("price").doubleValue());
                event.setTicketsSoldNumber(resultSet.getInt("tickets_sold"));
                return event;
            } else {
                return null;
            }
        }
    }

    @Override
    public List<Event> get() throws SQLException, CustomFormatException {
        List<Event> events = new ArrayList<>();
        String request = "SELECT e.*, p.name AS place_name, e.time AS event_time " +
                "FROM T_EVENT e " +
                "JOIN T_PLACE p ON e.place_id = p.id";
        try (PreparedStatement statement = _connection.prepareStatement(request)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Event event = new Event();
                event.setId(resultSet.getInt("id"));
                event.setName(resultSet.getString("name"));
                event.setDate(resultSet.getDate("date").toLocalDate());
                event.setTime(resultSet.getTime("event_time").toLocalTime());
                event.setPlace(new Place(resultSet.getString("place_name")));
                event.setPrice(resultSet.getBigDecimal("price").doubleValue());
                event.setTicketsSoldNumber(resultSet.getInt("tickets_sold"));

                events.add(event);
            }
        }
        return events;
    }

    public boolean buyTickets(Event event, int numberOfTickets) throws SQLException {
        String request = "UPDATE T_EVENT SET tickets_sold = tickets_sold + ? WHERE id = ?";
        try (PreparedStatement statement = _connection.prepareStatement(request)) {
            statement.setInt(1, numberOfTickets);
            statement.setInt(2, event.getId());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        }
    }

    public boolean cancelTickets(Event event, int numberOfTickets) throws SQLException {
        String request = "UPDATE T_EVENT SET tickets_sold = GREATEST(0, tickets_sold - ?) WHERE id = ?";
        try (PreparedStatement statement = _connection.prepareStatement(request)) {
            statement.setInt(1, numberOfTickets);
            statement.setInt(2, event.getId());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        }
    }

}

