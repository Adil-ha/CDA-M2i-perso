package org.example.dao;

import org.example.entity.Command;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;

public class CommandDao {
    private SessionFactory sessionFactory;

    public CommandDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createCommand(Command command) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
            session.save(command);
            tx.commit();
            session.close();

    }

    public List<Command> getAllCommands() {
        Session session = sessionFactory.openSession();
        Query<Command> query = session.createQuery("FROM Command", Command.class);
        List<Command> commands = query.getResultList();
        session.close();
        return commands;
    }

    public List<Command> getCommandsOfTheDay() {
        Session session = sessionFactory.openSession();
        Query<Command> query = session.createQuery("FROM Command WHERE orderDate = :today", Command.class);
        query.setParameter("today", LocalDate.now());
        List<Command> commands = query.getResultList();
        session.close();
        return commands;
    }
}
