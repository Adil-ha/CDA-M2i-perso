package org.example.dao;

// TaskDAOImpl.java
import org.example.model.Task;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class TaskDAO  {
    private EntityManagerFactory emf;
    private EntityManager em;

    public TaskDAO() {
        emf = Persistence.createEntityManagerFactory("TODOLIST");
        em = emf.createEntityManager();
    }


    public void addTask(Task task) {
        em.getTransaction().begin();
        em.persist(task);
        em.getTransaction().commit();
    }


    public List<Task> getAllTasks() {
        TypedQuery<Task> query = em.createQuery("SELECT t FROM Task t", Task.class);
        return query.getResultList();
    }


    public void markTaskAsCompleted(Long taskId) {
        em.getTransaction().begin();
        Task task = em.find(Task.class, taskId);
        task.setCompleted(true);
        em.getTransaction().commit();
    }


    public void removeTask(Long taskId) {
        em.getTransaction().begin();
        Task task = em.find(Task.class, taskId);
        em.remove(task);
        em.getTransaction().commit();
    }
}

