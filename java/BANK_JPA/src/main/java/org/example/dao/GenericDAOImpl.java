package org.example.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class GenericDAOImpl<T> implements GenericDAO<T> {

    private final EntityManagerFactory entityManagerFactory;
    private final Class<T> entityClass;

    public GenericDAOImpl(EntityManagerFactory entityManagerFactory, Class<T> entityClass) {
        this.entityManagerFactory = entityManagerFactory;
        this.entityClass = entityClass;
    }

    @Override
    public void create(T entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
    @Override
    public T getById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        T entity = null;

        try {
            entity = entityManager.find(entityClass, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }

        return entity;
    }
}

