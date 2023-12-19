package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class BankAccount {
    private int id;
    private double balance;
    private Client client;
    private List<Operation> operations;

    public BankAccount(){

    }

    public BankAccount(Client client){
        this.client = client;
    }
}


