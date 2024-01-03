package demo;

import entity.Person;

import javax.persistence.*;
import java.util.List;

public class Demo2 {

    public static void main() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo_jpa");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transac = em.getTransaction();

        transac.begin();
    /*    Person person = null;
        try {
            person = em.getReference(Person.class, 1L);
            //System.out.println(person);
        } catch (EntityNotFoundException ex) {
            System.out.println("Entity non trouvé");
        }

        // Recupération par Query
        System.out.println("Recupération par Query : ");
        // singleResult :
        Query query = em.createQuery("select p from Person p where p.nom = 'Jim'",Person.class);
        Person person2 = (Person) query.getSingleResult();
        System.out.println(person2);

        // resultList
        Query query1 = em.createQuery("select p from Person p where p.id > 3");
        List<Person> personList = query1.getResultList();

        for (Person p: personList) {
            System.out.println("person : " + p.getNom());
        }


        // Paramètres nommés :
        Query query2 = em.createQuery("select p from Person p where p.id > :id");
        query2.setParameter("id",3L);
        List<Person> personList2 = query2.getResultList();

        for (Person p: personList2) {
            System.out.println("person trouvé avec parametre nomme : " + p.getNom());
        }


        System.out.println("Modifier une occurrence : ");

        Person person4 = em.find(Person.class,4L);
        person4.setNom("Jim");
        person4.setPrenom("Paul");

        transac.commit();
        person4 = em.find(Person.class,4L);
        System.out.println("Person : " + person4);*/


        System.out.println("Rollback : ");
        Person person6 = new Person("Jim","Paul");
        em.persist(person6);
        if(person6.getId() == 11L){
            System.out.println("person rollback " +  person6.getId());
            transac.rollback();
        }else{
            em.getTransaction().commit();
            System.out.println("person " +  person6.getId());
        }


        System.out.println("NativeQuery : ");
        List<Person> personList = em.createNativeQuery("SELECT * FROM person", Person.class).getResultList();
        for (Person p :personList) {
            System.out.println("p : " + p);
        }

        em.close();
        emf.close();











        em.close();
        emf.close();

    }


}
