package org.example.utils;

import org.example.dao.GenericDAO;
import org.example.dao.GenericDAOImpl;
import org.example.model.Account;
import org.example.model.Agency;
import org.example.model.Customer;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class IhmBank {

    private static EntityManagerFactory entityManagerFactory;
    private static GenericDAO<Agency> agencyDAO;
    private static GenericDAO<Customer> customerDAO;
    private static GenericDAO<Account> accountDAO;

    public IhmBank() {

    }

    public void run() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("banque_bdd");
        this.agencyDAO = new GenericDAOImpl<>(entityManagerFactory, Agency.class);
        this.customerDAO = new GenericDAOImpl<>(entityManagerFactory, Customer.class);
        this.accountDAO = new GenericDAOImpl<>(entityManagerFactory, Account.class);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("### Menu ###");
            System.out.println("1. Créer une agence");
            System.out.println("2. Créer un client");
            System.out.println("3. Créer un compte");
            System.out.println("4. Quitter");
            System.out.print("Choix : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createAgency(scanner);
                    break;
                case 2:
                    createCustomer(scanner);
                    break;
                case 3:
                    createAccount(scanner);
                    break;
                case 4:
                    System.out.println("Bye!");
                    entityManagerFactory.close();
                    System.exit(0);
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }

    private void createAgency(Scanner scanner) {
        System.out.print("Entrez l'adresse de l'agence : ");
        String address = scanner.nextLine();

        Agency agency = new Agency();
        agency.setAddress(address);

        agencyDAO.create(agency);

        System.out.println("Agence créée avec succès !");
    }

    private void createCustomer(Scanner scanner) {
        System.out.print("Entrez le nom du client : ");
        String lastName = scanner.nextLine();

        System.out.print("Entrez le prénom du client : ");
        String firstName = scanner.nextLine();

        System.out.print("Entrez la date de naissance du client (format dd.MM.yyyy) : ");
        String birthDateStr = scanner.nextLine();

        LocalDate birthDate = LocalDate.parse(birthDateStr, DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        Customer customer = new Customer();
        customer.setLastname(lastName);
        customer.setFirstname(firstName);
        customer.setDateBirth(birthDate);

        customerDAO.create(customer);

        System.out.println("Client créé avec succès !");
    }

    private void createAccount(Scanner scanner) {
        System.out.print("Entrez le libellé du compte : ");
        String wording = scanner.nextLine();

        System.out.print("Entrez l'IBAN du compte : ");
        String iban = scanner.nextLine();

        System.out.print("Entrez le solde initial du compte : ");
        double initialBalance = scanner.nextDouble();
        scanner.nextLine();

        Account account = new Account();
        account.setWording(wording);
        account.setIban(iban);
        account.setSold(initialBalance);

        System.out.print("Entrez l'ID de l'agence associée au compte : ");
        Long agencyId = scanner.nextLong();
        scanner.nextLine();

        Agency associatedAgency = agencyDAO.getById(agencyId);
        account.setAgency(associatedAgency);

        System.out.print("Entrez l'ID du client associé au compte : ");
        Long customerId = scanner.nextLong();
        scanner.nextLine();

        Customer associatedCustomer = customerDAO.getById(customerId);
        account.getCustomerList().add(associatedCustomer);

        accountDAO.create(account);

        System.out.println("Compte créé avec succès !");
    }



}

