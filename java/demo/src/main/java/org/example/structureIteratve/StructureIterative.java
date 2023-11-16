package org.example.structureIteratve;

import java.util.Scanner;

public class StructureIterative {
    static Scanner scanner = new Scanner(System.in);

    public static void exoUn() {
        int nb1 = 0;


        while (nb1 < 1 || nb1 > 3) {
            System.out.println("Entrer un nombre ?");
            nb1 = scanner.nextInt();
        }
        scanner.close();
    }

    public static void exoDeux() {
        int nb1 = 0;

        while (nb1 < 10 || nb1 > 20) {
            if (nb1 > 20) {
                System.out.println("Plus petit !!");
            } else if (nb1 < 10) {
                System.out.println("Plus grand !!");
            }
            System.out.println("Entrer un nombre ?");
            nb1 = scanner.nextInt();
        }
        scanner.close();

    }

    public static void exoTrois() {
        System.out.println("Entrer un nombre ?");
        int nb1 = scanner.nextInt();
        for (int i = 0; i <= 10; i++) {
            System.out.println(++nb1);
            ;
        }
        scanner.close();

    }

    public static void exoQuatre() {

        System.out.println("Entrer un nombre ?");
        int nb1 = scanner.nextInt();
        for (int i = 0; i <= 10; i++) {
            System.out.println(nb1 + "x" + i + "=" + nb1 * i);
        }
    }

    public static void exoCinq() {

        System.out.println("Entrer un nombre ?");
        int nb1 = scanner.nextInt();
        int resultat = 0;
        for (int i = 0; i <= nb1; i++) {
            resultat = i + resultat;
        }
        System.out.println(resultat);
        scanner.close();
    }

    public static void exoSix() {

        int nombre = 0;
        int plusGrand = 0;

        for (int i = 1; i <= 5; i++) {
            System.out.print("Entrez le nombre numéro " + i + " : ");
            nombre = scanner.nextInt();

            if (nombre > plusGrand) {
                plusGrand = nombre;
            }
        }

        System.out.println("Le plus grand de ces nombres est : " + plusGrand);
    }

    public static void exoHuit() {


        int nombre = 0;
        int plusGrand = 0;
        int position = 0;

        for (int i = 1; i <= 5; i++) {
            System.out.print("Entrez le nombre numéro " + i + " : ");
            nombre = scanner.nextInt();

            if (nombre > plusGrand) {
                plusGrand = nombre;
                position = i;
            }
        }

        System.out.println("Le plus grand de ces nombres est : " + plusGrand);
        System.out.println("C'était le nombre numéro " + position);

        scanner.close();
    }

    public static void exoNeuf() {

        System.out.println("Entrer un nombre ?");
        int nb1 = scanner.nextInt();
        int resultat = 0;
        System.out.println("La factorielle de " + nb1 + " vaut, ");
        for (int i = 1; i <= nb1; i++) {
            System.out.print(i + "x");
            resultat = nb1 * resultat;
        }
        System.out.println("=" + resultat);
        scanner.close();

    }

    public static void exoDix() {

        int nombre = -1;
        int plusGrand = 0;
        int position = 0;
        int i = 0;

        while (nombre != 0) {
            i++;
            System.out.print("Entrez le nombre numéro " + i + " : ");
            nombre = scanner.nextInt();

            if (nombre > plusGrand) {
                plusGrand = nombre;
                position = i;
            }
        }
        System.out.println("Le plus grand de ces nombres est : " + plusGrand);
        System.out.println("C'était le nombre numéro " + position);

        scanner.close();
    }

    public static void exoOnze() {

        int saisi = -1;
        int somme = 0;
        int sommeDonnee;


        while (saisi != 0) {
            System.out.print("Entrer prix article (0 pour terminer) : ");
            saisi = scanner.nextInt();


            somme += saisi;
        }

        System.out.println("Total à payer : " + somme);

        System.out.print("Entrer la somme à donnée (supérieur ou égal au total à payer) : ");
        sommeDonnee = scanner.nextInt();

        int monnaie = sommeDonnee - somme;


        while (monnaie > 0) {
            if (monnaie >= 10) {
                System.out.println("10 Euros");
                monnaie -= 10;
            } else if (monnaie >= 5) {
                System.out.println("5 Euros");
                monnaie -= 5;
            } else {
                System.out.println("1 Euro");
                monnaie -= 1;
            }
        }

    }

    public static void exoDouze() {

        int resultat = 0;
        int i = 0;
        while (resultat < 100) {
            i++;
            resultat = i + resultat;

        }

        System.out.println(resultat);
        System.out.println(i);

    }
}


