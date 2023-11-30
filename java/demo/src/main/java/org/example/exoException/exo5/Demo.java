package org.example.exoException.exo5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Demo {

    public static void createTabFromConsole() throws ArrayEmptyException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Combien d'éléments dans le tableau ?");
        int nb = scanner.nextInt();

        if (nb == 0) {
            throw new ArrayEmptyException("Le tableau est vide");
        }

        int[] tab = new int[nb];
        int cpt = 0;

        while (cpt < nb) {
            try {
                System.out.println("Entrer un nombre :");
                tab[cpt] = scanner.nextInt();
                cpt++;
            } catch (InputMismatchException e) {

                System.out.println("Erreur de saisie, veuillez entrer un nombre entier.");
                scanner.next();
            }
        }

        int sum = 0;

        for (int num : tab) {
            sum += num;
        }

        System.out.println("La somme des éléments du tableau est : " + sum);
    }

    public static void main(String[] args) {
        try {
            createTabFromConsole();
        } catch (ArrayEmptyException e) {
            System.out.println(e.getMessage());
        }
    }
}
