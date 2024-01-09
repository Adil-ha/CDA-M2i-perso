package org.example.dao;

import org.example.model.Account;

import javax.persistence.EntityManagerFactory;

public class AccountDAO extends GenericDAOImpl<Account> {

    public AccountDAO(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory, Account.class);
    }
}