package org.example.dao;

import java.util.List;

public interface GenericDAO<T> {

    boolean addEntity(T entity);

    List<T> getAllEntities();

    boolean deleteEntity(Long entityId);

    boolean updateEntity(T entity);
}