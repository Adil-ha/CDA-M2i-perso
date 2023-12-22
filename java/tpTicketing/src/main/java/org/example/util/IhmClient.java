package org.example.util;

import org.example.service.TiketingService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IhmClient {
    private TiketingService tiketingService = new TiketingService();
    private Scanner scanner = new Scanner(System.in);

    public void menuClient() {
        try {
            System.out.println("----------menu Client---------");
            System.out.println("1/ ajouter un Client");
            System.out.println("2/ modifier un Client");
            System.out.println("3/ supprimer un Client");
            System.out.println("4/ acheter un billet");
            System.out.println("5/ annuler un billet");
            System.out.println("6/ afficher la liste des billets d'un clients");
            System.out.println("0/ retourner au menu generale");
            System.out.println("entrer votre choix :");
            int entry = scanner.nextInt();
            switch (entry) {
                case 1:
                    addClient();
                    break;
                case 2:
                    updateClient();
                    break;
                case 3:
                    deleteClient();
                    break;
                case 4:
                     buyTickets(true);
                    break;
                case 5:
                     buyTickets(false);
                    break;
                case 6:
                    //todo
                    // displayTicket();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("entrer une valeur correspondant a un choix");
                    menuClient();
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("entrer une valeur numerique ");
            this.menuClient();
        }
    }

    public void addClient (){
        try {
            System.out.println("--------Ajouter CLient----------");
            System.out.println("entrer le nom du clien :");
            String lastname = scanner.next();

            System.out.println("entrer le prenom du client :");
            String firstname = scanner.next();

            System.out.println("entrer l'email du client : ");
            String email = scanner.next();


            if (tiketingService.addClient(lastname,firstname,email)){
                System.out.println("Client ajouter avec succés");
            }else {
                System.out.println("Erreur");
            }

            menuClient();
        }
        catch (InputMismatchException e) {
            System.out.println("entrer une valeur numerique ");
            menuClient();
        }
    }

    public void updateClient() {
        try {
            System.out.println("--------Modifier Client----------");
            System.out.println("Entrer l'ID du client à modifier :");
            int clientId = scanner.nextInt();

            System.out.println("Entrer le nouveau nom du client :");
            String newLastName = scanner.next();

            System.out.println("Entrer le nouveau prénom du client :");
            String newFirstName = scanner.next();

            System.out.println("Entrer le nouvel email du client : ");
            String newEmail = scanner.next();

            if (tiketingService.updateClient(clientId, newLastName, newFirstName, newEmail)) {
                System.out.println("Client mis à jour avec succès");
            } else {
                System.out.println("Erreur lors de la mise à jour du client");
            }
            menuClient();

        } catch (InputMismatchException e) {
            System.out.println("Entrer une valeur numérique ");
            menuClient();
        }
    }

    public void deleteClient() {
        try {
            System.out.println("--------Supprimer Client----------");
            System.out.println("Entrer l'ID du client à supprimer :");
            int clientId = scanner.nextInt();

            if (tiketingService.deleteClient(clientId)) {
                System.out.println("Client supprimé avec succès");
            } else {
                System.out.println("Erreur lors de la suppression du client");
            }

            menuClient();
        } catch (InputMismatchException e) {
            System.out.println("Entrer une valeur numérique ");
            menuClient();
        }
    }

    public void buyTickets(boolean purchase) {
        try {
            if (purchase) {
                System.out.println("---------Achat Billet -----------");
            } else {
                System.out.println("---------Annulation Billet -----------");
            }

//            displayClientList();
            System.out.println("Choisissez un client (id) : ");
            int clientId = scanner.nextInt();

            System.out.println("Client choisi : " + clientId);

//            displayEventList();
            System.out.println("Choisissez un événement : ");
            int eventId = scanner.nextInt();

            if (purchase) {
                tiketingService.buyTickets(clientId, eventId, 1);
                System.out.println("Billet acheté avec succès");
            } else {
                tiketingService.cancelTickets(clientId, eventId, 1);
                System.out.println("Billet annulé avec succès");
            }

            menuClient();
        } catch (InputMismatchException e) {
            System.out.println("Entrer une valeur numérique ");
            scanner.next();
            buyTickets(purchase);
        }
    }


//    private void displayClientList() {
//    }
//
//    private void displayEventList() {
//
//    }



}

