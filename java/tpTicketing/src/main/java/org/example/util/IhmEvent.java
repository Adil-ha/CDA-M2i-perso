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

public class IhmEvent {
    private TiketingService tiketingService = new TiketingService();
    private Scanner scanner = new Scanner(System.in);

    public void menuEvent() {
        try {
            System.out.println("----------menu Evenement---------");
            System.out.println("1/ ajouter un Evenement");
            System.out.println("2/ modifier un Evenement");
            System.out.println("3/ supprimer un Evenement");
            System.out.println("4/ afficher la liste des evenements");
            System.out.println("0/ retourner au menu generale");
            System.out.println("entrer votre choix :");
            int entry = scanner.nextInt();
            switch (entry) {
                case 1:
                    addEvent();
                    break;
                case 2:
                    updateEvent();
                    break;
                case 3:
                    deleteEvent();
                    break;
                case 4:
                    displayAllEvents();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("entrer une valeur correspondant a un choix");
                    menuEvent();
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("entrer une valeur numerique ");
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
            menuEvent();

        } catch (DateTimeParseException | InputMismatchException e) {
            System.out.println("Format de date/heure incorrect ou entrée non numérique");
            addEvent();
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
            menuEvent();
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

