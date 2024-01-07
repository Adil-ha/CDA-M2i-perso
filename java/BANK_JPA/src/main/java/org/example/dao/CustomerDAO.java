package org.example.dao;

import org.example.model.Customer;

import javax.persistence.EntityManagerFactory;

public class CustomerDAO extends GenericDAOImpl<Customer> {

    public CustomerDAO(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory, Customer.class);
    }
}