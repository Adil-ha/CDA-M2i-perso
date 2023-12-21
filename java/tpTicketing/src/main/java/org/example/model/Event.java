package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.exception.CustomFormatException;
import org.example.exception.TicketSoldException;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDate;
import java.util.Date;


@Data
@AllArgsConstructor
public class Event {

    private int id;

    private String name;

    private LocalDate date;

    private LocalTime time;

    private Place place;

    private double price;

    private int ticketsSoldNumber;

    public Event() {
    }


    public Event(String name, LocalDate date, LocalTime time, Place place, double price) throws CustomFormatException {
        this();
        setName(name);
        setDate(date);
        setTime(time);
        setPlace(place);
        setPrice(price);
        ticketsSoldNumber = 0;
    }

    public Event(String name, Date date, String time, Place place, double price) {
    }


    public void setName(String name) throws CustomFormatException {
        if(name.length() > 2) {
            this.name = name;
        }else {
            throw new CustomFormatException("name should be gt 2 char");
        }
    }


    public void setDate(LocalDate date) throws CustomFormatException {
        if (date.isAfter(LocalDate.now())) {
            this.date = date;
        } else {
            throw new CustomFormatException("Date should be after the current date");
        }
    }

    public void setTime(LocalTime time) throws CustomFormatException {
        // Ajoutez des vérifications de plages horaires si nécessaire
        this.time = time;
    }



    public void setPrice(double price) throws CustomFormatException {
        if(price >= 0) {
            this.price = price;
        }
        else {
            throw new CustomFormatException("price should be positive");
        }
    }

    public boolean checkTicketSoldPossibility() {
        return ticketsSoldNumber < place.getCapacity();
    }

    public void cancelTicket() {
        if(ticketsSoldNumber == 0) {
            throw new TicketSoldException("No Ticket available to cancel");
        }
        ticketsSoldNumber--;
    }

    public void soldTicket() {
        if(!checkTicketSoldPossibility()){
            throw new TicketSoldException("Ticket sold out");
        }
        ticketsSoldNumber++;
    }


}

