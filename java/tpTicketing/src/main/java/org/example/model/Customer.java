package org.example.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.exception.CustomFormatException;

import java.util.List;
import java.util.regex.Pattern;

@Data
@AllArgsConstructor
public class Customer {
    private int id;
    private String firstname;

    private String lastname;

    private String email;

    private List<Event> eventsTicket;

    public Customer() {
    }

    public Customer(String lastname , String firstname,  String email) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
    }


    public void setEmail(String email) throws CustomFormatException {
        String pattern = "^([a-zA-Z0-9_.-]+)@([a-z0-9-]+\\.?[a-z0-9-]+)\\.([a-z]{2,6})$";
        if(!Pattern.matches(pattern, email)) {
            throw new CustomFormatException("Not correct email");
        }
        this.email = email;
    }


}
