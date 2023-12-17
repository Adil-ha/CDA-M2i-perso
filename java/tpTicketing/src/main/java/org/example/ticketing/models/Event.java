package org.example.ticketing.models;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class Event {

    private static int count;

    private int id;

    private String name;

    private LocalDate date;

    private LocalTime hours;

    private Place place;

    private float price;

    private int numberOfTicketsSold;

    public Event(String name, LocalDate date, LocalTime hours, Place place, float price, int numberOfTicketsSold) {
        this.id = ++count;
        this.name = name;
        this.date = date;
        this.hours = hours;
        this.place = place;
        this.price = price;
        this.numberOfTicketsSold = numberOfTicketsSold;
    }

    public boolean checkTicketAvailability(){
        return numberOfTicketsSold < place.getCapacity();
    }

    public void sellTicket(){
        if (checkTicketAvailability()){
            numberOfTicketsSold++;
            System.out.println("Billet vendu avec succès pour " + name);
        }else{
            System.out.println("Désolé, les billets sont épuisés pour " + name);
        }
    }

    public void cancelSellTickect(){
        if (numberOfTicketsSold > 0){
            numberOfTicketsSold--;
            System.out.println("Annulation de la vente de billet pour " + name);
        }else{
            System.out.println("Aucun billet à annuler pour " + name);
        }
    }
}
