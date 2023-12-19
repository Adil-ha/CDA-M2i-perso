package org.example.ihm;


import org.example.models.Person;
import org.example.service.PersonService;

import java.util.List;
import java.util.Scanner;

public class ConsoleIhm {
    private final PersonService personService;
    private final Scanner scanner;

    public ConsoleIhm(){
        this.personService = new PersonService();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
            int choice;
            do {
                displayMenu();
                System.out.println("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        createPerson();
                        break;
                    case 2:
                        displayAllPersons();
                        break;
                    case 3:
                        displayPersonById();
                        break;
                    case 4:
                        UpdatePerson();
                        break;
                    case 5:
                        deletePerson();
                        break;
                    case 0:
                        System.out.println("Exiting the application. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 0);

    }

    private void displayMenu() {
        System.out.println("===== Menu =====");
        System.out.println("1. Add Person");
        System.out.println("2. Display All Person");
        System.out.println("3. Display Students by id");
        System.out.println("4. Update Person");
        System.out.println("5. Delete Person");
        System.out.println("0. Exit");
        System.out.println("================");
    }

    private void createPerson(){
        System.out.println("Merci de saisir le nom");
        String lastName = scanner.nextLine();

        System.out.println("Merci de saisir le prénom");
        String firstName = scanner.nextLine();

        personService.createPerson(firstName,lastName);
    }

    private void displayAllPersons(){
        System.out.println("Liste de toutes les personnes :");
        List<Person> allPersons = personService.getAllPersons();
        for (Person person : allPersons){
            System.out.println(person);
        }
    }

    private void displayPersonById(){
        System.out.println("Merci de saisir l'id de la personne :");
        int idPerson = scanner.nextInt();
        System.out.println(personService.getPerson(idPerson));
    }

    private void UpdatePerson() {
            System.out.println("Merci de saisir l'id de la personne à mettre à jour :");
            int idPerson = scanner.nextInt();
            scanner.nextLine();


            Person existingPerson = personService.getPerson(idPerson);

            if (existingPerson != null) {
                System.out.println("Person details to update:");
                System.out.println(existingPerson);

                System.out.println("Merci de saisir le nouveau nom :");
                String newLastName = scanner.nextLine();

                System.out.println("Merci de saisir le nouveau prénom  :");
                String newFirstName = scanner.nextLine();

                if (!newLastName.isEmpty()) {
                    existingPerson.setLastName(newLastName);
                }
                if (!newFirstName.isEmpty()) {
                    existingPerson.setFirstName(newFirstName);
                }

                if (personService.updatePerson(existingPerson)) {
                    System.out.println("Personne mise à jour avec succès :");
                    System.out.println(personService.getPerson(idPerson));
                } else {
                    System.out.println("Échec de la mise à jour de la personne.");
                }
            } else {
                System.out.println("Personne non trouvée avec l'ID : " + idPerson);
            }

    }

    private void deletePerson(){
        System.out.println("Merci de saisir l'id de la personne à supprimer :");
        int idPerson = scanner.nextInt();
        if (personService.deletePerson(idPerson)){
            System.out.println("Personne "+idPerson +" supprimer avec succés");
        }else {
            System.out.println("Échec de la suppression de la personne.");
        }



    }

}
