package com.example.exercice1.dao;

import com.example.exercice1.model.Product;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ProducDao extends Repository<Product> {

    public ProducDao() {
    }

    public boolean create(Product o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.save(o);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    public boolean update(Product o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.update(o);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    public boolean delete(Long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            Product product = session.get(Product.class, id);
            session.delete(product);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }


    public Product findById(Long id) {
        Product product = null;
        session = sessionFactory.openSession();
        try {
            product = session.get(Product.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return product;
    }

    public List<Product> findAll() {
        List<Product> productList = null;
        session = sessionFactory.openSession();
        try {
            Query<Product> productQuery = session.createQuery("from Product", Product.class);
            productList = productQuery.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return productList;
    }
}

