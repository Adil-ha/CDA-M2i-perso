package org.example.dao;

import org.example.model.Agency;

import javax.persistence.EntityManagerFactory;

public class AgencyDAO extends GenericDAOImpl<Agency> {

    public AgencyDAO(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory, Agency.class);
    }
}
