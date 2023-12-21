package org.example.dao;

import org.example.exception.CustomFormatException;
import org.example.model.Place;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlaceDao extends BaseDao<Place>{
    public PlaceDao(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Place element) throws SQLException{
        request = "INSERT INTO T_PLACE  (name ,address ,capacity ) VALUES (?,?,?)";
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1,element.getName());
        statement.setString(2,element.getAddress());
        statement.setInt(3,element.getCapacity());
        int nbRow = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if(resultSet.next()){
            element.setId(resultSet.getInt(1));
        }
        return nbRow == 1;
    }

    @Override
    public boolean update(Place element) throws SQLException {
        request = "UPDATE T_PLACE SET name=?, address=?, capacity=? WHERE id=?";
        statement = _connection.prepareStatement(request);
        statement.setString(1, element.getName());
        statement.setString(2, element.getAddress());
        statement.setInt(3, element.getCapacity());
        statement.setInt(4, element.getId());

        int nbRow = statement.executeUpdate();
        return nbRow == 1;
    }

    @Override
    public boolean delete(Place element) throws SQLException {
        request = "DELETE FROM T_PLACE WHERE id=?";
        statement = _connection.prepareStatement(request);
        statement.setInt(1, element.getId());

        int nbRow = statement.executeUpdate();
        return nbRow == 1;
    }



    @Override
    public Place get(int id) throws SQLException, CustomFormatException {
        request = "SELECT * FROM T_PLACE WHERE id=?";
        statement = _connection.prepareStatement(request);
        statement.setInt(1, id);

        resultSet = statement.executeQuery();

        if (resultSet.next()) {
            Place place = new Place();
            place.setId(resultSet.getInt("id"));
            place.setName(resultSet.getString("name"));
            place.setAddress(resultSet.getString("address"));
            place.setCapacity(resultSet.getInt("capacity"));
            return place;
        } else {
            return null;
        }
    }
    @Override
    public List<Place> get() throws SQLException, CustomFormatException {
        List<Place> places = new ArrayList<>();
        request = "SELECT * FROM T_PLACE";
        statement = _connection.prepareStatement(request);

        resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Place place = new Place();
            place.setId(resultSet.getInt("id"));
            place.setName(resultSet.getString("name"));
            place.setAddress(resultSet.getString("address"));
            place.setCapacity(resultSet.getInt("capacity"));
            places.add(place);
        }

        return places;
    }



}
