package org.example.service;

import com.mysql.cj.xdevapi.Client;
import jdk.jshell.spi.ExecutionControl;
import org.example.dao.CustomerDao;
import org.example.dao.EventDao;
import org.example.dao.PlaceDao;
import org.example.exception.CustomFormatException;
import org.example.model.Customer;
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
            throw new RuntimeException();
        }
    }

    public boolean addClient(String lastName, String firstname, String email){
        Customer customer = new Customer(lastName, firstname, email);

        try{
           return customerDao.save(customer);

        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    public boolean updateClient(int clientId, String newLastName, String newFirstName, String newEmail) {
        try {
            Customer existingCustomer = customerDao.get(clientId);

            if (existingCustomer != null) {
                existingCustomer.setLastname(newLastName);
                existingCustomer.setFirstname(newFirstName);
                existingCustomer.setEmail(newEmail);

                return customerDao.update(existingCustomer);
            } else {
                return false;
            }
        } catch (SQLException e) {

            throw new RuntimeException();
        } catch (CustomFormatException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteClient(int clientId) {
        try {
            Customer existingCustomer = customerDao.get(clientId);

            if (existingCustomer != null) {
                return customerDao.delete(existingCustomer);
            } else {
                return false;
            }
        } catch (SQLException | CustomFormatException e) {

            throw new RuntimeException();
        }
    }

    public boolean buyTickets(int clientId, int eventId, int numberOfTickets) {
        try {
            connection.setAutoCommit(false);
            Customer customer = customerDao.get(clientId);
            Event event = eventDao.get(eventId);

            if (customer != null && event != null) {
                if (eventDao.buyTickets(event, numberOfTickets)) {
                    customerDao.associateTicketsWithCustomer(customer, event, numberOfTickets);
                    connection.commit();
                    return true;
                }
            }

            connection.rollback();
            return false;
        } catch (SQLException | CustomFormatException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException rollbackException) {
                    rollbackException.printStackTrace();
                }
            }
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.setAutoCommit(true);
                } catch (SQLException closeException) {
                    closeException.printStackTrace();
                }
            }
        }
    }

    public boolean cancelTickets(int clientId, int eventId, int numberOfTickets) {
        try {
            connection.setAutoCommit(false);

            Customer customer = customerDao.get(clientId);
            Event event = eventDao.get(eventId);

            if (customer != null && event != null) {
                if (eventDao.cancelTickets(event, numberOfTickets)) {
                    customerDao.disassociateTicketsWithCustomer(customer, event, numberOfTickets);
                    connection.commit();
                    return true;
                }
            }

            connection.rollback();
            return false;
        } catch (SQLException | CustomFormatException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException rollbackException) {
                    rollbackException.printStackTrace();
                }
            }
            throw new RuntimeException();
        } finally {
            if (connection != null) {
                try {
                    connection.setAutoCommit(true);
                } catch (SQLException closeException) {
                    closeException.printStackTrace();
                }
            }
        }
    }



    public static void close(){
        DatabaseManager.closeConnection();
    }
}
