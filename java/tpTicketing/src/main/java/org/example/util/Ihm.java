package org.example.util;

import org.example.model.Event;
import org.example.service.TiketingService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Ihm {
        private Scanner scanner = new Scanner(System.in);

        private TiketingService tiketingService = new TiketingService();


    public void start() {
        this.GeneralMenu();
    }

    public void GeneralMenu (){
        try{
            System.out.println("----------menu---------");
            System.out.println("1/ action Lieux");
            System.out.println("2/ action Evenements");
            System.out.println("3/ action client");
            System.out.println("0/ quitter");
            System.out.println("entrer votre choix :");
            int entry = scanner.nextInt();
            switch (entry){
                case 1:
                    this.menuPlace();
                    break;
                case 2 :
                    this.menuEvent();
                    break;
                case 3:
                    break;
                case 0 :
                    break;
                default:
                    System.out.println("entrer une valeur correspondant a un choix");
                    this.GeneralMenu();
                    break;
            }

        }
        catch (InputMismatchException e){
            System.out.println("entrer une valeur numerique ");
            this.GeneralMenu();
        }
        finally{
            scanner.close();
            TiketingService.close();
        }

    }

    public void menuPlace(){
        try{
            System.out.println("----------menu Lieux---------");
            System.out.println("1/ ajouter un lieu");
            System.out.println("2/ modifier un lieu");
            System.out.println("3/ supprimer un lieu");
            System.out.println("0/ retourner au menu generale");
            System.out.println("entrer votre choix :");
            int entry = scanner.nextInt();
            switch (entry){
                case 1:
                    this.addPlace();
                    break;
                case 2:
                    this.updatePlace();
                    break;
                case 3 :
                    this.deletePlace();
                    break;
                case 0:
                    this.GeneralMenu();
                    break;
                default :
                    System.out.println("entrer une valeur correspondant a un choix");
                    this.menuPlace();
                    break;
            }
        }
        catch (InputMismatchException e){
            System.out.println("entrer une valeur numerique ");
            this.menuPlace();
        }

    }

    public void addPlace(){
        try {
            System.out.println("--------ajouter lieu----------");
            System.out.println("entrer le nom du lieu :");
            String namePlace = scanner.next();
            System.out.println("entrer l'adresse du lieu :");
            String adressePlace = scanner.next();
            int capacity = this.entryCapacity();
            scanner.nextLine();

            if(tiketingService.addPlace(namePlace,adressePlace,capacity)){
                System.out.println("Lieux ajoutée avec succés");
            }else{
                System.out.println("Erreur");
            }

        }
        catch (InputMismatchException e){
            System.out.println("entrer une valeur numerique ");

        }
    }

    public int entryCapacity (){
        int entry =0;
        do {
            System.out.println("entrer la capacité du lieu :");
            entry = scanner.nextInt();
        }
        while (entry<=0);

        return entry;
    }

    public void updatePlace() {
        try {
            System.out.println("--------Modifier lieu----------");
            System.out.println("Quel lieu souhaitez-vous modifier entrer l'id : ");
            int placeId = scanner.nextInt();

            System.out.println("Entrer le nouveau nom : ");
            String newName = scanner.next();
            System.out.println("Entrer la nouvelle adresse : ");
            String newAddress = scanner.next();
            int newCapacity = entryCapacity();

            if (tiketingService.updatePlace(placeId, newName, newAddress, newCapacity)) {
                System.out.println("Lieu mis à jour avec succès");
            } else {
                System.out.println("Erreur lors de la mise à jour du lieu");
            }

            menuPlace();
        } catch (InputMismatchException e) {
            System.out.println("Entrer une valeur numérique ");
            scanner.next();
            updatePlace();
        }
    }


    public void deletePlace (){
        try{
            System.out.println("--------supr lieu----------");

            System.out.println("quelle lieux vouler vous supprimer (0 pour retour) : ");
            int entry = scanner.nextInt();

            if (tiketingService.deletePlace(entry)) {
                System.out.println("Lieu supprimer avec succès");
            } else {
                System.out.println("Erreur lors de la supression du lieu");
            }
        }
        catch( InputMismatchException e){
            System.out.println("entrer une valeur numerique ");
            this.deletePlace();
        }
    }


    public void menuEvent (){
        try{
            System.out.println("----------menu Evenement---------");
            System.out.println("1/ ajouter un Evenement");
            System.out.println("2/ modifier un Evenement");
            System.out.println("3/ supprimer un Evenement");
            System.out.println("4/ afficher la liste des evenements");
            System.out.println("0/ retourner au menu generale");
            System.out.println("entrer votre choix :");
            int entry = scanner.nextInt();
            switch (entry){
                case 1:
                    this.addEvent();
                    break;
                case 2:
                    this.updateEvent();
                    break;
                case 3 :
                    this.deleteEvent();
                    break;
                case 4 :
                    this.displayAllEvents();
                    break;
                case 0:
                    this.GeneralMenu();
                    break;
                default :
                    System.out.println("entrer une valeur correspondant a un choix");
                    this.menuEvent();
                    break;
            }
        }
        catch (InputMismatchException e){
            System.out.println("entrer une valeur numerique ");
            this.GeneralMenu();
        }
    }


    public void addEvent() {
        try {
            System.out.println("--------Ajouter Événement----------");

            System.out.println("Entrer le nom de l'événement :");
            String nom = scanner.next();

            System.out.println("Entrer la date de l'événement (format dd-MM-yyyy) :");
            String date_string = scanner.next();
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate dateEvent = LocalDate.parse(date_string, dateFormatter);

            System.out.println("Entrer l'heure de l'événement (format HH:mm) :");
            String heure_string = scanner.next();
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime heure = LocalTime.parse(heure_string, timeFormatter);

            System.out.println("Sélectionner le lieu de l'événement (Id du lieux lol) :");
            int lieu = scanner.nextInt();

            System.out.println("Entrer le prix du billet :");
            double prix = scanner.nextDouble();

            if (tiketingService.addEvent(nom, dateEvent, heure, lieu, prix)) {
                System.out.println("Événement ajouté avec succès");
            } else {
                System.out.println("Erreur lors de l'ajout de l'événement");
            }
        } catch (DateTimeParseException | InputMismatchException e) {
            System.out.println("Format de date/heure incorrect ou entrée non numérique");
        }
    }

    public void updateEvent() {
        try {
            System.out.println("--------Modifier Événement----------");
            System.out.println("Quel événement souhaitez-vous modifier (entrez l'ID) : ");
            int eventId = scanner.nextInt();

            System.out.println("Entrer le nouveau nom : ");
            String newName = scanner.next();
            System.out.println("Entrer la nouvelle date (format dd-MM-yyyy) : ");
            String newDateString = scanner.next();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date newDate = formatter.parse(newDateString);
            System.out.println("Entrer la nouvelle heure (format HH:mm) : ");
            String newTimeString = scanner.next();
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime newTime = LocalTime.parse(newTimeString, timeFormatter);
            System.out.println("Entrer le nouvel ID du lieu : ");
            int newPlaceId = scanner.nextInt();
            System.out.println("Entrer le nouveau prix : ");
            double newPrice = scanner.nextDouble();

            if (tiketingService.updateEvent(eventId, newName, newDate, newTime, newPlaceId, newPrice)) {
                System.out.println("Événement mis à jour avec succès");
            } else {
                System.out.println("Erreur lors de la mise à jour de l'événement");
            }


            menuEvent();
        } catch (InputMismatchException | ParseException | DateTimeParseException e) {
            System.out.println("Format de date/heure incorrect ou entrée non numérique");
            scanner.next();
            updateEvent();
        }
    }
    public void deleteEvent() {
        try {
            System.out.println("--------Supprimer Événement----------");

            System.out.println("Entrer l'ID de l'événement à supprimer :");
            int eventId = scanner.nextInt();

            if (tiketingService.deleteEvent(eventId)) {
                System.out.println("Événement supprimé avec succès");
            } else {
                System.out.println("Erreur lors de la suppression de l'événement");
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrer une valeur numérique ");
            scanner.next();
            deleteEvent();
        }
    }

    public void displayAllEvents() {

            List<Event> events = tiketingService.getAllEvents();

            if (events.isEmpty()) {
                System.out.println("Aucun événement trouvé.");
            } else {
                System.out.println("Liste des événements :");
                for (Event event : events) {
                    System.out.println(event);
                }
            }
    }






}
