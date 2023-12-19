package org.example.ihm;

import org.example.models.BankAccount;
import org.example.service.BankService;

import java.util.Scanner;

public class ConsoleIHM {

    private static BankService bankService = new BankService();

    private static Scanner scanner = new Scanner(System.in);

    public void start() {
            int choice;
            do {
                displayMenu();
                System.out.println("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        createClient();
                        break;
                    case 2:
                        createDeposit();
                        break;
                    case 3 :
                        createWithdrawal();
                        break;
                    case 4 :
                        displayAccountDetails();
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
        System.out.println("1. Création de client et compte ");
        System.out.println("2. Depôt");
        System.out.println("3. Retrait");
        System.out.println("4. Affichage compte");
        System.out.println("5. Ajouter un compte à un client");
        System.out.println("6. Voir tout les comptes d'un client");
        System.out.println("7. Création de client");
        System.out.println("0. Exit");
        System.out.println("================");
    }

    public void createClient(){
        System.out.println("Merci de saisir le nom");
        String lastName = scanner.nextLine();
        System.out.println("Merci de saisir le prenom");
        String firstname = scanner.nextLine();
        System.out.println("Merci de saisir le numero de telephone");
        String phoneNumber = scanner.nextLine();

        if (bankService.addClientWithAccount(lastName,firstname,phoneNumber)){
            System.out.println("Client ajouter avec succés");
        }else {
            System.out.println("Erreur");
        }

    }

    public void createDeposit(){
        System.out.println("Merci de saisir le n° compte");
        int accountNumber = scanner.nextInt();
        System.out.println("Merci de saisir le montant à deposé");
        double ammontDeposit = scanner.nextDouble();

        bankService.deposit(accountNumber,ammontDeposit);
    }

    public void createWithdrawal() {
        System.out.println("Merci de saisir le n° compte");
        int accountNumber = scanner.nextInt();
        System.out.println("Merci de saisir le montant à retirer");
        double amountWithdrawal = scanner.nextDouble();

        if (bankService.withdraw(accountNumber, amountWithdrawal)) {
            System.out.println("Retrait effectué avec succès");
        } else {
            System.out.println("Erreur lors du retrait");
        }
    }

    public void displayAccountDetails() {
        System.out.println("Merci de saisir le n° compte");
        int accountNumber = scanner.nextInt();

        BankAccount account = bankService.getAccountByNumber(accountNumber);

        if (account != null) {
            System.out.println("Détails du compte:");
            System.out.println("ID: " + account.getId());
            System.out.println("Solde: " + account.getBalance());
            System.out.println("Client: " + account.getClient().getFirstName() + " " + account.getClient().getLastName());
        } else {
            System.out.println("Le compte n'existe pas.");
        }
    }


}
