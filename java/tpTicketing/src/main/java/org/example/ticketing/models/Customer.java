package org.example.ticketing.models;

import lombok.Data;

import java.util.ArrayList;


@Data
public class Customer {

    private static int count;

    private int id;

    private String lastname;

    private String firstname;

    private String email;

    private ArrayList<Event> purshasedTickets;

    public Customer(String lastname, String firstname, String email) {
        this.id = ++count;
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.purshasedTickets = new ArrayList<>();
    }

    private void buyTicket(Event event){
        if (event.checkTicketAvailability()){
            purshasedTickets.add(event);
            event.sellTicket();
            System.out.println("Billet acheté avec succès pour " + event.getName());
        } else {
            System.out.println("Désolé, les billets sont épuisés pour " + event.getName());
        }
    }

    private void cancelBuyTicket(Event event){
        if (purshasedTickets.contains(event)){
            purshasedTickets.remove(event);
            event.cancelSellTickect();
            System.out.println("Annulation de l'achat de billet pour " + event.getName());
        }else{
            System.out.println("Aucun billet à annuler pour " + event.getName());
        }

    }
}
