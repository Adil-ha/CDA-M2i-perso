package com.example.exercice1.dao;

import com.example.exercice1.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;

public class ProducDao {

    protected StandardServiceRegistry registre;

    protected SessionFactory sessionFactory;

    protected Session session;

    public ProducDao() {
        registre = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registre).buildMetadata().buildSessionFactory();
    }

    public boolean create(Product o){
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        return true;
    }


    public Product findById(Long id) {
        Product produit = null;
        session = sessionFactory.openSession();
        produit = (Product) session.get(Product.class, id);
        session.close();
        return produit;
    }


    public List<Product> findAll() {
        List<Product> produitList = null;
        session = sessionFactory.openSession();
        Query<Product> produitQuery = session.createQuery("from Product");
        produitList = produitQuery.list();
        session.close();
        return produitList;
    }


    public boolean deleteProduct(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        if (product != null) {
            session.delete(product);
        }
        session.getTransaction().commit();
        session.close();
        return true;
    }


}
