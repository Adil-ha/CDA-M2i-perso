package org.example.dao;


public interface GenericDAO<T> {

    void create(T entity);

    T getById(Long agencyId);
}
