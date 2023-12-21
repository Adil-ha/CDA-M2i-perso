package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.enumBank.TransactionType;

@Data
@AllArgsConstructor
public class Operation {
    private int id;
    private double amount;
    private TransactionType transactionType;
    private BankAccount account;

    public Operation(){
    }

    public void setAccount(BankAccount account) {
        this.account = account;
    }
}


