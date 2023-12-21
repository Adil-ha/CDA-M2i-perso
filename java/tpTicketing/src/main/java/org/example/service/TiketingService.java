package org.example.service;

import jdk.jshell.spi.ExecutionControl;
import org.example.dao.CustomerDao;
import org.example.dao.EventDao;
import org.example.dao.PlaceDao;
import org.example.exception.CustomFormatException;
import org.example.model.Event;
import org.example.model.Place;
import org.example.util.DatabaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public class TiketingService {
    private CustomerDao customerDao;

    private PlaceDao placeDao;

    private EventDao eventDao;

    private Connection connection;

    public TiketingService(){
        connection = DatabaseManager.getConnection();
        customerDao = new CustomerDao(connection);
        placeDao = new PlaceDao(connection);
        eventDao = new EventDao(connection);
    }

    public boolean addPlace(String namePlace,String adressePlace,int capacity){
        Place place = new Place(namePlace, adressePlace, capacity);

        try{
            if (placeDao.save(place)){
                return true;
            }else{
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean updatePlace(int id, String newName, String newAddress, int newCapacity) {
        Place place = new Place(newName,newAddress,newCapacity);
        place.setId(id);
        try {
            return placeDao.update(place);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deletePlace(int placeId) {
        try {
            return placeDao.delete(new Place(placeId));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean addEvent(String name, LocalDate date, LocalTime time, int placeId, double price) {
        try {
            Place place = new Place();
            place.setId(placeId);

            Event event = new Event(name, date, time, place, price);

            return eventDao.save(event);
        } catch (SQLException | CustomFormatException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateEvent(int id, String newName, Date newDate, LocalTime newTime, int newPlaceId, double newPrice) {
        try {
            Place place = new Place();
            place.setId(newPlaceId);

            Event updatedEvent = new Event();
            updatedEvent.setId(id);
            updatedEvent.setName(newName);
            updatedEvent.setDate(newDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            updatedEvent.setTime(newTime);
            updatedEvent.setPlace(place);
            updatedEvent.setPrice(newPrice);

            return eventDao.update(updatedEvent);
        } catch (SQLException | CustomFormatException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteEvent(int eventId) {
        try {
            Event eventToDelete = eventDao.get(eventId);

            if (eventToDelete != null) {
                return eventDao.delete(eventToDelete);
            } else {
                System.out.println("Aucun événement trouvé avec l'ID : " + eventId);
                return false;
            }
        } catch (SQLException | CustomFormatException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Event> getAllEvents() {
        try {
            return eventDao.get();
        } catch (SQLException | CustomFormatException e) {
            throw new RuntimeException("Erreur lors de la récupération des événements : " + e.getMessage());
        }
    }


    public static void close(){
        DatabaseManager.closeConnection();
    }
}
