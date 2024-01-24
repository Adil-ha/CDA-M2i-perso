package com.example.exercice1.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List; // Import List class

public abstract class Repository<T> {

    protected StandardServiceRegistry registre;

    protected SessionFactory sessionFactory;

    protected Session session;

    public Repository() {
        registre = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registre).buildMetadata().buildSessionFactory();

    }

    public abstract boolean create(T o);

    public abstract boolean update(T o);

    public abstract boolean delete(Long id);

    public abstract T findById(Long id);

    public abstract List<T> findAll();
}

