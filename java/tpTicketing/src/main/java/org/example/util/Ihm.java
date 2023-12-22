package org.example.util;

import org.example.service.TiketingService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ihm {
    private Scanner scanner = new Scanner(System.in);
    private IhmPlace ihmPlace = new IhmPlace();
    private IhmEvent ihmEvent = new IhmEvent();
    private IhmClient ihmClient = new IhmClient();

    public void start() {
        this.generalMenu();
    }

    private void generalMenu() {
        try {
            System.out.println("----------menu---------");
            System.out.println("1/ action Lieux");
            System.out.println("2/ action Evenements");
            System.out.println("3/ action client");
            System.out.println("0/ quitter");
            System.out.println("entrer votre choix :");
            int entry = scanner.nextInt();
            switch (entry) {
                case 1:
                    ihmPlace.menuPlace();
                    break;
                case 2:
                    ihmEvent.menuEvent();
                    break;
                case 3:
                    ihmClient.menuClient();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("entrer une valeur correspondant a un choix");
                    generalMenu();
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("entrer une valeur numerique ");
            generalMenu();
        } finally {
            TiketingService.close();
        }
    }
}

