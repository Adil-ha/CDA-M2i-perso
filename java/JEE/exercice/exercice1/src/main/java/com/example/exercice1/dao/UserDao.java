package com.example.exercice1.dao;

import com.example.exercice1.model.User;
import org.hibernate.query.Query;

import java.util.List;

public class UserDao extends Repository<User> {

    public UserDao() {
        super();
    }

    @Override
    public boolean create(User user) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.save(user);
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

    public User getUserByUsername(String username) {
        session = sessionFactory.openSession();
        try {
            Query<User> query = session.createQuery("FROM User WHERE username = :username", User.class);
            query.setParameter("username", username);
            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean update(User user) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.update(user);
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

    @Override
    public boolean delete(Long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.delete(id);
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

    @Override
    public User findById(Long id) {
        User user = null;
        session = sessionFactory.openSession();
        try {
            user = session.get(User.class, (long) id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> userList = null;
        session = sessionFactory.openSession();
        try {
            Query<User> userQuery = session.createQuery("from User", User.class);
            userList = userQuery.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return userList;
    }
}

