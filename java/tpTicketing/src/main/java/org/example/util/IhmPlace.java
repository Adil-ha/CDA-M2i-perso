package org.example.util;

import org.example.service.TiketingService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IhmPlace {
    private TiketingService tiketingService = new TiketingService();
    private Scanner scanner = new Scanner(System.in);

    public void menuPlace() {
        try {
            System.out.println("----------menu Lieux---------");
            System.out.println("1/ ajouter un lieu");
            System.out.println("2/ modifier un lieu");
            System.out.println("3/ supprimer un lieu");
            System.out.println("0/ retourner au menu generale");
            System.out.println("entrer votre choix :");
            int entry = scanner.nextInt();
            switch (entry) {
                case 1:
                    addPlace();
                    break;
                case 2:
                    updatePlace();
                    break;
                case 3:
                    deletePlace();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("entrer une valeur correspondant a un choix");
                    menuPlace();
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("entrer une valeur numerique ");
            menuPlace();
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
            menuPlace();
        }
        catch( InputMismatchException e){
            System.out.println("entrer une valeur numerique ");
            deletePlace();
        }
    }
}
