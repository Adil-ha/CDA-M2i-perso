package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Client {
    private int id;
    private String lastName;
    private String firstName;
    private List<BankAccount> accounts;
    private String phoneNumber;

    public Client(){

    }

    public Client(String lastName, String firstName) {

        this.lastName = lastName;
        this.firstName = firstName;

    }

}
