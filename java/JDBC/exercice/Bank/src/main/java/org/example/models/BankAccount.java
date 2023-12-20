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
        this.balance = 0;
    }

    public BankAccount(int id, double balance){
        this.id = id;
        this.balance = balance;
    }

    public BankAccount(int id, double balance, Client client){
        this.id = id;
        this.balance = balance;
        this.client = client;
    }
}


